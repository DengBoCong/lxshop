package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LRegionEntity;

import java.util.List;

public interface RegionDao {
    public List<LRegionEntity> listByPid(int pid);
}
