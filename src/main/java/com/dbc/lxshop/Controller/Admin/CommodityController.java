package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Service.CommodityService;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-19 18:11
 **/
@Controller
@RequestMapping("/Admin/Commodity")
public class CommodityController {
    @Qualifier("commodityService")
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(method = RequestMethod.GET, value = "/Record")
    public String record(ModelMap modelMap){
        return "admin/commodity/record";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddCommodity")
    @ResponseBody
    public Map<String, Object> addCommodity(String title, String afterSale, String kindName, String model, String material,
                                            String struct, String style, String use, String saleMethod, String unit, String shelves,
                                            String home, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.addCommodity(title, afterSale, kindName, model, material,
                struct, style, use, saleMethod, unit, shelves, home));
        /*LGoodsEntity lGoodsEntity = commodityService.listOCommodity(title);
        if(lGoodsEntity == null) map.put("id", "0");
        else {
            map.put("id", lGoodsEntity.getId());
            if(lGoodsEntity.getIsShelves() == 0) map.put("shelves", "已下架<i class=\"fa fa-check text-navy\"></i>");
            else map.put("shelves", "上架中<i class=\"fa fa-times text-navy\"></i>");
        }*/
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/CommodityList")
    @ResponseBody
    public Map<String, Object> commodityList(HttpServletResponse httpServletResponse,
                                             HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LGoodsEntity> list = commodityService.listCommodity();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodity")
    @ResponseBody
    public Map<String, Object> deleteCommodity(String id, HttpServletRequest httpServletRequest,
                                               HttpServletResponse httpServletResponse){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.deleteCommodity(Integer.parseInt(id)));
        return map;
    }

    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    public CommodityService getCommodityService() {
        return commodityService;
    }
}
