package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.*;
import com.dbc.lxshop.Model.Entity.*;
import com.dbc.lxshop.Service.AgencyUserService;
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
 * @create: 2019-08-26 13:52
 **/
@Service("agencyUserService")
@Transactional
public class AgencyUserServiceImpl implements AgencyUserService {
    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    @Qualifier("salesmanUserDao")
    @Autowired
    private SalesmanUserDao salesmanUserDao;

    @Qualifier("areaDao")
    @Autowired
    private AreaDao areaDao;

    @Qualifier("userLicenceDao")
    @Autowired
    private UserLicenceDao userLicenceDao;

    @Qualifier("userPhotoDao")
    @Autowired
    private UserPhotoDao userPhotoDao;

    @Override
    public String addAgencyUser(LUserEntity lUserEntity) {
        if(userDao.addUser(lUserEntity)) {
            LAreaEntity lAreaEntity = areaDao.listById(lUserEntity.getAreaId());
            LAreaEntity lAreaEntity1 = new LAreaEntity();
            lAreaEntity1.setId(lAreaEntity.getId());
            lAreaEntity1.setUserCount(lAreaEntity.getUserCount()+1);
            areaDao.updateArea(lAreaEntity1);
            if(lUserEntity.getSalesmanId() != 0){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lUserEntity.getSalesmanId());
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
    * @Description: 查询所有经销商信息
    * @Param:
    * @return:  List<LUserEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LUserEntity> listAgencyUser() {
        return userDao.list();
    }

    /**
    * @Description: 通过id删除经销商
    * @Param:  int
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String deleteAgencyUser(int userId) {
        LUserEntity lUserEntity =userDao.listById(userId);
        if(lUserEntity == null) return "0";
        if(userDao.deleteUser(userId)){
            LAreaEntity lAreaEntity = areaDao.listById(lUserEntity.getAreaId());
            LAreaEntity lAreaEntity1 = new LAreaEntity();
            lAreaEntity1.setId(lAreaEntity.getId());
            lAreaEntity1.setUserCount(lAreaEntity.getUserCount()-1);
            areaDao.updateArea(lAreaEntity1);
            if(lUserEntity.getSalesmanId() != 0){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lUserEntity.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity1 = new LSalesmanUserEntity();
                lSalesmanUserEntity1.setId(lSalesmanUserEntity.getId());
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount()-1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity1);
            }
            return "1";
        }else return "0";
    }

    /**
    * @Description: 通过id查询经销商信息（单个）
    * @Param:  int
    * @return:  LUserEntity
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public LUserEntity listOneAgencyUserById(int userId) {
        return userDao.listById(userId);
    }

    /**
    * @Description: 更新经销商信息类，存在更新片区及上级数据
    * @Param:  LUserEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String updateAgencyUser(LUserEntity lUserEntity) {
        LUserEntity lUserEntity1 = userDao.listById(lUserEntity.getId());
        if(userDao.updateUser(lUserEntity)) {
            if(lUserEntity1.getAreaId() != lUserEntity.getAreaId()){
                LAreaEntity lAreaEntity = areaDao.listById(lUserEntity.getAreaId());
                LAreaEntity lAreaEntity1 = new LAreaEntity();
                lAreaEntity1.setId(lAreaEntity.getId());
                lAreaEntity1.setUserCount(lAreaEntity.getUserCount()+1);
                areaDao.updateArea(lAreaEntity1);

                LAreaEntity lAreaEntity2 = areaDao.listById(lUserEntity1.getAreaId());
                LAreaEntity lAreaEntity3 = new LAreaEntity();
                lAreaEntity3.setId(lAreaEntity2.getId());
                lAreaEntity3.setUserCount(lAreaEntity2.getUserCount()-1);
                areaDao.updateArea(lAreaEntity3);
            }

            if(lUserEntity1.getSalesmanId() != lUserEntity.getSalesmanId()){
                LSalesmanUserEntity lSalesmanUserEntity = salesmanUserDao.listById(lUserEntity.getSalesmanId());
                LSalesmanUserEntity lSalesmanUserEntity1 = new LSalesmanUserEntity();
                lSalesmanUserEntity1.setId(lSalesmanUserEntity.getId());
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount()+1);
                salesmanUserDao.updateSalesmanUser(lSalesmanUserEntity1);

                LSalesmanUserEntity lSalesmanUserEntity2 = salesmanUserDao.listById(lUserEntity1.getSalesmanId());
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
    * @Description: 更新经销商信息类
    * @Param:  LUserEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String updateAgencyUserNon(LUserEntity lUserEntity) {
        if(userDao.updateUser(lUserEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过id查询经销商营业执照
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public LUserLicenceEntity listUserLicenceById(int userLicenceId) {
        return userLicenceDao.listById(userLicenceId);
    }

    /**
    * @Description: 添加经销商营业执照
    * @Param:  LUserLicenceEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String addUserLicence(LUserLicenceEntity lUserLicenceEntity) {
        if(userLicenceDao.addUserLicence(lUserLicenceEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 更新经销商营业执照信息
    * @Param:  LUserLicenceEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String updateUserLicence(LUserLicenceEntity lUserLicenceEntity) {
        if(userLicenceDao.updateUserLicence(lUserLicenceEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过类别查询实景图片
    * @Param:  int
    * @return:  List<LUserPhotoEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LUserPhotoEntity> listUserPhotoByType(int type, int userId) {
        return userPhotoDao.listByTypeUser(type, userId);
    }

    /**
    * @Description: 添加经销商实景图
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public String addAgencyUserPhoto(String type, int userId, String images, String sort) {
        LUserPhotoEntity lUserPhotoEntity = new LUserPhotoEntity();
        lUserPhotoEntity.setAddTime(DateUtil.NewDateInt());
        lUserPhotoEntity.setImages(images);
        lUserPhotoEntity.setSort((byte)Integer.parseInt(sort));
        lUserPhotoEntity.setUserId(userId);
        lUserPhotoEntity.setUserType((byte)Integer.parseInt(type));
        if(userPhotoDao.addUserPhoto(lUserPhotoEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 通过图片地址、用户id，类别进行查询
    * @Param:  String
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public LUserPhotoEntity listAgencyPhotoId(String images, int userId, String type) {
        return userPhotoDao.listByTypeImageUser(type, images, userId);
    }

    /**
    * @Description: 通过id删除经销商实景图片
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String deleteAgencyUserPhoto(String photoId) {
        if(userPhotoDao.deleteUserPhoto(Integer.parseInt(photoId))) return "1";
        else return "0";
    }

    /**
    * @Description: 通过id和排序更新
    * @Param:  String
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public String updateAgencyUserPhoto(String photoId, String sort) {
        if(userPhotoDao.updateUserPhoto(Integer.parseInt(photoId), sort)) return "1";
        else return "0";
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setSalesmanUserDao(SalesmanUserDao salesmanUserDao) {
        this.salesmanUserDao = salesmanUserDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public SalesmanUserDao getSalesmanUserDao() {
        return salesmanUserDao;
    }

    public void setUserLicenceDao(UserLicenceDao userLicenceDao) {
        this.userLicenceDao = userLicenceDao;
    }

    public UserLicenceDao getUserLicenceDao() {
        return userLicenceDao;
    }

    public UserPhotoDao getUserPhotoDao() {
        return userPhotoDao;
    }

    public void setUserPhotoDao(UserPhotoDao userPhotoDao) {
        this.userPhotoDao = userPhotoDao;
    }
}
