package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_factory_goods", schema = "lxshop", catalog = "")
public class LFactoryGoodsEntity {
    private int id;
    private int factoryId;
    private String kindName;
    private String model;
    private String material;
    private String structure;
    private String style;
    private String use;
    private String saleMethod;
    private String inventory;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "factory_id", nullable = false)
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
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
    @Column(name = "inventory", nullable = false, length = 500)
    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 1000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LFactoryGoodsEntity that = (LFactoryGoodsEntity) o;

        if (id != that.id) return false;
        if (factoryId != that.factoryId) return false;
        if (kindName != null ? !kindName.equals(that.kindName) : that.kindName != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (structure != null ? !structure.equals(that.structure) : that.structure != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;
        if (use != null ? !use.equals(that.use) : that.use != null) return false;
        if (saleMethod != null ? !saleMethod.equals(that.saleMethod) : that.saleMethod != null) return false;
        if (inventory != null ? !inventory.equals(that.inventory) : that.inventory != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + factoryId;
        result = 31 * result + (kindName != null ? kindName.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (structure != null ? structure.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (use != null ? use.hashCode() : 0);
        result = 31 * result + (saleMethod != null ? saleMethod.hashCode() : 0);
        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
