package com.dbc.lxshop.Model.Bean;

import java.util.Date;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-25 09:54
 **/
public class AreaInfoBean {
    public int id;
    public String name;
    public String description;
    public int userCount;
    public int salesmanCount;
    public int principalId;
    public Date addTime;
    public double countPrecent;
    public String ownerName;
    public String ownerImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getSalesmanCount() {
        return salesmanCount;
    }

    public void setSalesmanCount(int salesmanCount) {
        this.salesmanCount = salesmanCount;
    }

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    public double getCountPrecent() {
        return countPrecent;
    }

    public void setCountPrecent(double countPrecent) {
        this.countPrecent = countPrecent;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerImage() {
        return ownerImage;
    }

    public void setOwnerImage(String ownerImage) {
        this.ownerImage = ownerImage;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
