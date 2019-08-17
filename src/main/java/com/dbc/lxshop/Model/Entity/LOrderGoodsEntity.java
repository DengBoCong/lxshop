package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_order_goods", schema = "lxshop", catalog = "")
public class LOrderGoodsEntity {
    private int id;
    private int orderId;
    private int goodsId;
    private String goodsName;
    private String goodsImages;
    private BigDecimal price;
    private String measure;
    private String color;
    private int buyNumber;
    private String specCode;
    private int addTime;
    private int updTime;
    private BigDecimal priceTatal;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "goods_name", nullable = false, length = 60)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_images", nullable = false, length = 1000)
    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "measure", nullable = false, length = 30)
    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Basic
    @Column(name = "color", nullable = false, length = 20)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "buy_number", nullable = false)
    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    @Basic
    @Column(name = "spec_code", nullable = false, length = 1000)
    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
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

    @Basic
    @Column(name = "price_tatal", nullable = false, precision = 2)
    public BigDecimal getPriceTatal() {
        return priceTatal;
    }

    public void setPriceTatal(BigDecimal priceTatal) {
        this.priceTatal = priceTatal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LOrderGoodsEntity that = (LOrderGoodsEntity) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (goodsId != that.goodsId) return false;
        if (buyNumber != that.buyNumber) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsImages != null ? !goodsImages.equals(that.goodsImages) : that.goodsImages != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (measure != null ? !measure.equals(that.measure) : that.measure != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (specCode != null ? !specCode.equals(that.specCode) : that.specCode != null) return false;
        if (priceTatal != null ? !priceTatal.equals(that.priceTatal) : that.priceTatal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderId;
        result = 31 * result + goodsId;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsImages != null ? goodsImages.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + buyNumber;
        result = 31 * result + (specCode != null ? specCode.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        result = 31 * result + (priceTatal != null ? priceTatal.hashCode() : 0);
        return result;
    }
}
