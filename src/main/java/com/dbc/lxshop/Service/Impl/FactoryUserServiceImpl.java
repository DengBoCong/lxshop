package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.AreaDao;
import com.dbc.lxshop.Dao.FactoryLicenceDao;
import com.dbc.lxshop.Dao.FactoryUserDao;
import com.dbc.lxshop.Dao.SalesmanUserDao;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
import com.dbc.lxshop.Model.Entity.LFactoryLicenceEntity;
import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;
import com.dbc.lxshop.Service.FactoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-26 16:57
 **/
@Service("factoryUserService")
@Transactional
public class FactoryUserServiceImpl implements FactoryUserService {
    @Qualifier("factoryUserDao")
    @Autowired
    private FactoryUserDao factoryUserDao;

    @Qualifier("areaDao")
    @Autowired
    private AreaDao areaDao;

    @Qualifier("salesmanUserDao")
    @Autowired
    private SalesmanUserDao salesmanUserDao;

    @Qualifier("factoryLicenceDao")
    @Autowired
    private FactoryLicenceDao factoryLicenceDao;

    /**
    * @Description: 查询所有厂商信息
    * @Param:
    * @return:  List<LFactoryUserEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LFactoryUserEntity> listFactoryUser() {
        return factoryUserDao.list();
    }

    /**
    * @Description: 通过ID删除厂商实体类
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String deleteFactoryUser(int factoryId) {
        LFactoryUserEntity lFactoryUserEntity = factoryUserDao.listById(factoryId);
        if(lFactoryUserEntity == null) return "0";
        if(factoryUserDao.deleteFactoryUser(factoryId)) {
            if(lFactoryUserEntity.getSalesmanId() != 0){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lFactoryUserEntity.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity1 = new LSalesmanUserEntity();
                lSalesmanUserEntity1.setId(lSalesmanUserEntity.getId());
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount()-1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity1);
            }
            return "1";
        }
        else return "0";
    }

    /**
    * @Description: 添加厂商实体类
    * @Param:  LFactoryUserEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String addFactoryUser(LFactoryUserEntity lFactoryUserEntity) {
        if(factoryUserDao.addFactoryUser(lFactoryUserEntity)) {
            if(lFactoryUserEntity.getSalesmanId() != 0){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lFactoryUserEntity.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity1 = new LSalesmanUserEntity();
                lSalesmanUserEntity1.setId(lSalesmanUserEntity.getId());
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount()+1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity1);
            }
            return "1";
        }
        else return "0";
    }

    /**
    * @Description: 通过id查询厂商信息嘞
    * @Param:  int
    * @return:  LFactoryUserEntity
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public LFactoryUserEntity listOneFactoryUserById(int factoryId) {
        return factoryUserDao.listById(factoryId);
    }

    /**
    * @Description: 通过id查询厂商营业执照
    * @Param:  int
    * @return:  LFactoryLicenceEntity
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public LFactoryLicenceEntity listFactoryLicenceById(int factoryLicenceId) {
        return factoryLicenceDao.listByFactoryId(factoryLicenceId);
    }

    /**
    * @Description: 更新厂商信息
    * @Param:  LFactoryUserEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String updateFactoryUser(LFactoryUserEntity lFactoryUserEntity) {
        LFactoryUserEntity lFactoryUserEntity1 = factoryUserDao.listById(lFactoryUserEntity.getId());
        if(factoryUserDao.updateFactoryUser(lFactoryUserEntity)) {
            if(lFactoryUserEntity1.getAreaId() != lFactoryUserEntity.getAreaId()){
                LAreaEntity lAreaEntity = areaDao.listById(lFactoryUserEntity.getAreaId());
                LAreaEntity lAreaEntity1 = new LAreaEntity();
                lAreaEntity1.setId(lAreaEntity.getId());
                lAreaEntity1.setUserCount(lAreaEntity.getUserCount()+1);
                areaDao.updateArea(lAreaEntity1);

                LAreaEntity lAreaEntity2 = areaDao.listById(lFactoryUserEntity1.getAreaId());
                LAreaEntity lAreaEntity3 = new LAreaEntity();
                lAreaEntity3.setId(lAreaEntity2.getId());
                lAreaEntity3.setUserCount(lAreaEntity2.getUserCount()-1);
                areaDao.updateArea(lAreaEntity3);
            }

            if(lFactoryUserEntity1.getSalesmanId() != lFactoryUserEntity.getSalesmanId()){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lFactoryUserEntity.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity1 = new LSalesmanUserEntity();
                lSalesmanUserEntity1.setId(lSalesmanUserEntity.getId());
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount()+1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity1);

                LSalesmanUserEntity lSalesmanUserEntity2 = salesmanUserDao.listById(lFactoryUserEntity1.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity3 = new LSalesmanUserEntity();
                lSalesmanUserEntity3.setId(lSalesmanUserEntity2.getId());
                lSalesmanUserEntity3.setLowerCount(lSalesmanUserEntity2.getLowerCount()-1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity3);
            }
            return "1";
        }
        else return "0";
    }

    /**
    * @Description: 直接更新信息
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String updateFactoryUserNon(LFactoryUserEntity lFactoryUserEntity) {
        if(factoryUserDao.updateFactoryUser(lFactoryUserEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 更新厂商营业执照信息
    * @Param:  LFactoryLicenceEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String updateFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity) {
        if(factoryLicenceDao.updateFactoryLicence(lFactoryLicenceEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 添加厂商营业执照实体类
    * @Param:  LFactoryLicenceEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String addFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity) {
        if(factoryLicenceDao.addFactoryLicence(lFactoryLicenceEntity)) return "1";
        else return "0";
    }

    public void setFactoryUserDao(FactoryUserDao factoryUserDao) {
        this.factoryUserDao = factoryUserDao;
    }

    public FactoryUserDao getFactoryUserDao() {
        return factoryUserDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public SalesmanUserDao getSalesmanUserDao() {
        return salesmanUserDao;
    }

    public void setSalesmanUserDao(SalesmanUserDao salesmanUserDao) {
        this.salesmanUserDao = salesmanUserDao;
    }

    public void setFactoryLicenceDao(FactoryLicenceDao factoryLicenceDao) {
        this.factoryLicenceDao = factoryLicenceDao;
    }

    public FactoryLicenceDao getFactoryLicenceDao() {
        return factoryLicenceDao;
    }
}
