package com.dbc.lxshop.Utils;

import com.dbc.lxshop.Model.Entity.LAdminEntity;

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
}
