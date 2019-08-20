package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-19 18:00
 **/
@Entity
@Table(name = "l_login_log", schema = "lxshop", catalog = "")
public class LLoginLogEntity {
    private int id;
    private byte type;
    private int userId;
    private String role;
    private int loginTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
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
    @Column(name = "role", nullable = false, length = 20)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "login_time", nullable = false)
    public int getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(int loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LLoginLogEntity that = (LLoginLogEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (userId != that.userId) return false;
        if (loginTime != that.loginTime) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) type;
        result = 31 * result + userId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + loginTime;
        return result;
    }
}
