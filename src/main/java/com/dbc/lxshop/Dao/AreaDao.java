package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LAreaEntity;

import java.util.List;

public interface AreaDao {
    public boolean addArea(LAreaEntity lAreaEntity);
    public boolean deleteArea(int areaId);
    public boolean updateArea(LAreaEntity lAreaEntity);
    public List<LAreaEntity> list();
    public LAreaEntity listById(int id);
    public LAreaEntity listByName(String name);
}
