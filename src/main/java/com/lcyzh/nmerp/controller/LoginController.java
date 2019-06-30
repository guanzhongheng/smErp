package com.lcyzh.nmerp.controller;

import com.google.common.collect.Maps;
import com.lcyzh.nmerp.common.config.Global;
import com.lcyzh.nmerp.common.lang.StringUtils;
import com.lcyzh.nmerp.common.utils.CacheUtils;
import com.lcyzh.nmerp.common.web.CookieUtils;
import com.lcyzh.nmerp.controller.common.BaseController;
import com.lcyzh.nmerp.controller.system.security.SystemAuthorizingRealm.Principal;
import com.lcyzh.nmerp.controller.system.util.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 项目名称：nm-erp
 * 类 名 称：LoginController
 * 类 描 述：TODO
 * 创建时间：2019/6/28 1:00 PM
 * 创 建 人：guan
 */
@Controller
public class LoginController extends BaseController {


    /**
     * 管理登录
     */
    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
       // Principal principal = UserUtils.getPrincipal();



//        if (logger.isDebugEnabled()){
//            logger.debug("login, active session size: {}", sessionDAO.getActiveSessions(false).size());
//        }
//
//        // 如果已登录，再次访问主页，则退出原账号。
//        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
//            CookieUtils.setCookie(response, "LOGINED", "false");
//        }
//
//        // 如果已经登录，则跳转到管理首页
//        if(principal != null && !principal.isMobileLogin()){
//            return "redirect:" + adminPath;
//        }
//		String view;
//		view = "/WEB-INF/views/modules/sys/sysLogin.jsp";
//		view = "classpath:";
//		view += "jar:file:/D:/GitHub/jeesite/src/main/webapp/WEB-INF/lib/jeesite.jar!";
//		view += "/"+getClass().getName().replaceAll("\\.", "/").replace(getClass().getSimpleName(), "")+"view/sysLogin";
//		view += ".jsp";
        return "modules/sys/sysLogin";
    }


    /**
     * 登录成功，进入管理首页
     */
   // @RequiresPermissions("user")
    @RequestMapping(value = "index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        Principal principal = UserUtils.getPrincipal();

        // 登录成功后，验证码计算器清零
//        isValidateCodeLogin(principal.getLoginName(), false, true);
//
//        if (logger.isDebugEnabled()){
//           // logger.debug("show index, active session size: {}", sessionDAO.getActiveSessions(false).size());
//        }
//
//        // 如果已登录，再次访问主页，则退出原账号。
//        if (Global.TRUE.equals(Global.getConfig("notAllowRefreshIndex"))){
//            String logined = CookieUtils.getCookie(request, "LOGINED");
//            if (StringUtils.isBlank(logined) || "false".equals(logined)){
//                CookieUtils.setCookie(response, "LOGINED", "true");
//            }else if (StringUtils.equals(logined, "true")){
//                UserUtils.getSubject().logout();
//                return "redirect:" + adminPath + "/login";
//            }
//        }
//        // 如果是手机登录，则返回JSON字符串
//        if (principal.isMobileLogin()){
//            if (request.getParameter("login") != null){
//                return renderString(response, principal);
//            }
//            if (request.getParameter("index") != null){
//                return "modules/sys/sysIndex";
//            }
//            return "redirect:" + adminPath + "/login";
//        }

        return "modules/sys/sysIndex";
    }

    /**
     * 是否是验证码登录
     * @param useruame 用户名
     * @param isFail 计数加1
     * @param clean 计数清零
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean){
        Map<String, Integer> loginFailMap = (Map<String, Integer>) CacheUtils.get("loginFailMap");
        if (loginFailMap==null){
            loginFailMap = Maps.newHashMap();
            CacheUtils.put("loginFailMap", loginFailMap);
        }
        Integer loginFailNum = loginFailMap.get(useruame);
        if (loginFailNum==null){
            loginFailNum = 0;
        }
        if (isFail){
            loginFailNum++;
            loginFailMap.put(useruame, loginFailNum);
        }
        if (clean){
            loginFailMap.remove(useruame);
        }
        return loginFailNum >= 3;
    }
}
