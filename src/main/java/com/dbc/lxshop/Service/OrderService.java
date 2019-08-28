package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LOrderEntity;

import java.util.List;

public interface OrderService {
    public List<LOrderEntity> listOrder();
    public List<LOrderEntity> listOrderByStatus(int status);
    public String updateOrderNon(LOrderEntity lOrderEntity);
    public String updateOrder(LOrderEntity lOrderEntity);
}
