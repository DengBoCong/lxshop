package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-26 20:30
 **/
@Entity
@Table(name = "l_user_photo", schema = "lxshop", catalog = "")
public class LUserPhotoEntity {
    private int id;
    private int userId;
    private String images;
    private byte sort;
    private int addTime;
    private byte userType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Basic
    @Column(name = "user_type", nullable = false)
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LUserPhotoEntity that = (LUserPhotoEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (sort != that.sort) return false;
        if (addTime != that.addTime) return false;
        if (userType != that.userType) return false;
        if (images != null ? !images.equals(that.images) : that.images != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (int) sort;
        result = 31 * result + addTime;
        result = 31 * result + (int) userType;
        return result;
    }
}
