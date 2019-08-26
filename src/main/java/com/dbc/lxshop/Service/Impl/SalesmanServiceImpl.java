package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.AreaDao;
import com.dbc.lxshop.Dao.RegionDao;
import com.dbc.lxshop.Dao.SalesmanUserDao;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
import com.dbc.lxshop.Model.Entity.LRegionEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;
import com.dbc.lxshop.Service.SalesmanService;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.InitEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-25 16:15
 **/
@Service("salesmanService")
@Transactional
public class SalesmanServiceImpl implements SalesmanService {
    @Qualifier("regionDao")
    @Autowired
    private RegionDao regionDao;

    @Qualifier("salesmanUserDao")
    @Autowired
    private SalesmanUserDao salesmanUserDao;

    @Qualifier("areaDao")
    @Autowired
    private AreaDao areaDao;

    /**
    * @Description: 查询所有省级实体类
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LRegionEntity> listProvince() {
        return regionDao.listByPid(0);
    }

    /**
    * @Description: 通过上级id查询城市
    * @Param:  int
    * @return:  List<LRegionEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LRegionEntity> listCityByPid(int pid) {
        return regionDao.listByPid(pid);
    }

    /**
    * @Description: 通过业务员ID进行删除
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public String deleteSalesman(int salesmanId) {
        if(salesmanUserDao.deleteSalesmanUser(salesmanId)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过相关信息添加业务员实体
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public String addSalesman(String name, String email, String mobile, String idCard, String province, String city,
                              String areaId, String pid, String kind, String status) {
        LSalesmanUserEntity lSalesmanUserEntity = InitEntityUtil.InitLSalesmanUserEneity();
        lSalesmanUserEntity.setuName(name);
        lSalesmanUserEntity.setEmail(email);
        lSalesmanUserEntity.setMobile(mobile);
        lSalesmanUserEntity.setIdCard(idCard);
        lSalesmanUserEntity.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        lSalesmanUserEntity.setProvince(province);
        lSalesmanUserEntity.setCity(city);
        lSalesmanUserEntity.setAreaId(Integer.parseInt(areaId));
        lSalesmanUserEntity.setPid(Integer.parseInt(pid));
        lSalesmanUserEntity.setKind((byte)Integer.parseInt(kind));
        lSalesmanUserEntity.setStatus((byte)Integer.parseInt(status));
        lSalesmanUserEntity.setAddTime(DateUtil.NewDateInt());
        lSalesmanUserEntity.setUpdTime(DateUtil.NewDateInt());
        if(salesmanUserDao.addSalesmanUser(lSalesmanUserEntity)) {
            LAreaEntity lAreaEntity = new LAreaEntity();
            LAreaEntity lAreaEntity1 = areaDao.listById(Integer.parseInt(areaId));
            lAreaEntity.setSalesmanCount(lAreaEntity1.getSalesmanCount()+1);
            lAreaEntity.setId(Integer.parseInt(areaId));
            areaDao.updateArea(lAreaEntity);
            return "1";
        }else return "0";
    }

    /**
    * @Description: 通过片区ID查询所有所属片区的业务员
    * @Param:  String
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> listSalesmanUserByAreaId(int areaId) {
        return salesmanUserDao.listByAreaId(areaId);
    }

    /**
    * @Description: 通过片区ID和类别进行划分
    * @Param:  int
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LSalesmanUserEntity> listSalesmanUserByAreaIdKind(int kind, int areaId) {
        return salesmanUserDao.listByAreaIdKind(kind, areaId);
    }

    /**
    * @Description: 更新业务员信息
    * @Param:  LSalesmanUserEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String updateSalesman(LSalesmanUserEntity lSalesmanUserEntity) {
        if(salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity)) return "1";
        else return "0";
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public SalesmanUserDao getSalesmanUserDao() {
        return salesmanUserDao;
    }

    public void setSalesmanUserDao(SalesmanUserDao salesmanUserDao) {
        this.salesmanUserDao = salesmanUserDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public AreaDao getAreaDao() {
        return areaDao;
    }
}
