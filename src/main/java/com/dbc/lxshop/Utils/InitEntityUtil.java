package com.dbc.lxshop.Utils;

import com.dbc.lxshop.Model.Entity.LAdminEntity;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;

import java.math.BigDecimal;

/**
 * @program: lxshop
 * @description: 实体类初始化类
 * @author: DBC
 * @create: 2019-08-17 09:49
 **/
public class InitEntityUtil {
    /**
    * @Description: 初始化工作人员信息实体类
    * @Param:
    * @return:  LAdminEntity
    * @Author: DBC
    * @Date: 2019/8/17
    */
    public static LAdminEntity InitLAdminEntity(){
        LAdminEntity lAdminEntity = new LAdminEntity();
        lAdminEntity.setMobile(" ");
        lAdminEntity.setPwd(" ");
        lAdminEntity.setEmail(" ");
        lAdminEntity.setName(" ");
        lAdminEntity.setImage(" ");
        return lAdminEntity;
    }

    /**
    * @Description: 初始化商品类
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/20
    */
    public static LGoodsEntity InitLGoodsEntity(){
        LGoodsEntity lGoodsEntity = new LGoodsEntity();
        lGoodsEntity.setTitle(" ");
        lGoodsEntity.setInventoryUnit(" ");
        lGoodsEntity.setImages(" ");
        lGoodsEntity.setPrice(BigDecimal.valueOf(0.00));
        lGoodsEntity.setContentWeb(" ");
        lGoodsEntity.setHomeRecommendedImages(" ");
        lGoodsEntity.setAfterSalesInstruction(" ");
        lGoodsEntity.setOrigin(" ");
        lGoodsEntity.setKindName(" ");
        lGoodsEntity.setModel(" ");
        lGoodsEntity.setMaterial(" ");
        lGoodsEntity.setStructure(" ");
        lGoodsEntity.setgStyle(" ");
        lGoodsEntity.setgUse(" ");
        lGoodsEntity.setSaleMethod(" ");
        lGoodsEntity.setSpecCode(" ");
        return lGoodsEntity;
    }
}
