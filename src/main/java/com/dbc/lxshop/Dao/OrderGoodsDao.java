package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LOrderGoodsEntity;

import java.util.List;

public interface OrderGoodsDao {
    public boolean addOrderGoods(LOrderGoodsEntity lOrderGoodsEntity);
    public boolean deleteOrderGoods(int orderGoodsId);
    public List<LOrderGoodsEntity> listByOrderId(int orderId);
}
