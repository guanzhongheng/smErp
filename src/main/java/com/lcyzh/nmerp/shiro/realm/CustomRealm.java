package com.lcyzh.nmerp.shiro.realm;

import com.lcyzh.nmerp.service.security.SystemService;
import com.lcyzh.nmerp.service.TSysRoleService;
import com.lcyzh.nmerp.service.TSysUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * @Project : nm-erp
 * @Description : 用户验证和授权
 * @Author : chh
 * @Iteration : 1.0
 * @Date : 2019/07/01
 * @ModificationHistory Who          When          What
 */
public class CustomRealm extends AuthorizingRealm {
    private Logger logger = Logger.getLogger(CustomRealm.class);

    private String ClassName =this.getClass().getName();

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    @Lazy
    private TSysUserService sysUserService;
    @Autowired
    @Lazy
    private TSysRoleService sysRoleService;
    @Autowired
    @Lazy
    private SystemService systemService;

    {
        super.setName(ClassName);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
    //    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        TSysUser user  = (TSysUser)principals.getPrimaryPrincipal();
//        List<TSysRole> roles = sysRoleService.findByUserId(user.getUserId());
//        if(!roles.isEmpty()) {
//            for(TSysRole role : roles) {
//                authorizationInfo.addRole(role.getRoleName());
//            }
//            List<TSysMenu> menus = systemService.getMenu(user.getUserId());
//            List<Menu> menus = systemService.getMenu(user.getUserId());
//            if(!menus.isEmpty()) {
//                for(TSysMenu menu : menus) {
//                    authorizationInfo.addStringPermission(menu.getPermission());
//                }
//            }
//        }else{
//            if (logger.isDebugEnabled()) {
//                logger.debug(" user role not exist...");
//            }
//        }
//        return authorizationInfo;
//    }
//
//    /**
//     * 登录认证
//     * @param token
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //获取用户的输入的账号.
//        String username = (String)token.getPrincipal();
//        //通过username从数据库中查找 User对象，如果找到，没找到.
//        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        TSysUser user = sysUserService.findByUserName(username);
//        if(user == null){
//            if (logger.isDebugEnabled()) {
//                logger.debug("user not exist!");
//            }
//            return null;
//        }else{
//            List<TSysRole> roles = sysRoleService.findByUserId(user.getUserId());
//            if(!roles.isEmpty()) {
//                user.setRoles(roles);
//                List<TSysMenu> menus = sysMenuService.findByUserId(user.getUserId());
//                if(!menus.isEmpty()) {
//                    user.setMenus(menus);
//                }
//            }
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user, //用户名
//                user.getPassword(), //密码
//                //ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
//                this.getName()  //realm name
//        );
//        return authenticationInfo;
//    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
