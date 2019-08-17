package com.dbc.lxshop.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-17 16:55
 **/
@Controller
@RequestMapping("/Admin")
public class GlobalController {
    @RequestMapping(method = RequestMethod.GET, value = "/Test")
    public String test(ModelMap modelMap){
        return "admin/test";
    }
}
