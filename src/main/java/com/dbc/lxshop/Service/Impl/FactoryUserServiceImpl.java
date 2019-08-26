package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.AreaDao;
import com.dbc.lxshop.Dao.FactoryUserDao;
import com.dbc.lxshop.Dao.SalesmanUserDao;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
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
}
