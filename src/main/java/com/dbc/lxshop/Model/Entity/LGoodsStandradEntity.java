package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-22 16:08
 **/
@Entity
@Table(name = "l_goods_standrad", schema = "lxshop", catalog = "")
public class LGoodsStandradEntity {
    private int id;
    private String measure;
    private String color;
    private BigDecimal originPrice;
    private int inventory;
    private BigDecimal factoryPrice;
    private BigDecimal guidePrice;
    private int addTime;
    private int goodsId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "origin_price", nullable = false, precision = 2)
    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }

    @Basic
    @Column(name = "inventory", nullable = false)
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "factory_price", nullable = false, precision = 2)
    public BigDecimal getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(BigDecimal factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    @Basic
    @Column(name = "guide_price", nullable = false, precision = 2)
    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
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
    @Column(name = "goods_id", nullable = false)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LGoodsStandradEntity that = (LGoodsStandradEntity) o;

        if (id != that.id) return false;
        if (inventory != that.inventory) return false;
        if (addTime != that.addTime) return false;
        if (goodsId != that.goodsId) return false;
        if (measure != null ? !measure.equals(that.measure) : that.measure != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (originPrice != null ? !originPrice.equals(that.originPrice) : that.originPrice != null) return false;
        if (factoryPrice != null ? !factoryPrice.equals(that.factoryPrice) : that.factoryPrice != null) return false;
        if (guidePrice != null ? !guidePrice.equals(that.guidePrice) : that.guidePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (originPrice != null ? originPrice.hashCode() : 0);
        result = 31 * result + inventory;
        result = 31 * result + (factoryPrice != null ? factoryPrice.hashCode() : 0);
        result = 31 * result + (guidePrice != null ? guidePrice.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + goodsId;
        return result;
    }
}
