package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_link", schema = "lxshop", catalog = "")
public class LLinkEntity {
    private int id;
    private String name;
    private String url;
    private String describe;
    private byte sort;
    private byte isEnable;
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
    @Column(name = "describe", nullable = false, length = 60)
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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
    @Column(name = "is_enable", nullable = false)
    public byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(byte isEnable) {
        this.isEnable = isEnable;
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

        LLinkEntity that = (LLinkEntity) o;

        if (id != that.id) return false;
        if (sort != that.sort) return false;
        if (isEnable != that.isEnable) return false;
        if (isNewWindowOpen != that.isNewWindowOpen) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (int) sort;
        result = 31 * result + (int) isEnable;
        result = 31 * result + (int) isNewWindowOpen;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        return result;
    }
}
