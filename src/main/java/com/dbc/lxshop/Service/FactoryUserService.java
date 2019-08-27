package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LFactoryLicenceEntity;
import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;

import java.util.List;

public interface FactoryUserService {
    public List<LFactoryUserEntity> listFactoryUser();
    public String deleteFactoryUser(int factoryId);
    public String addFactoryUser(LFactoryUserEntity lFactoryUserEntity);
    public String updateFactoryUser(LFactoryUserEntity lFactoryUserEntity);
    public String updateFactoryUserNon(LFactoryUserEntity lFactoryUserEntity);

    public String addFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity);
    public LFactoryLicenceEntity listFactoryLicenceById(int factoryLicenceId);
    public String updateFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity);

    public LFactoryUserEntity listOneFactoryUserById(int factoryId);
}
