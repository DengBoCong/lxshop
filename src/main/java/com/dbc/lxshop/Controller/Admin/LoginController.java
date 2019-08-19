package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: lxshop
 * @description: 登录主控制类
 * @author: DBC
 * @create: 2019-08-16 10:55
 **/
@Controller
@RequestMapping("/Admin")
public class LoginController {
    @Qualifier("loginService")
    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET, value = "/Login")
    public String adminLogin(ModelMap modelMap){
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/LoginCheck")
    @ResponseBody
    public Map<String, Object> loginCheck(String mobile, String password, HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse, ModelMap modelMap){
        return loginService.checkLogin(mobile, password);
    }

    public LoginService getAdminService() {
        return loginService;
    }

    public void setAdminService(LoginService adminService) {
        this.loginService = adminService;
    }
}
