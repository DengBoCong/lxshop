package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Bean.AreaInfoBean;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;

import java.util.List;

public interface AreaService {
    public String addArea(String areaName, String areaDescription, String areaSalesman);
    public String deleteArea(int areaId);
    public String updateArea(String areaId, String areaName, String areaDescription, String areaSalesman);
    public List<LAreaEntity> listArea();

    public List<LSalesmanUserEntity> listSalesmanUser();
    public LSalesmanUserEntity listOneSalesmanUser(int salesmanId);
    public List<LSalesmanUserEntity> listSalesmanUserTop();

    public List<AreaInfoBean> listAreaInfo();
    public LAreaEntity listOneArea(int areaId);
    public AreaInfoBean listOneAreaByName(String name);
}
