package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_goods_photo", schema = "lxshop", catalog = "")
public class LGoodsPhotoEntity {
    private int id;
    private int goodsId;
    private String images;
    private byte sort;
    private int addTime;

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
    @Column(name = "images", nullable = false, length = 1000)
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "sort", nullable = false)
    public byte getSort() {
        return sort;
    }

    public void setSort(byte sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LGoodsPhotoEntity that = (LGoodsPhotoEntity) o;

        if (id != that.id) return false;
        if (goodsId != that.goodsId) return false;
        if (sort != that.sort) return false;
        if (addTime != that.addTime) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + goodsId;
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (int) sort;
        result = 31 * result + addTime;
        return result;
    }
}
