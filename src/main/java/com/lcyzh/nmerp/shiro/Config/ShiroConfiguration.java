package com.lcyzh.nmerp.shiro.Config;

import com.lcyzh.nmerp.service.security.FormAuthenticationFilter;
import com.lcyzh.nmerp.service.security.SystemAuthorizingRealm;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        // 表单过滤器
        Map<String, Filter> authc = new LinkedHashMap<>();
        authc.put("authc",new FormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(authc);
        loadShiroFilterChain(shiroFilterFactoryBean);

        return shiroFilterFactoryBean;
    }

    /**
     * 加载ShiroFilter权限控制规则
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean factoryBean) {
        /** 下面这些规则配置最好配置到配置文件中 */
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();
        /**
         * authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器 org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         * anon：它对应的过滤器里面是空的,什么都没做,可以理解为不拦截
         * authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
         */
        filterChainMap.put("/static/**","anon");
        filterChainMap.put("/login", "authc");
        filterChainMap.put("/logout", "logout");
        filterChainMap.put("/crm/**", "authc");
        filterChainMap.put("/**", "authc");

        factoryBean.setFilterChainDefinitionMap(filterChainMap);
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(
            SystemAuthorizingRealm myShiroRealm, DefaultWebSessionManager sessionManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm);	// 设置realm
        securityManager.setSessionManager(sessionManager); // 会话管理
        return securityManager;
    }

    /**
     * 授权验证
     * @param ehCacheManager
     * @return
     */
    @Bean(name = "myShiroRealm")
    public SystemAuthorizingRealm myShiroRealm(EhCacheManager ehCacheManager) {
        SystemAuthorizingRealm realm = new SystemAuthorizingRealm();
        realm.setCacheManager(ehCacheManager);
        return realm;
    }

    /**
     * session会话管理
     * @return
     */
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setSessionValidationInterval(120000);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }

    @Bean
    public EhCacheManager ehCacheManager(CacheManager cacheManager) {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManager(cacheManager);
        return em;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean(name = "cacheManager")
    public CacheManager cacheManager(){
        return new CacheManager();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /*
     * 方法体对应的说明 供参考
     * 1.LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，负责org.
     * apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。主要是AuthorizingRealm类的子类，
     * 以及EhCacheManager类。
     * 2.HashedCredentialsMatcher，这个类是为了对密码进行编码的，防止密码在数据库里明码保存，当然在登陆认证的生活，
     * 这个类也负责对form里输入的密码进行编码。
     * 3.ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm，负责用户的认证和权限的处理，可以参考JdbcRealm的实现。
     * 4.EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，然后每次用户请求时，放入用户的session中，
     * 如果不设置这个bean，每个请求都会查询一次数据库。
     * 5.SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理，是个比较重要的类。
     * 6.ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。它主要保持了三项数据，
     * securityManager，filters，filterChainDefinitionManager。
     * 7.DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     * 8.AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
     */

}
