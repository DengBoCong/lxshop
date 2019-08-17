package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_config", schema = "lxshop", catalog = "")
public class LConfigEntity {
    private int id;
    private String value;
    private String name;
    private String describe;
    private String errorTips;
    private String type;
    private String onlyTag;
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
    @Column(name = "value", nullable = true, length = -1)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "describe", nullable = false, length = 255)
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Basic
    @Column(name = "error_tips", nullable = false, length = 150)
    public String getErrorTips() {
        return errorTips;
    }

    public void setErrorTips(String errorTips) {
        this.errorTips = errorTips;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "only_tag", nullable = false, length = 60)
    public String getOnlyTag() {
        return onlyTag;
    }

    public void setOnlyTag(String onlyTag) {
        this.onlyTag = onlyTag;
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

        LConfigEntity that = (LConfigEntity) o;

        if (id != that.id) return false;
        if (updTime != that.updTime) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (describe != null ? !describe.equals(that.describe) : that.describe != null) return false;
        if (errorTips != null ? !errorTips.equals(that.errorTips) : that.errorTips != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (onlyTag != null ? !onlyTag.equals(that.onlyTag) : that.onlyTag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + (errorTips != null ? errorTips.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (onlyTag != null ? onlyTag.hashCode() : 0);
        result = 31 * result + updTime;
        return result;
    }
}
