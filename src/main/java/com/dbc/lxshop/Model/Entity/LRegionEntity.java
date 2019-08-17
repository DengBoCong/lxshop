package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:02
 **/
@Entity
@Table(name = "l_region", schema = "lxshop", catalog = "")
public class LRegionEntity {
    private int id;
    private int pid;
    private String name;
    private byte level;
    private String letters;
    private byte sort;
    private byte isEnable;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "letters", nullable = false, length = 3)
    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
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

        LRegionEntity that = (LRegionEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (level != that.level) return false;
        if (sort != that.sort) return false;
        if (isEnable != that.isEnable) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (letters != null ? !letters.equals(that.letters) : that.letters != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) level;
        result = 31 * result + (letters != null ? letters.hashCode() : 0);
        result = 31 * result + (int) sort;
        result = 31 * result + (int) isEnable;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        return result;
    }
}
