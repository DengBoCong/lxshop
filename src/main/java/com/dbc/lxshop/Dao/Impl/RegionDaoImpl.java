package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.RegionDao;
import com.dbc.lxshop.Model.Entity.LRegionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-25 16:11
 **/
@Repository("regionDao")
public class RegionDaoImpl implements RegionDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 通过上级id查询地址
    * @Param:
    * @return:  List<LRegionEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LRegionEntity> listByPid(int pid) {
        Session session = sessionFactory.openSession();
        List<LRegionEntity> list = null;
        try{
            list = session.createNamedQuery("REGION.PID", LRegionEntity.class)
                    .setParameter("pid", pid)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("RegionDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
