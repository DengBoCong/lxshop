package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsEntity;

import java.util.List;

public interface GoodsDao {
    public boolean addGoods(LGoodsEntity lGoodsEntity);
    public boolean deleteGoods(int id);
    public boolean updateGoods(LGoodsEntity lGoodsEntity);
    public LGoodsEntity listById(int id);
    public LGoodsEntity listByTile(String title);
    public long listLastTimeGoodsCount(int mills);
    public long listBtwTimeGoodsCount(int beginMills, int endMills);
    public long listGoodsCount();
    public List<LGoodsEntity> listTopNByTime(int mills, int n);
}
