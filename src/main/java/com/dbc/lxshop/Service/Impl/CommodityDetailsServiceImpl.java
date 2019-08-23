package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.GoodsCategoryDao;
import com.dbc.lxshop.Dao.GoodsCategoryJoinDao;
import com.dbc.lxshop.Dao.GoodsPhotoDao;
import com.dbc.lxshop.Dao.GoodsStandradDao;
import com.dbc.lxshop.Model.Bean.GoodsCategoryBean;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;
import com.dbc.lxshop.Model.Entity.LGoodsPhotoEntity;
import com.dbc.lxshop.Model.Entity.LGoodsStandradEntity;
import com.dbc.lxshop.Service.CommodityDetailsService;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.InitEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-22 16:16
 **/
@Service("commodityDetailsService")
@Transactional
public class CommodityDetailsServiceImpl implements CommodityDetailsService {
    @Qualifier("goodsStandradDao")
    @Autowired
    private GoodsStandradDao goodsStandradDao;

    @Qualifier("goodsPhotoDao")
    @Autowired
    private GoodsPhotoDao goodsPhotoDao;

    @Qualifier("goodsCategoryJoinDao")
    @Autowired
    private GoodsCategoryJoinDao goodsCategoryJoinDao;

    @Qualifier("goodsCategoryDao")
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Override
    public List<LGoodsStandradEntity> listCommodityStandrad(int goodsId) {
        System.out.println(goodsStandradDao.listByGoodid(goodsId));
        return goodsStandradDao.listByGoodid(goodsId);
    }

    @Override
    public String addCommodityStandrad(String goodId, String measure, String color, String inventory, String factoryPrice,
                                       String originPrice, String guidePrice) {
        LGoodsStandradEntity lGoodsStandradEntity = InitEntityUtil.InitLGoodsStandradEntity();
        lGoodsStandradEntity.setMeasure(measure);
        lGoodsStandradEntity.setColor(color);
        lGoodsStandradEntity.setInventory(Integer.parseInt(inventory));
        lGoodsStandradEntity.setFactoryPrice(new BigDecimal(factoryPrice));
        lGoodsStandradEntity.setOriginPrice(new BigDecimal(originPrice));
        lGoodsStandradEntity.setGuidePrice(new BigDecimal(guidePrice));
        lGoodsStandradEntity.setGoodsId(Integer.parseInt(goodId));
        lGoodsStandradEntity.setAddTime(DateUtil.NewDateInt());
        if(goodsStandradDao.addGoodsStandrad(lGoodsStandradEntity)) return "1";
        else return "0";
    }

    @Override
    public String deleteCommodityStandrad(String id) {
        if(goodsStandradDao.deleteGoodsStandrad(Integer.parseInt(id))) return "1";
        else return "0";
    }

    @Override
    public String updateCommodityStandrad(String id, String measure, String color, String inventory, String factoryPrice, String originPrice, String guidePrice) {
        LGoodsStandradEntity lGoodsStandradEntity = new LGoodsStandradEntity();
        lGoodsStandradEntity.setId(Integer.parseInt(id));
        lGoodsStandradEntity.setMeasure(measure);
        lGoodsStandradEntity.setColor(color);
        lGoodsStandradEntity.setInventory(Integer.parseInt(inventory));
        lGoodsStandradEntity.setFactoryPrice(new BigDecimal(factoryPrice));
        lGoodsStandradEntity.setOriginPrice(new BigDecimal(originPrice));
        lGoodsStandradEntity.setGuidePrice(new BigDecimal(guidePrice));
        if (goodsStandradDao.updateGoodsStandrad(lGoodsStandradEntity)) return "1";
        else return "0";
    }

    @Override
    public LGoodsStandradEntity listCommodityGoodsIdMeasureColor(String goodsId, String measure, String color) {
        return goodsStandradDao.listByGoodIdMeasureColor(Integer.parseInt(goodsId), measure, color);
    }

    @Override
    public List<LGoodsPhotoEntity> listCommodityGoodsPhotoByGoodsId(int goodsId) {
        return goodsPhotoDao.listByGoodsId(goodsId);
    }

