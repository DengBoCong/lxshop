package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_navigation", schema = "lxshop", catalog = "")
public class LNavigationEntity {
    private int id;
    private int pid;
    private String name;
    private String url;
    private int value;
    private int dataType;
    private int navType;
    private byte sort;
    private byte isShow;
    private byte isNewWindowOpen;
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
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 1000)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Basic
    @Column(name = "data_type", nullable = false)
    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "nav_type", nullable = false)
    public int getNavType() {
        return navType;
    }

    public void setNavType(int navType) {
        this.navType = navType;
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
    @Column(name = "is_show", nullable = false)
    public byte getIsShow() {
        return isShow;
    }

    public void setIsShow(byte isShow) {
        this.isShow = isShow;
    }

    @Basic
    @Column(name = "is_new_window_open", nullable = false)
    public byte getIsNewWindowOpen() {
        return isNewWindowOpen;
    }

    public void setIsNewWindowOpen(byte isNewWindowOpen) {
        this.isNewWindowOpen = isNewWindowOpen;
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

        LNavigationEntity that = (LNavigationEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (value != that.value) return false;
        if (dataType != that.dataType) return false;
        if (navType != that.navType) return false;
        if (sort != that.sort) return false;
        if (isShow != that.isShow) return false;
        if (isNewWindowOpen != that.isNewWindowOpen) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + value;
        result = 31 * result + dataType;
        result = 31 * result + navType;
        result = 31 * result + (int) sort;
        result = 31 * result + (int) isShow;
        result = 31 * result + (int) isNewWindowOpen;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        return result;
    }
}
