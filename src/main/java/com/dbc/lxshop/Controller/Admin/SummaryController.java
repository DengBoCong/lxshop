package com.dbc.lxshop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-17 16:03
 **/
@Controller
@RequestMapping("/Admin/Summary")
public class SummaryController {


    @RequestMapping(method = RequestMethod.GET, value = "/Profile")
    public String profile(ModelMap modelMap){

        return "admin/summary/profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Flow")
    public String flow(ModelMap modelMap){
        return "admin/summary/flow";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/User")
    public String user(ModelMap modelMap){
        return "admin/summary/user";
    }
}
