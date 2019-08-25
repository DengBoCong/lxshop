package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;

import java.util.List;

public interface SalesmanUserDao {
    public boolean addSalesmanUser(LSalesmanUserEntity lSalesmanUserEntity);
    public boolean deleteSalesmanUser(int userId);
    public boolean updateSalesmanUser(LSalesmanUserEntity lSalesmanUserEntity);
    public List<LSalesmanUserEntity> list();
    public List<LSalesmanUserEntity> listByAreaId(int areaId);
    public LSalesmanUserEntity listById(int userId);
    public List<LSalesmanUserEntity> listByKind(int kind);
    public List<LSalesmanUserEntity> listTop();
}
