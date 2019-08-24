package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.GoodsCategoryDao;
import com.dbc.lxshop.Dao.GoodsDao;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Service.CommodityService;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.InitEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-20 15:44
 **/
@Service("commodityService")
@Transactional
public class CommodityServiceImpl implements CommodityService {
    @Qualifier("goodsDao")
    @Autowired
    private GoodsDao goodsDao;

    @Qualifier("goodsCategoryDao")
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    /**
    * @Description: 返回所有商品信息
    * @Param:
    * @return:  List<LGoodsEntity>
    * @Author: DBC
    * @Date: 2019/8/20
    */
    @Override
    public List<LGoodsEntity> listCommodity() {
        return goodsDao.list();
    }

    /** 
    * @Description: 通过id删除商品，返回结果，0未成功，1成功
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/20 
    */ 
    @Override
    public String deleteCommodity(int id) {
        if(goodsDao.deleteGoods(id)) return "1";
        else return "0";
    }

    /**
    * @Description: 单个添加商品
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/20
    */
    @Override
    public String addCommodity(String title, String afterSale, String kindName, String model,
                               String material, String struct, String style, String use,
                               String saleMethod, String unit, String shelves, String home) {
        LGoodsEntity lGoodsEntity = InitEntityUtil.InitLGoodsEntity();
        lGoodsEntity.setTitle(title);
        lGoodsEntity.setAfterSalesInstruction(afterSale);
        lGoodsEntity.setKindName(kindName);
        lGoodsEntity.setMaterial(material);
        lGoodsEntity.setModel(model);
        lGoodsEntity.setStructure(struct);
        lGoodsEntity.setgStyle(style);
        lGoodsEntity.setgUse(use);
        lGoodsEntity.setSaleMethod(saleMethod);
        lGoodsEntity.setInventoryUnit(unit);
        lGoodsEntity.setIsShelves((byte)Integer.parseInt(shelves));
        lGoodsEntity.setIsHomeRecommended((byte)Integer.parseInt(home));
        if(goodsDao.addGoods(lGoodsEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 更新商品信息类
    * @Param:  LGoodsEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public String updateCommodity(LGoodsEntity lGoodsEntity) {
        if(goodsDao.updateGoods(lGoodsEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过基本属性信息更新商品
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @Override
    public String updateCommodityInfo(int goodId, String title, String afterSale, String kindName, String model, String material,
                                      String struct, String style, String use, String saleMethod, String unit,
                                      String shelves, String home) {
        LGoodsEntity lGoodsEntity = new LGoodsEntity();
        lGoodsEntity.setId(goodId);
        if(!title.equals(""))
            lGoodsEntity.setTitle(title);
        lGoodsEntity.setAfterSalesInstruction(afterSale);
        lGoodsEntity.setKindName(kindName);
        lGoodsEntity.setModel(model);
        lGoodsEntity.setMaterial(material);
        lGoodsEntity.setStructure(struct);
        lGoodsEntity.setgStyle(style);
        lGoodsEntity.setgUse(use);
        lGoodsEntity.setSaleMethod(saleMethod);
        lGoodsEntity.setInventoryUnit(unit);
        lGoodsEntity.setIsShelves((byte)Integer.parseInt(shelves));
        lGoodsEntity.setIsHomeRecommended((byte)Integer.parseInt(home));
        lGoodsEntity.setUpdTime(DateUtil.NewDateInt());
        if(goodsDao.updateGoods(lGoodsEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过商品id进行查询商品
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @Override
    public LGoodsEntity listCommodityById(int goodId) {
        return goodsDao.listById(goodId);
    }

    /**
    * @Description: 通过标题查询单个商品
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/20
    */
    @Override
    public LGoodsEntity listOCommodity(String title) {
        return goodsDao.listByTile(title);
    }

    /**
     * @Description: 新增商品分类，pid为0时，即为一级结构
     * @Param:  String
     * @return:  String
     * @Author: DBC
     * @Date: 2019/8/21
     */
    @Override
    public String addCommodityClassify(String pid, String name, String sort, String isHome) {
        LGoodsCategoryEntity lGoodsCategoryEntity = InitEntityUtil.InitLGoodsCategoryEntity();
        lGoodsCategoryEntity.setName(name);
        lGoodsCategoryEntity.setAddTime(DateUtil.NewDateInt());
        lGoodsCategoryEntity.setUpdTime(DateUtil.NewDateInt());
        lGoodsCategoryEntity.setSort((byte)Integer.parseInt(sort));
        lGoodsCategoryEntity.setPid(Integer.parseInt(pid));
        lGoodsCategoryEntity.setIsHomeRecommended((byte)Integer.parseInt(isHome));
        if(goodsCategoryDao.addGoodsCategory(lGoodsCategoryEntity)) return "1";
        else return "0";
    }

    @Override
    public List<LGoodsCategoryEntity> listByFirst() {
        return goodsCategoryDao.listByFirst();
    }

    @Override
    public List<LGoodsCategoryEntity> listBySecond() {
        return goodsCategoryDao.listBySecond();
    }

    @Override
    public String deleteCommodityClassify(String id) {
        if(goodsCategoryDao.deleteGoodsCategory(Integer.parseInt(id))) return "1";
        else return "0";
    }

    @Override
    public String updateCommodityClassify(String id, String name, String sort, String isHome) {
        LGoodsCategoryEntity lGoodsCategoryEntity = new LGoodsCategoryEntity();
        lGoodsCategoryEntity.setIsHomeRecommended((byte)Integer.parseInt(isHome));
        lGoodsCategoryEntity.setId(Integer.parseInt(id));
        lGoodsCategoryEntity.setName(name);
        lGoodsCategoryEntity.setSort((byte)Integer.parseInt(sort));
        if(goodsCategoryDao.updateGood(lGoodsCategoryEntity)) return "1";
        else return "0";
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsCategoryDao(GoodsCategoryDao goodsCategoryDao) {
        this.goodsCategoryDao = goodsCategoryDao;
    }

    public GoodsCategoryDao getGoodsCategoryDao() {
        return goodsCategoryDao;
    }
}
