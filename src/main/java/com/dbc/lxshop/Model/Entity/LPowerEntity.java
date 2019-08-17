package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:02
 **/
@Entity
@Table(name = "l_power", schema = "lxshop", catalog = "")
public class LPowerEntity {
    private int id;
    private int pid;
    private String name;
    private String control;
    private String action;
    private byte sort;
    private byte isShow;
    private String icon;
    private int addTime;

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
    @Column(name = "control", nullable = false, length = 30)
    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Basic
    @Column(name = "action", nullable = false, length = 30)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
    @Column(name = "icon", nullable = false, length = 60)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LPowerEntity that = (LPowerEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (sort != that.sort) return false;
        if (isShow != that.isShow) return false;
        if (addTime != that.addTime) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (control != null ? !control.equals(that.control) : that.control != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (control != null ? control.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (int) sort;
        result = 31 * result + (int) isShow;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + addTime;
        return result;
    }
}
