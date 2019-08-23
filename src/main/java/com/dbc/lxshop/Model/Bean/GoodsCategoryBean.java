package com.dbc.lxshop.Model.Bean;

import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-23 17:48
 **/
public class GoodsCategoryBean extends LGoodsCategoryJoinEntity {
    private int goodsId;
    private int categoryId;
    private int id;
    private String name;
    private int pid;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public GoodsCategoryBean(){}

    public GoodsCategoryBean(int goodsId, int categoryId, int id, String name, int pid){
        this.goodsId = goodsId;
        this.categoryId = categoryId;
        this.id = id;
        this.name = name;
        this.pid = pid;
    }
}
