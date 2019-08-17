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
@Table(name = "l_goods", schema = "lxshop", catalog = "")
public class LGoodsEntity {
    private int id;
    private String title;
    private int inventory;
    private String inventoryUnit;
    private String images;
    private BigDecimal price;
    private byte isShelves;
    private byte isHomeRecommended;
    private String content;
    private int salesCount;
    private int accessCount;
    private String homeRecommendedImages;
    private int addTime;
    private int updTime;
    private String afterSalesInstruction;
    private String origin;
    private String kindName;
    private String model;
    private String material;
    private String structure;
    private String style;
    private String use;
    private String saleMethod;
    private String specCode;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 60)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "inventory_unit", nullable = false, length = 15)
    public String getInventoryUnit() {
        return inventoryUnit;
    }

    public void setInventoryUnit(String inventoryUnit) {
        this.inventoryUnit = inventoryUnit;
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
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "is_shelves", nullable = false)
    public byte getIsShelves() {
        return isShelves;
    }

    public void setIsShelves(byte isShelves) {
        this.isShelves = isShelves;
    }

    @Basic
    @Column(name = "is_home_recommended", nullable = false)
    public byte getIsHomeRecommended() {
        return isHomeRecommended;
    }

    public void setIsHomeRecommended(byte isHomeRecommended) {
        this.isHomeRecommended = isHomeRecommended;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "sales_count", nullable = false)
    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    @Basic
    @Column(name = "access_count", nullable = false)
    public int getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(int accessCount) {
        this.accessCount = accessCount;
    }

    @Basic
    @Column(name = "home_recommended_images", nullable = false, length = 1000)
    public String getHomeRecommendedImages() {
        return homeRecommendedImages;
    }

    public void setHomeRecommendedImages(String homeRecommendedImages) {
        this.homeRecommendedImages = homeRecommendedImages;
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
    @Column(name = "after_sales_instruction", nullable = false, length = 1000)
    public String getAfterSalesInstruction() {
        return afterSalesInstruction;
    }

    public void setAfterSalesInstruction(String afterSalesInstruction) {
        this.afterSalesInstruction = afterSalesInstruction;
    }

    @Basic
    @Column(name = "origin", nullable = false, length = 50)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "kind_name", nullable = false, length = 50)
    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "material", nullable = false, length = 20)
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "structure", nullable = false, length = 100)
    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Basic
    @Column(name = "style", nullable = false, length = 100)
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "use", nullable = false, length = 100)
    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    @Basic
    @Column(name = "sale_method", nullable = false, length = 20)
    public String getSaleMethod() {
        return saleMethod;
    }

    public void setSaleMethod(String saleMethod) {
        this.saleMethod = saleMethod;
    }

    @Basic
    @Column(name = "spec_code", nullable = false, length = 1000)
    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LGoodsEntity that = (LGoodsEntity) o;

        if (id != that.id) return false;
        if (inventory != that.inventory) return false;
        if (isShelves != that.isShelves) return false;
        if (isHomeRecommended != that.isHomeRecommended) return false;
        if (salesCount != that.salesCount) return false;
        if (accessCount != that.accessCount) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (inventoryUnit != null ? !inventoryUnit.equals(that.inventoryUnit) : that.inventoryUnit != null)
            return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (homeRecommendedImages != null ? !homeRecommendedImages.equals(that.homeRecommendedImages) : that.homeRecommendedImages != null)
            return false;
        if (afterSalesInstruction != null ? !afterSalesInstruction.equals(that.afterSalesInstruction) : that.afterSalesInstruction != null)
            return false;
        if (origin != null ? !origin.equals(that.origin) : that.origin != null) return false;
        if (kindName != null ? !kindName.equals(that.kindName) : that.kindName != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (structure != null ? !structure.equals(that.structure) : that.structure != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;
        if (use != null ? !use.equals(that.use) : that.use != null) return false;
        if (saleMethod != null ? !saleMethod.equals(that.saleMethod) : that.saleMethod != null) return false;
        if (specCode != null ? !specCode.equals(that.specCode) : that.specCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + inventory;
        result = 31 * result + (inventoryUnit != null ? inventoryUnit.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (int) isShelves;
        result = 31 * result + (int) isHomeRecommended;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + salesCount;
        result = 31 * result + accessCount;
        result = 31 * result + (homeRecommendedImages != null ? homeRecommendedImages.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        result = 31 * result + (afterSalesInstruction != null ? afterSalesInstruction.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (kindName != null ? kindName.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (structure != null ? structure.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (use != null ? use.hashCode() : 0);
        result = 31 * result + (saleMethod != null ? saleMethod.hashCode() : 0);
        result = 31 * result + (specCode != null ? specCode.hashCode() : 0);
        return result;
    }
}
