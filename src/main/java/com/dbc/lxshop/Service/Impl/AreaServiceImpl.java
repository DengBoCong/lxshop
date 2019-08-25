package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.AreaDao;
import com.dbc.lxshop.Dao.SalesmanUserDao;
import com.dbc.lxshop.Model.Bean.AreaInfoBean;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;
import com.dbc.lxshop.Service.AreaService;
import com.dbc.lxshop.Utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-25 09:32
 **/
@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
    @Qualifier("areaDao")
    @Autowired
    private AreaDao areaDao;

    @Qualifier("salesmanUserDao")
    @Autowired
    private SalesmanUserDao salesmanUserDao;

    /**
    * @Description: 添加片区信息
    * @Param:  String
    * @Param:  String
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public String addArea(String areaName, String areaDescription, String areaSalesman) {
        LAreaEntity lAreaEntity = new LAreaEntity();
        lAreaEntity.setName(areaName);
        lAreaEntity.setDescription(areaDescription);
        lAreaEntity.setPrincipalId(Integer.parseInt(areaSalesman));
        lAreaEntity.setAddTime(DateUtil.NewDateInt());
        if(areaDao.addArea(lAreaEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 删除片区信息
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public String deleteArea(int areaId) {
        if(areaDao.deleteArea(areaId)) return "1";
        else return "0";
    }

    /**
    * @Description: 利用相关信息对片区进行更新
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public String updateArea(String areaId, String areaName, String areaDescription, String areaSalesman) {
        LAreaEntity lAreaEntity = new LAreaEntity();
        lAreaEntity.setId(Integer.parseInt(areaId));
        lAreaEntity.setName(areaName);
        lAreaEntity.setDescription(areaDescription);
        lAreaEntity.setPrincipalId(Integer.parseInt(areaSalesman));
        if(areaDao.updateArea(lAreaEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 查询所有片区信息
    * @Param:
    * @return:  List<LAreaEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LAreaEntity> listArea() {
        return areaDao.list();
    }

    /**
    * @Description: 查询所有业务员
    * @Param:
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> listSalesmanUser() {
        return salesmanUserDao.list();
    }

    /**
    * @Description:  通过业务员ID进行查询
    * @Param:  int
    * @return:  LSalesmanUserEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public LSalesmanUserEntity listOneSalesmanUser(int salesmanId) {
        return salesmanUserDao.listById(salesmanId);
    }

    /**
    * @Description: 通过id查询单个片区信息
    * @Param:  int
    * @return:  LAreaEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public LAreaEntity listOneArea(int areaId) {
        return areaDao.listById(areaId);
    }

    /**
    * @Description: 通过片区名称查询
    * @Param:  String
    * @return:    LAreaEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public AreaInfoBean listOneAreaByName(String name) {
        List<LSalesmanUserEntity> lSalesmanUserEntityList = salesmanUserDao.list();
        LAreaEntity lAreaEntity = areaDao.listByName(name);
        AreaInfoBean areaInfoBean = new AreaInfoBean();
        if(lAreaEntity == null) return areaInfoBean;
        areaInfoBean.id = lAreaEntity.getId();
        areaInfoBean.description = lAreaEntity.getDescription();
        areaInfoBean.name = lAreaEntity.getName();
        areaInfoBean.principalId = lAreaEntity.getPrincipalId();
        areaInfoBean.salesmanCount = lAreaEntity.getSalesmanCount();
        areaInfoBean.userCount = lAreaEntity.getUserCount();
        areaInfoBean.addTime = DateUtil.IntToDate(lAreaEntity.getAddTime());
        if(lSalesmanUserEntityList.size() == 0)
            areaInfoBean.countPrecent = 0;
        else
            areaInfoBean.countPrecent = ((double)lAreaEntity.getSalesmanCount()/(double)lSalesmanUserEntityList.size()*100);

        LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lAreaEntity.getPrincipalId());
        if(lSalesmanUserEntity == null){
            areaInfoBean.ownerName = "";
            areaInfoBean.ownerImage = "";
        }else{
            areaInfoBean.ownerName = lSalesmanUserEntity.getName();
            areaInfoBean.ownerImage = lSalesmanUserEntity.getImage();
        }
        return areaInfoBean;
    }

    /**
    * @Description: 查询所有片区信息
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<AreaInfoBean> listAreaInfo() {
        List<LSalesmanUserEntity> lSalesmanUserEntityList = salesmanUserDao.list();
        List<AreaInfoBean> areaInfoBeanList = null;
        List<LAreaEntity> list = areaDao.list();
        if(list.isEmpty()) return null;
        else{
            for (LAreaEntity lAreaEntity : list){
                AreaInfoBean areaInfoBean = new AreaInfoBean();
                areaInfoBean.id = lAreaEntity.getId();
                areaInfoBean.description = lAreaEntity.getDescription();
                areaInfoBean.name = lAreaEntity.getName();
                areaInfoBean.principalId = lAreaEntity.getPrincipalId();
                areaInfoBean.salesmanCount = lAreaEntity.getSalesmanCount();
                areaInfoBean.userCount = lAreaEntity.getUserCount();
                areaInfoBean.addTime = DateUtil.IntToDate(lAreaEntity.getAddTime());
                if(lSalesmanUserEntityList.size() == 0)
                    areaInfoBean.countPrecent = 0;
                else
                    areaInfoBean.countPrecent = ((double)lAreaEntity.getSalesmanCount()/(double)lSalesmanUserEntityList.size()*100);

                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lAreaEntity.getPrincipalId());
                if(lSalesmanUserEntity == null){
                    areaInfoBean.ownerName = "";
                    areaInfoBean.ownerImage = "";
                }else{
                    areaInfoBean.ownerName = lSalesmanUserEntity.getName();
                    areaInfoBean.ownerImage = lSalesmanUserEntity.getImage();
                }
                areaInfoBeanList.add(areaInfoBean);
            }
            return areaInfoBeanList;
        }
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
