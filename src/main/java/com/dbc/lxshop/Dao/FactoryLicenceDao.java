package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LFactoryLicenceEntity;

public interface FactoryLicenceDao {
    public boolean addFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity);
    public boolean deleteFactoryLicence(int factoryLicenceId);
    public boolean updateFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity);
    public LFactoryLicenceEntity listById(int factoryLicenceId);
    public LFactoryLicenceEntity listByFactoryId(int factoryId);
}
