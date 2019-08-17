package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:02
 **/
@Entity
@Table(name = "l_pay_log", schema = "lxshop", catalog = "")
public class LPayLogEntity {
    private long id;
    private int userId;
    private String tradeNo;
    private String buyerUser;
    private BigDecimal payPrice;
    private BigDecimal totalPrice;
    private String description;
    private String paymentName;
    private byte businessType;
    private int addTime;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Column(name = "trade_no", nullable = false, length = 100)
    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Basic
    @Column(name = "buyer_user", nullable = false, length = 60)
    public String getBuyerUser() {
        return buyerUser;
    }

    public void setBuyerUser(String buyerUser) {
        this.buyerUser = buyerUser;
    }

    @Basic
    @Column(name = "pay_price", nullable = false, precision = 2)
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    @Basic
    @Column(name = "total_price", nullable = false, precision = 2)
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "payment_name", nullable = false, length = 60)
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    @Basic
    @Column(name = "business_type", nullable = false)
    public byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(byte businessType) {
        this.businessType = businessType;
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

        LPayLogEntity that = (LPayLogEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (businessType != that.businessType) return false;
        if (addTime != that.addTime) return false;
        if (tradeNo != null ? !tradeNo.equals(that.tradeNo) : that.tradeNo != null) return false;
        if (buyerUser != null ? !buyerUser.equals(that.buyerUser) : that.buyerUser != null) return false;
        if (payPrice != null ? !payPrice.equals(that.payPrice) : that.payPrice != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (paymentName != null ? !paymentName.equals(that.paymentName) : that.paymentName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + userId;
        result = 31 * result + (tradeNo != null ? tradeNo.hashCode() : 0);
        result = 31 * result + (buyerUser != null ? buyerUser.hashCode() : 0);
        result = 31 * result + (payPrice != null ? payPrice.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (paymentName != null ? paymentName.hashCode() : 0);
        result = 31 * result + (int) businessType;
        result = 31 * result + addTime;
        return result;
    }
}
