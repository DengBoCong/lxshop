package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;

import java.util.List;

public interface GoodsCategoryJoinDao {
    public boolean addGoodsCategoryJoin(LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity);
    public boolean deleteGoodsCategoryJoin(int id);
    public List<LGoodsCategoryJoinEntity> listByGoodsId(int goodsId);
}
