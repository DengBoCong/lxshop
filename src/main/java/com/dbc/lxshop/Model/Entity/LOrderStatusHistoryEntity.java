package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_order_status_history", schema = "lxshop", catalog = "")
public class LOrderStatusHistoryEntity {
    private int id;
    private int orderId;
    private String originalStatus;
    private String newStatus;
    private String msg;
    private int creator;
    private String creatorName;
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
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "original_status", nullable = false, length = 60)
    public String getOriginalStatus() {
        return originalStatus;
    }

    public void setOriginalStatus(String originalStatus) {
        this.originalStatus = originalStatus;
    }

    @Basic
    @Column(name = "new_status", nullable = false, length = 60)
    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    @Basic
    @Column(name = "msg", nullable = false, length = 255)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Basic
    @Column(name = "creator", nullable = false)
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "creator_name", nullable = false, length = 60)
    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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

        LOrderStatusHistoryEntity that = (LOrderStatusHistoryEntity) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (creator != that.creator) return false;
        if (addTime != that.addTime) return false;
        if (originalStatus != null ? !originalStatus.equals(that.originalStatus) : that.originalStatus != null)
            return false;
        if (newStatus != null ? !newStatus.equals(that.newStatus) : that.newStatus != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        if (creatorName != null ? !creatorName.equals(that.creatorName) : that.creatorName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderId;
        result = 31 * result + (originalStatus != null ? originalStatus.hashCode() : 0);
        result = 31 * result + (newStatus != null ? newStatus.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + creator;
        result = 31 * result + (creatorName != null ? creatorName.hashCode() : 0);
        result = 31 * result + addTime;
        return result;
    }
}
