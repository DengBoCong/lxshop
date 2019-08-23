package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Bean.GoodsCategoryBean;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;
import com.dbc.lxshop.Model.Entity.LGoodsPhotoEntity;
import com.dbc.lxshop.Model.Entity.LGoodsStandradEntity;

import java.util.List;

public interface CommodityDetailsService {
    public List<LGoodsStandradEntity> listCommodityStandrad(int goodsId);
    public String addCommodityStandrad(String goodId, String measure, String color, String inventory, String factoryPrice,
                                       String originPrice, String guidePrice);
    public String deleteCommodityStandrad(String id);
    public String updateCommodityStandrad(String id, String measure, String color, String inventory, String factoryPrice,
                                          String originPrice, String guidePrice);
    public LGoodsStandradEntity listCommodityGoodsIdMeasureColor(String goodsId, String measure, String color);

    public List<LGoodsPhotoEntity> listCommodityGoodsPhotoByGoodsId(int goodsId);
    public String addCommodityPhoto(String goodsId, String images, String sort);
    public String listCommodityPhotoId(String goodsId, String images);
    public String deleteCommodityPhoto(String photoId);
    public String updateCommodityPhoto(String photoId, String sort);

    /*public List<GoodsCategoryBean> listCommodityCategoryByGoodId(int goodsId);
    public GoodsCategoryBean listOCommodityCategoryByGoodId(int goodsId, int category);*/
    public List<LGoodsCategoryEntity> listCommodityCategoryByPid(int pid);
    public String addCommodityCategoryJoin(int goodsId, int categoryId);
    public List<LGoodsCategoryJoinEntity> listCommodityCategoryJoinByGoodsId(int goodsId);
    public LGoodsCategoryJoinEntity listCommodityCategoryByGoodIdCategoryId(int goodsId, int categoryId);
    public String deleteCommodityCategoryById(int id);
}
