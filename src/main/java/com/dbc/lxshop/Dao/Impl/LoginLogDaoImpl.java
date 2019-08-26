package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.LoginLogDao;
import com.dbc.lxshop.Model.Entity.LLoginLogEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-26 10:08
 **/
@Repository("loginLogDao")
public class LoginLogDaoImpl implements LoginLogDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加登录日志实体
    * @Param:  LLoginLogEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public boolean addLoginLog(LLoginLogEntity lLoginLogEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lLoginLogEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