    @Override
    public String addCommodityPhoto(String goodsId, String images, String sort) {
        LGoodsPhotoEntity lGoodsPhotoEntity = new LGoodsPhotoEntity();
        lGoodsPhotoEntity.setAddTime(DateUtil.NewDateInt());
        lGoodsPhotoEntity.setGoodsId(Integer.parseInt(goodsId));
        lGoodsPhotoEntity.setImages(images);
        lGoodsPhotoEntity.setSort((byte) Integer.parseInt(sort));
        if(goodsPhotoDao.addGoodsPhoto(lGoodsPhotoEntity)) return "1";
        else return "0";
    }

    @Override
    public String listCommodityPhotoId(String goodsId, String images) {
        LGoodsPhotoEntity lGoodsPhotoEntity = goodsPhotoDao.listByGoodsIdImage(Integer.parseInt(goodsId), images);
        if(lGoodsPhotoEntity == null) return "0";
        else return "" + lGoodsPhotoEntity.getId();
    }

    @Override
    public String deleteCommodityPhoto(String photoId) {
        if(goodsPhotoDao.deleteGoodsPhoto(Integer.parseInt(photoId))) return "1";
        else return "0";
    }

    @Override
    public String updateCommodityPhoto(String photoId, String sort) {
        LGoodsPhotoEntity lGoodsPhotoEntity = new LGoodsPhotoEntity();
        lGoodsPhotoEntity.setId(Integer.parseInt(photoId));
        lGoodsPhotoEntity.setSort((byte)Integer.parseInt(sort));
        if (goodsPhotoDao.updateGoodsPhoto(lGoodsPhotoEntity)) return "1";
        else return "0";
    }

    /*@Override
    public List<GoodsCategoryBean> listCommodityCategoryByGoodId(int goodsId) {
        return goodsCategoryJoinDao.listByGoodsIdBean(goodsId);
    }*/

    /*@Override
    public GoodsCategoryBean listOCommodityCategoryByGoodId(int goodsId, int category) {
        return goodsCategoryJoinDao.listOByGoodsIdBean(goodsId, category);
    }*/

    @Override
    public List<LGoodsCategoryEntity> listCommodityCategoryByPid(int pid) {
        return goodsCategoryDao.listByPid(pid);
    }

    @Override
    public String addCommodityCategoryJoin(int goodsId, int categoryId) {
        LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity = new LGoodsCategoryJoinEntity();
        lGoodsCategoryJoinEntity.setAddTime(DateUtil.NewDateInt());
        lGoodsCategoryJoinEntity.setCategoryId(categoryId);
        lGoodsCategoryJoinEntity.setGoodsId(goodsId);
        System.out.println(goodsId);
        System.out.println(categoryId);
        if(goodsCategoryJoinDao.addGoodsCategoryJoin(lGoodsCategoryJoinEntity)) return "1";
        else return "0";
    }

    @Override
    public LGoodsCategoryJoinEntity listCommodityCategoryByGoodIdCategoryId(int goodsId, int categoryId) {
        return goodsCategoryJoinDao.listByGoodsIdCategoryId(goodsId, categoryId);
    }

    /**
    * @Description: 通过id删除商品所属分类
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public String deleteCommodityCategoryById(int id) {
        if(goodsCategoryJoinDao.deleteGoodsCategoryJoin(id)) return "1";
        else return "0";
    }

    @Override
    public List<LGoodsCategoryJoinEntity> listCommodityCategoryJoinByGoodsId(int goodsId) {
        return goodsCategoryJoinDao.listByGoodsId(goodsId);
    }

    public void setGoodsStandradDao(GoodsStandradDao goodsStandradDao) {
        this.goodsStandradDao = goodsStandradDao;
    }

    public GoodsStandradDao getGoodsStandradDao() {
        return goodsStandradDao;
    }

    public void setGoodsPhotoDao(GoodsPhotoDao goodsPhotoDao) {
        this.goodsPhotoDao = goodsPhotoDao;
    }

    public GoodsPhotoDao getGoodsPhotoDao() {
        return goodsPhotoDao;
    }

    public void setGoodsCategoryJoinDao(GoodsCategoryJoinDao goodsCategoryJoinDao) {
        this.goodsCategoryJoinDao = goodsCategoryJoinDao;
    }

    public GoodsCategoryJoinDao getGoodsCategoryJoinDao() {
        return goodsCategoryJoinDao;
    }

    public void setGoodsCategoryDao(GoodsCategoryDao goodsCategoryDao) {
        this.goodsCategoryDao = goodsCategoryDao;
    }

    public GoodsCategoryDao getGoodsCategoryDao() {
        return goodsCategoryDao;
    }
}
