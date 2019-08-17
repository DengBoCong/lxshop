package com.dbc.lxshop.Model.Entity;

import javax.persistence.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:02
 **/
@Entity
@Table(name = "l_user_licence", schema = "lxshop", catalog = "")
public class LUserLicenceEntity {
    private int id;
    private String licenceNumber;
    private String licenceName;
    private String legalPerson;
    private String legalPersonTel;
    private String legalPersonIdcard;
    private String licencePhoto;
    private String legalPersonFphoto;
    private String legalPersonBphoto;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "licence_number", nullable = false, length = 50)
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @Basic
    @Column(name = "licence_name", nullable = false, length = 50)
    public String getLicenceName() {
        return licenceName;
    }

    public void setLicenceName(String licenceName) {
        this.licenceName = licenceName;
    }

    @Basic
    @Column(name = "legal_person", nullable = false, length = 20)
    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    @Basic
    @Column(name = "legal_person_tel", nullable = false, length = 15)
    public String getLegalPersonTel() {
        return legalPersonTel;
    }

    public void setLegalPersonTel(String legalPersonTel) {
        this.legalPersonTel = legalPersonTel;
    }

    @Basic
    @Column(name = "legal_person_idcard", nullable = false, length = 50)
    public String getLegalPersonIdcard() {
        return legalPersonIdcard;
    }

    public void setLegalPersonIdcard(String legalPersonIdcard) {
        this.legalPersonIdcard = legalPersonIdcard;
    }

    @Basic
    @Column(name = "licence_photo", nullable = false, length = 1000)
    public String getLicencePhoto() {
        return licencePhoto;
    }

    public void setLicencePhoto(String licencePhoto) {
        this.licencePhoto = licencePhoto;
    }

    @Basic
    @Column(name = "legal_person_fphoto", nullable = false, length = 1000)
    public String getLegalPersonFphoto() {
        return legalPersonFphoto;
    }

    public void setLegalPersonFphoto(String legalPersonFphoto) {
        this.legalPersonFphoto = legalPersonFphoto;
    }

    @Basic
    @Column(name = "legal_person_bphoto", nullable = false, length = 1000)
    public String getLegalPersonBphoto() {
        return legalPersonBphoto;
    }

    public void setLegalPersonBphoto(String legalPersonBphoto) {
        this.legalPersonBphoto = legalPersonBphoto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LUserLicenceEntity that = (LUserLicenceEntity) o;

        if (id != that.id) return false;
        if (licenceNumber != null ? !licenceNumber.equals(that.licenceNumber) : that.licenceNumber != null)
            return false;
        if (licenceName != null ? !licenceName.equals(that.licenceName) : that.licenceName != null) return false;
        if (legalPerson != null ? !legalPerson.equals(that.legalPerson) : that.legalPerson != null) return false;
        if (legalPersonTel != null ? !legalPersonTel.equals(that.legalPersonTel) : that.legalPersonTel != null)
            return false;
        if (legalPersonIdcard != null ? !legalPersonIdcard.equals(that.legalPersonIdcard) : that.legalPersonIdcard != null)
            return false;
        if (licencePhoto != null ? !licencePhoto.equals(that.licencePhoto) : that.licencePhoto != null) return false;
        if (legalPersonFphoto != null ? !legalPersonFphoto.equals(that.legalPersonFphoto) : that.legalPersonFphoto != null)
            return false;
        if (legalPersonBphoto != null ? !legalPersonBphoto.equals(that.legalPersonBphoto) : that.legalPersonBphoto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (licenceNumber != null ? licenceNumber.hashCode() : 0);
        result = 31 * result + (licenceName != null ? licenceName.hashCode() : 0);
        result = 31 * result + (legalPerson != null ? legalPerson.hashCode() : 0);
        result = 31 * result + (legalPersonTel != null ? legalPersonTel.hashCode() : 0);
        result = 31 * result + (legalPersonIdcard != null ? legalPersonIdcard.hashCode() : 0);
        result = 31 * result + (licencePhoto != null ? licencePhoto.hashCode() : 0);
        result = 31 * result + (legalPersonFphoto != null ? legalPersonFphoto.hashCode() : 0);
        result = 31 * result + (legalPersonBphoto != null ? legalPersonBphoto.hashCode() : 0);
        return result;
    }
}
