package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Entity.LOrderEntity;
import com.dbc.lxshop.Service.OrderService;
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
 * @create: 2019-08-28 10:13
 **/
@Controller
@RequestMapping("/Admin/Order")
public class OrderController {
    @Qualifier("orderService")
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "/AllOrder")
    public String allOrder(ModelMap modelMap){
        return "admin/order/allOrder";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/OrderList")
    @ResponseBody
    public Map<String, Object> orderList(HttpServletResponse httpServletResponse,
                                             HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LOrderEntity> list = orderService.listOrder();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Distribute")
    public String distributeList(ModelMap modelMap){
        return "admin/order/distribute";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/OrderDistributeList")
    @ResponseBody
    public Map<String, Object> orderDistributeList(String status, HttpServletResponse httpServletResponse,
                                             HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LOrderEntity> list = orderService.listOrderByStatus(Integer.parseInt(status));
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateOrderFactoryId")
    @ResponseBody
    public Map<String, Object> updateOrderFactoryId(String orderId, String factoryId, HttpServletResponse httpServletResponse,
                                                   HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LOrderEntity lOrderEntity = new LOrderEntity();
        lOrderEntity.setId(Integer.parseInt(orderId));
        lOrderEntity.setFactoryId(Integer.parseInt(factoryId));
        map.put("flag", orderService.updateOrderNon(lOrderEntity));
        return map;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
