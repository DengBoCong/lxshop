package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_goods_category", schema = "lxshop", catalog = "")
public class LGoodsCategoryEntity {
    private int id;
    private int pid;
    private String icon;
    private String name;
    private byte isHomeRecommended;
    private byte sort;
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
    @Column(name = "pid", nullable = false)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "icon", nullable = false, length = 1000)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        LGoodsCategoryEntity that = (LGoodsCategoryEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (isHomeRecommended != that.isHomeRecommended) return false;
        if (sort != that.sort) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) isHomeRecommended;
        result = 31 * result + (int) sort;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        return result;
    }
}
