package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;

import java.util.List;

public interface GoodsCategoryDao {
    public boolean addGoodsCategory(LGoodsCategoryEntity lGoodsCategoryEntity);
    public boolean deleteGoodsCategory(int id);
    public boolean updateGood(LGoodsCategoryEntity lGoodsCategoryEntity);
    public LGoodsCategoryEntity listById(int id);
    public List<LGoodsCategoryEntity> list();
    public List<LGoodsCategoryEntity> listByFirst();
    public List<LGoodsCategoryEntity> listBySecond();
}
