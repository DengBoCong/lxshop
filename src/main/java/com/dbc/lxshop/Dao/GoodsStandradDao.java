package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsStandradEntity;

import java.util.List;

public interface GoodsStandradDao {
    public boolean addGoodsStandrad(LGoodsStandradEntity lGoodsStandradEntity);
    public boolean deleteGoodsStandrad(int id);
    public boolean updateGoodsStandrad(LGoodsStandradEntity lGoodsStandradEntity);
    public List<LGoodsStandradEntity> list();
    public List<LGoodsStandradEntity> listByGoodid(int goodId);
    public LGoodsStandradEntity listByGoodIdMeasureColor(int goodId, String measure, String color);
}
