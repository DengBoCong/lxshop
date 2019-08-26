package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LUserLicenceEntity;

public interface UserLicenceDao {
    public boolean addUserLicence(LUserLicenceEntity lUserLicenceEntity);
    public boolean deleteUserLicence(int userLicenceId);
    public boolean updateUserLicence(LUserLicenceEntity lUserLicenceEntity);
    public LUserLicenceEntity listById(int userLicenceId);
    public LUserLicenceEntity listByUserId(int userId);
}
