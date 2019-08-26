package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;

import java.util.List;

public interface FactoryUserDao {
    public boolean addFactoryUser(LFactoryUserEntity lFactoryUserEntity);
    public boolean deleteFactoryUser(int factoryId);
    public boolean updateFactoryUser(LFactoryUserEntity lFactoryUserEntity);
    public List<LFactoryUserEntity> list();
    public List<LFactoryUserEntity> listByAreaId(int areaId);
    public List<LFactoryUserEntity> listBySalesmanId(int salesmanId);
    public LFactoryUserEntity listById(int id);
}
