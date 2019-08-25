package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.AreaDao;
import com.dbc.lxshop.Model.Entity.LAreaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-24 23:32
 **/
@Repository("areaDao")
public class AreaDaoImpl implements AreaDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加片区实体类
    * @Param:  LAreaEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @Override
    public boolean addArea(LAreaEntity lAreaEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LAreaEntity> list = null;
        try{
            list = session.createNamedQuery("AREA.NAME", LAreaEntity.class)
                    .setParameter("name", lAreaEntity.getName())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AreaDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lAreaEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AreaDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除片区实体类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteArea(int areaId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LAreaEntity lAreaEntity = null;
        lAreaEntity = (LAreaEntity)session.get(LAreaEntity.class, areaId);
        if(lAreaEntity == null) return false;
        else{
            try{
                session.delete(lAreaEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AreaDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新片区实体类
    * @Param:  LAreaEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateArea(LAreaEntity lAreaEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LAreaEntity lAreaEntity1 = null;
        lAreaEntity1 = (LAreaEntity)session.get(LAreaEntity.class, lAreaEntity.getId());
        if(lAreaEntity1 == null) return false;
        else{
            if(lAreaEntity.getName() != null)
                lAreaEntity1.setName(lAreaEntity.getName());
            if(lAreaEntity.getDescription() != null)
                lAreaEntity1.setDescription(lAreaEntity.getDescription());
            if(lAreaEntity.getUserCount() != 0)
                lAreaEntity1.setUserCount(lAreaEntity.getUserCount());
            if(lAreaEntity.getSalesmanCount() != 0)
                lAreaEntity1.setSalesmanCount(lAreaEntity.getSalesmanCount());
            if(lAreaEntity.getAddTime() != 0)
                lAreaEntity1.setAddTime(lAreaEntity.getAddTime());
            if(lAreaEntity.getPrincipalId() != 0)
                lAreaEntity1.setPrincipalId(lAreaEntity.getPrincipalId());

            try{
                session.update(lAreaEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AreaDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 查询所有片区实体类
    * @Param:
    * @return:  List<LAreaEntity>
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @Override
    public List<LAreaEntity> list() {
        Session session = sessionFactory.openSession();
        List<LAreaEntity> list = null;
        try {
            list = session.createNamedQuery("AREA.ORDER_VY.NAME", LAreaEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AreaDao中Session操作出错！");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过id查询片区信息
    * @Param:  int
    * @return:  LAreaEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @SuppressWarnings("unchecked")
    @Override
    public LAreaEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LAreaEntity lAreaEntity = null;
        lAreaEntity = (LAreaEntity)session.get(LAreaEntity.class, id);
        session.close();
        return lAreaEntity;
    }

    /**
    * @Description: 通过片区名称查询片区信息
    * @Param:  String
    * @return:  LAreaEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public LAreaEntity listByName(String name) {
        Session session = sessionFactory.openSession();
        List<LAreaEntity> list = null;
        try{
            list = session.createNamedQuery("AREA.NAME", LAreaEntity.class)
                    .setParameter("name", name)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AreaDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
