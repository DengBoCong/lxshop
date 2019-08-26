package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-25 15:53
 **/
@Entity
@Table(name = "l_salesman_user", schema = "lxshop", catalog = "")
public class LSalesmanUserEntity {
    private int id;
    private int pid;
    private String uName;
    private String mobile;
    private String pwd;
    private int areaId;
    private String email;
    private String image;
    private String idCard;
    private String idcardFphoto;
    private String idcardBphoto;
    private int lowerCount;
    private int addTime;
    private int updTime;
    private byte status;
    private String province;
    private String city;
    private String description;
    private byte kind;

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
    @Column(name = "u_name", nullable = false, length = 20)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "mobile", nullable = false, length = 15)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "pwd", nullable = false, length = 100)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "area_id", nullable = false)
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 1000)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "id_card", nullable = false, length = 30)
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "idcard_fphoto", nullable = false, length = 1000)
    public String getIdcardFphoto() {
        return idcardFphoto;
    }

    public void setIdcardFphoto(String idcardFphoto) {
        this.idcardFphoto = idcardFphoto;
    }

    @Basic
    @Column(name = "idcard_bphoto", nullable = false, length = 1000)
    public String getIdcardBphoto() {
        return idcardBphoto;
    }

    public void setIdcardBphoto(String idcardBphoto) {
        this.idcardBphoto = idcardBphoto;
    }

    @Basic
    @Column(name = "lower_count", nullable = false)
    public int getLowerCount() {
        return lowerCount;
    }

    public void setLowerCount(int lowerCount) {
        this.lowerCount = lowerCount;
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
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "province", nullable = false, length = 10)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 10)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
    @Column(name = "kind", nullable = false)
    public byte getKind() {
        return kind;
    }

    public void setKind(byte kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LSalesmanUserEntity that = (LSalesmanUserEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (areaId != that.areaId) return false;
        if (lowerCount != that.lowerCount) return false;
        if (addTime != that.addTime) return false;
        if (updTime != that.updTime) return false;
        if (status != that.status) return false;
        if (kind != that.kind) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
        if (idcardFphoto != null ? !idcardFphoto.equals(that.idcardFphoto) : that.idcardFphoto != null) return false;
        if (idcardBphoto != null ? !idcardBphoto.equals(that.idcardBphoto) : that.idcardBphoto != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + areaId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (idcardFphoto != null ? idcardFphoto.hashCode() : 0);
        result = 31 * result + (idcardBphoto != null ? idcardBphoto.hashCode() : 0);
        result = 31 * result + lowerCount;
        result = 31 * result + addTime;
        result = 31 * result + updTime;
        result = 31 * result + (int) status;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) kind;
        return result;
    }
}
