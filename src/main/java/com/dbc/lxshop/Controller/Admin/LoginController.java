package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Entity.LAdminEntity;
import com.dbc.lxshop.Service.AdminService;
import com.dbc.lxshop.Utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
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
    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.GET, value = "/Login")
    public String adminLogin(ModelMap modelMap){
        return "admin/login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/LoginCheck")
    @ResponseBody
    public Map<String, Object> loginCheck(String mobile, String password, HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse, ModelMap modelMap){
        return adminService.checkLogin(mobile, password);
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
