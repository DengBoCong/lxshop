package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_area", schema = "lxshop", catalog = "")
public class LAreaEntity {
    private int id;
    private String name;
    private String description;
    private int userCount;
    private int salesmanCount;
    private int addTime;
    private int principalId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "user_count", nullable = false)
    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    @Basic
    @Column(name = "salesman_count", nullable = false)
    public int getSalesmanCount() {
        return salesmanCount;
    }

    public void setSalesmanCount(int salesmanCount) {
        this.salesmanCount = salesmanCount;
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
    @Column(name = "principal_id", nullable = false)
    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LAreaEntity that = (LAreaEntity) o;

        if (id != that.id) return false;
        if (userCount != that.userCount) return false;
        if (salesmanCount != that.salesmanCount) return false;
        if (addTime != that.addTime) return false;
        if (principalId != that.principalId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + userCount;
        result = 31 * result + salesmanCount;
        result = 31 * result + addTime;
        result = 31 * result + principalId;
        return result;
    }
}
