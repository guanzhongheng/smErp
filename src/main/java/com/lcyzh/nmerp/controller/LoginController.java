package com.lcyzh.nmerp.controller;

import com.lcyzh.nmerp.controller.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
