package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LRegionEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;

import java.util.List;

public interface SalesmanService {
    public List<LRegionEntity> listProvince();
    public List<LRegionEntity> listCityByPid(int pid);

    public List<LSalesmanUserEntity> listSalesmanUserByAreaId(int areaId);
    public List<LSalesmanUserEntity> listSalesmanUserByAreaIdKind(int kind, int areaId);

    public String deleteSalesman(int salesmanId);
    public String updateSalesman(LSalesmanUserEntity lSalesmanUserEntity);
    public String addSalesman(String name, String email, String mobile, String idCard, String province, String city, String areaId,
                              String pid, String kind, String status);
}
