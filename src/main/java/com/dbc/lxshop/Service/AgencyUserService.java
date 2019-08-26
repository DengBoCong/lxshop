package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LUserEntity;
import com.dbc.lxshop.Model.Entity.LUserLicenceEntity;
import com.dbc.lxshop.Model.Entity.LUserPhotoEntity;

import java.util.List;

public interface AgencyUserService {
    public String addAgencyUser(LUserEntity lUserEntity);
    public List<LUserEntity> listAgencyUser();
    public String deleteAgencyUser(int userId);
    public LUserEntity listOneAgencyUserById(int userId);
    public String updateAgencyUser(LUserEntity lUserEntity);
    public String updateAgencyUserNon(LUserEntity lUserEntity);
    public LUserLicenceEntity listUserLicenceById(int userLicenceId);
    public String addUserLicence(LUserLicenceEntity lUserLicenceEntity);
    public String updateUserLicence(LUserLicenceEntity lUserLicenceEntity);

    public List<LUserPhotoEntity> listUserPhotoByType(int type, int userId);
    public String addAgencyUserPhoto(String type, int userId, String images, String sort);
    public LUserPhotoEntity listAgencyPhotoId(String images, int userId, String type);
    public String deleteAgencyUserPhoto(String photoId);
    public String updateAgencyUserPhoto(String photoId, String sort);
}
