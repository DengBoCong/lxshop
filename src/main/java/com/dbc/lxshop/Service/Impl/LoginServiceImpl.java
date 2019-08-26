package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.AdminDao;
import com.dbc.lxshop.Dao.LoginLogDao;
import com.dbc.lxshop.Model.Entity.LAdminEntity;
import com.dbc.lxshop.Model.Entity.LLoginLogEntity;
import com.dbc.lxshop.Service.LoginService;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.InitEntityUtil;
import com.dbc.lxshop.Utils.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 12:38
 **/
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;

    @Qualifier("loginLogDao")
    @Autowired
    private LoginLogDao loginLogDao;

    /**
    * @Description: 对用户账号密码进行查验
    * @Param:  String，String
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/17
    */
    @Override
    public Map<String, Object> checkLogin(String mobile, String pwd) {
        Map<String, Object> map = new HashMap<String, Object>();
        LAdminEntity lAdminEntity = adminDao.listByMobile(mobile);
        if(lAdminEntity == null) return null;
        else {
            if(DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(lAdminEntity.getPwd())){
                LLoginLogEntity lLoginLogEntity = new LLoginLogEntity();
                lLoginLogEntity.setLoginTime(DateUtil.NewDateInt());
                lLoginLogEntity.setType((byte) 1);
                lLoginLogEntity.setUserId(lAdminEntity.getId());
                lLoginLogEntity.setRole("工作人员");
                loginLogDao.addLoginLog(lLoginLogEntity);

                LAdminEntity lAdminEntity1 = new LAdminEntity();
                lAdminEntity1.setLoginTotal(lAdminEntity.getLoginTotal()+1);
                lAdminEntity1.setLoginTime(DateUtil.NewDateInt());
                lAdminEntity1.setId(lAdminEntity.getId());
                adminDao.updateAdmin(lAdminEntity1);
                map = ReflectUtil.toMap(lAdminEntity);
                map.put("flag", "1");
                return map;
            }
            else return null;
        }
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public LoginLogDao getLoginLogDao() {
        return loginLogDao;
    }
}
