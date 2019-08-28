package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LFactoryGoodsEntity;

public interface FactoryGoodsDao {
    public boolean addFactoryGoods(LFactoryGoodsEntity lFactoryGoodsEntity);
    public boolean deleteFactoryGoods(int factoryGoodsId);
    public boolean updateFactoryGoods(LFactoryGoodsEntity lFactoryGoodsEntity);
    public boolean listByFactoryId(int factoryId);
}
