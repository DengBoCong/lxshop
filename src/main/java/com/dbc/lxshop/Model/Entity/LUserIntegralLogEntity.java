package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:02
 **/
@Entity
@Table(name = "l_user_integral_log", schema = "lxshop", catalog = "")
public class LUserIntegralLogEntity {
    private int id;
    private int userId;
    private byte type;
    private int originalIntegral;
    private int newIntegral;
    private String msg;
    private int operationId;
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
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "original_integral", nullable = false)
    public int getOriginalIntegral() {
        return originalIntegral;
    }

    public void setOriginalIntegral(int originalIntegral) {
        this.originalIntegral = originalIntegral;
    }

    @Basic
    @Column(name = "new_integral", nullable = false)
    public int getNewIntegral() {
        return newIntegral;
    }

    public void setNewIntegral(int newIntegral) {
        this.newIntegral = newIntegral;
    }

    @Basic
    @Column(name = "msg", nullable = false, length = 500)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "operation_id", nullable = false)
    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
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

        LUserIntegralLogEntity that = (LUserIntegralLogEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (type != that.type) return false;
        if (originalIntegral != that.originalIntegral) return false;
        if (newIntegral != that.newIntegral) return false;
        if (operationId != that.operationId) return false;
        if (addTime != that.addTime) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (int) type;
        result = 31 * result + originalIntegral;
        result = 31 * result + newIntegral;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + operationId;
        result = 31 * result + addTime;
        return result;
    }
}
