package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-24 23:09
 **/
@Controller
@RequestMapping("/Admin/Area")
public class AreaController {
    @Qualifier("areaService")
    @Autowired
    private AreaService areaService;

    @RequestMapping(method = RequestMethod.GET, value = "/Divide")
    public String divide(ModelMap modelMap){
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        return "admin/area/divide";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Principal")
    public String principal(ModelMap modelMap){
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SalesmanTopList", areaService.listSalesmanUserTop());
        return "admin/area/principal";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddAreaInfo")
    @ResponseBody
    public Map<String, Object> addAreaInfo(String areaName, String areaDescription, String areaSalesman, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.addArea(areaName, areaDescription, areaSalesman));
        map.put("manInfo", areaService.listOneAreaByName(areaName));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteArea")
    @ResponseBody
    public Map<String, Object> deleteArea(String areaId, HttpServletResponse httpServletResponse,
                                          HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.deleteArea(Integer.parseInt(areaId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateArea")
    @ResponseBody
    public Map<String, Object> updateArea(String areaId, String areaName, String areaDescription, String areaSalesman,
                                          HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.updateArea(areaId, areaName, areaDescription, areaSalesman));
        return map;
    }

    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    public AreaService getAreaService() {
        return areaService;
    }
}
