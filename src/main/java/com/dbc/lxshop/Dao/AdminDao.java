package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LAdminEntity;

import java.util.List;

public interface AdminDao {
    public boolean addAdmin(LAdminEntity lAdminEntity);
    public boolean deleteAdmin(int id);
    public boolean updateAdmin(LAdminEntity lAdminEntity);
    public LAdminEntity listByMobile(String mobile);
    public List<LAdminEntity> list();
    public LAdminEntity listById(int id);
    public List<LAdminEntity> listByRoleID(int roleID);
}
