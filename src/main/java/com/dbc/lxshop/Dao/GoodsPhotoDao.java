package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsPhotoEntity;

import java.util.List;

public interface GoodsPhotoDao {
    public boolean addGoodsPhoto(LGoodsPhotoEntity lGoodsPhotoEntity);
    public boolean deleteGoodsPhoto(int id);
    public boolean updateGoodsPhoto(LGoodsPhotoEntity lGoodsPhotoEntity);
    public LGoodsPhotoEntity listById(int id);
    public List<LGoodsPhotoEntity> list();
    public List<LGoodsPhotoEntity> listByGoodsId(int goodsId);
    public LGoodsPhotoEntity listByGoodsIdImage(int goodsId, String image);
}
