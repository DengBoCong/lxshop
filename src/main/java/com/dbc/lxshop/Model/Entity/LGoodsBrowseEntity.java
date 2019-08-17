package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_goods_browse", schema = "lxshop", catalog = "")
public class LGoodsBrowseEntity {
    private int id;
    private int goodsId;
    private int userId;
    private int addTime;
    private int updTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "upd_time", nullable = false)
    public int getUpdTime() {
        return updTime;
    }

    public void setUpdTime(int updTime) {
        this.updTime = updTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LGoodsBrowseEntity that = (LGoodsBrowseEntity) o;

        if (id != that.id) return false;
        if (goodsId != that.goodsId) return false;
        if (userId != that.userId) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsId;
        result = 31 * result + userId;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        return result;
    }
}
