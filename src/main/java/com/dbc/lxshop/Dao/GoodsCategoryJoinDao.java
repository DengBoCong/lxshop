package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Bean.GoodsCategoryBean;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;

import java.util.List;

public interface GoodsCategoryJoinDao {
    public boolean addGoodsCategoryJoin(LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity);
    public boolean deleteGoodsCategoryJoin(int id);
    public List<LGoodsCategoryJoinEntity> listByGoodsId(int goodsId);
    /*public List<GoodsCategoryBean> listByGoodsIdBean(int goodsId);
    public GoodsCategoryBean listOByGoodsIdBean(int goodsId, int category);*/
    public LGoodsCategoryJoinEntity listByGoodsIdCategoryId(int goodsId, int categoryId);
}
