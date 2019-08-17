package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:01
 **/
@Entity
@Table(name = "l_order", schema = "lxshop", catalog = "")
public class LOrderEntity {
    private int id;
    private String orderNo;
    private int factoryId;
    private int userId;
    private String receiveName;
    private String receiveTel;
    private String receiveProvince;
    private String receiveCity;
    private String receiveCounty;
    private String receiveAddress;
    private String userNote;
    private String express;
    private String expressNumber;
    private String payment;
    private byte status;
    private byte payStatus;
    private BigDecimal preferentialPrice;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private BigDecimal payPrice;
    private int payTime;
    private int confirmTime;
    private int deliveryTime;
    private int cancelTime;
    private int collectTime;
    private int closeTime;
    private int addTime;
    private int updTime;
    private int integer;
    private String specCode;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_no", nullable = false, length = 100)
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "factory_id", nullable = false)
    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
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
    @Column(name = "receive_name", nullable = false, length = 50)
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    @Basic
    @Column(name = "receive_tel", nullable = false, length = 15)
    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    @Basic
    @Column(name = "receive_province", nullable = false, length = 10)
    public String getReceiveProvince() {
        return receiveProvince;
    }

    public void setReceiveProvince(String receiveProvince) {
        this.receiveProvince = receiveProvince;
    }

    @Basic
    @Column(name = "receive_city", nullable = false, length = 10)
    public String getReceiveCity() {
        return receiveCity;
    }

    public void setReceiveCity(String receiveCity) {
        this.receiveCity = receiveCity;
    }

    @Basic
    @Column(name = "receive_county", nullable = false, length = 10)
    public String getReceiveCounty() {
        return receiveCounty;
    }

    public void setReceiveCounty(String receiveCounty) {
        this.receiveCounty = receiveCounty;
    }

    @Basic
    @Column(name = "receive_address", nullable = false, length = 200)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @Basic
    @Column(name = "user_note", nullable = false, length = 500)
    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Basic
    @Column(name = "express", nullable = false, length = 20)
    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    @Basic
    @Column(name = "express_number", nullable = false, length = 60)
    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    @Basic
    @Column(name = "payment", nullable = false, length = 20)
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "pay_status", nullable = false)
    public byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(byte payStatus) {
        this.payStatus = payStatus;
    }

    @Basic
    @Column(name = "preferential_price", nullable = false, precision = 2)
    public BigDecimal getPreferentialPrice() {
        return preferentialPrice;
    }

    public void setPreferentialPrice(BigDecimal preferentialPrice) {
        this.preferentialPrice = preferentialPrice;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    @Column(name = "pay_price", nullable = false, precision = 2)
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    @Basic
    @Column(name = "pay_time", nullable = false)
    public int getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "confirm_time", nullable = false)
    public int getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(int confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Basic
    @Column(name = "delivery_time", nullable = false)
    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Basic
    @Column(name = "cancel_time", nullable = false)
    public int getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(int cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Basic
    @Column(name = "collect_time", nullable = false)
    public int getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(int collectTime) {
        this.collectTime = collectTime;
    }

    @Basic
    @Column(name = "close_time", nullable = false)
    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
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

    @Basic
    @Column(name = "integer", nullable = false)
    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    @Basic
    @Column(name = "spec_code", nullable = false, length = 1000)
    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LOrderEntity that = (LOrderEntity) o;

        if (id != that.id) return false;
        if (factoryId != that.factoryId) return false;
        if (userId != that.userId) return false;
        if (status != that.status) return false;
        if (payStatus != that.payStatus) return false;
        if (payTime != that.payTime) return false;
        if (confirmTime != that.confirmTime) return false;
        if (deliveryTime != that.deliveryTime) return false;
        if (cancelTime != that.cancelTime) return false;
        if (collectTime != that.collectTime) return false;
        if (closeTime != that.closeTime) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (integer != that.integer) return false;
        if (orderNo != null ? !orderNo.equals(that.orderNo) : that.orderNo != null) return false;
        if (receiveName != null ? !receiveName.equals(that.receiveName) : that.receiveName != null) return false;
        if (receiveTel != null ? !receiveTel.equals(that.receiveTel) : that.receiveTel != null) return false;
        if (receiveProvince != null ? !receiveProvince.equals(that.receiveProvince) : that.receiveProvince != null)
            return false;
        if (receiveCity != null ? !receiveCity.equals(that.receiveCity) : that.receiveCity != null) return false;
        if (receiveCounty != null ? !receiveCounty.equals(that.receiveCounty) : that.receiveCounty != null)
            return false;
        if (receiveAddress != null ? !receiveAddress.equals(that.receiveAddress) : that.receiveAddress != null)
            return false;
        if (userNote != null ? !userNote.equals(that.userNote) : that.userNote != null) return false;
        if (express != null ? !express.equals(that.express) : that.express != null) return false;
        if (expressNumber != null ? !expressNumber.equals(that.expressNumber) : that.expressNumber != null)
            return false;
        if (payment != null ? !payment.equals(that.payment) : that.payment != null) return false;
        if (preferentialPrice != null ? !preferentialPrice.equals(that.preferentialPrice) : that.preferentialPrice != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        if (payPrice != null ? !payPrice.equals(that.payPrice) : that.payPrice != null) return false;
        if (specCode != null ? !specCode.equals(that.specCode) : that.specCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderNo != null ? orderNo.hashCode() : 0);
        result = 31 * result + factoryId;
        result = 31 * result + userId;
        result = 31 * result + (receiveName != null ? receiveName.hashCode() : 0);
        result = 31 * result + (receiveTel != null ? receiveTel.hashCode() : 0);
        result = 31 * result + (receiveProvince != null ? receiveProvince.hashCode() : 0);
        result = 31 * result + (receiveCity != null ? receiveCity.hashCode() : 0);
        result = 31 * result + (receiveCounty != null ? receiveCounty.hashCode() : 0);
        result = 31 * result + (receiveAddress != null ? receiveAddress.hashCode() : 0);
        result = 31 * result + (userNote != null ? userNote.hashCode() : 0);
        result = 31 * result + (express != null ? express.hashCode() : 0);
        result = 31 * result + (expressNumber != null ? expressNumber.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (int) payStatus;
        result = 31 * result + (preferentialPrice != null ? preferentialPrice.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        result = 31 * result + (payPrice != null ? payPrice.hashCode() : 0);
        result = 31 * result + payTime;
        result = 31 * result + confirmTime;
        result = 31 * result + deliveryTime;
        result = 31 * result + cancelTime;
        result = 31 * result + collectTime;
        result = 31 * result + closeTime;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        result = 31 * result + integer;
        result = 31 * result + (specCode != null ? specCode.hashCode() : 0);
        return result;
    }
}
