package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;

import java.util.List;

public interface FactoryUserService {
    public List<LFactoryUserEntity> listFactoryUser();
    public String deleteFactoryUser(int factoryId);
    public String addFactoryUser(LFactoryUserEntity lFactoryUserEntity);
}
