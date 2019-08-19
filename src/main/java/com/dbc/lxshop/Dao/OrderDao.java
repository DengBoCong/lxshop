package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LOrderEntity;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDao {
    public boolean addOrder(LOrderEntity lOrderEntity);
    public boolean deleteOrder(int id);
    public boolean updateOrder(LOrderEntity lOrderEntity);
    public LOrderEntity listById(int id);
    public List<LOrderEntity> listByUserId(int userId);
    public List<LOrderEntity> listByFactoryId(int factoryId);
    public List<LOrderEntity> listByOrderNo(String orderNo);
    public List<LOrderEntity> listByStatus(int status);
    public List<LOrderEntity> list();
    public BigDecimal listLastTimeSellCount(int mills);
    public BigDecimal listBtwTimeSellCount(int beginMills, int endMills);
    public long listLastTimeOrderCount(int mills);
    public long listBtwTimeOrderCount(int beginMills, int endMills);
    public BigDecimal listSellCount();
    public long listOrderCount();
}
