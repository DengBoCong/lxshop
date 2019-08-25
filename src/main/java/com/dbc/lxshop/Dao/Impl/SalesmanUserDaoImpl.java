package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.SalesmanUserDao;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-24 23:51
 **/
@Repository("salesmanUserDao")
public class SalesmanUserDaoImpl implements SalesmanUserDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /** 
    * @Description: 添加业务员实体类 
    * @Param:  LSalesmanUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/24 
    */ 
    @Override
    public boolean addSalesmanUser(LSalesmanUserEntity lSalesmanUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LSalesmanUserEntity> list = null;
        try{
            list = session.createNamedQuery("SALESMAN_USER.MOBILE", LSalesmanUserEntity.class)
                    .setParameter("mobile", lSalesmanUserEntity.getMobile())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("SalesmanUserDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lSalesmanUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("SalesmanUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除业务员实体类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteSalesmanUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LSalesmanUserEntity lSalesmanUserEntity = null;
        lSalesmanUserEntity = (LSalesmanUserEntity)session.get(LSalesmanUserEntity.class, userId);
        if(lSalesmanUserEntity == null) return false;
        else{
            try{
                session.delete(lSalesmanUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("SalesmanUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新业务员实体类
    * @Param:  LSalesmanUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public boolean updateSalesmanUser(LSalesmanUserEntity lSalesmanUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LSalesmanUserEntity lSalesmanUserEntity1 = null;
        lSalesmanUserEntity1 = (LSalesmanUserEntity)session.get(LSalesmanUserEntity.class, lSalesmanUserEntity.getId());
        if(lSalesmanUserEntity1 == null) return false;
        else{
            if(lSalesmanUserEntity.getPid() != 0)
                lSalesmanUserEntity1.setPid(lSalesmanUserEntity.getPid());
            if(lSalesmanUserEntity.getName() != null)
                lSalesmanUserEntity1.setName(lSalesmanUserEntity.getName());
            if(lSalesmanUserEntity.getMobile() != null){
                List<LSalesmanUserEntity> list = null;
                try{
                    list = session.createNamedQuery("SALESMAN_USER.MOBILE", LSalesmanUserEntity.class)
                            .setParameter("mobile", lSalesmanUserEntity.getMobile()).getResultList();
                }catch (IllegalArgumentException e){
                    System.out.println("SalesmanUserDao查询语句出现问题");
                    e.printStackTrace();
                }
                if(!list.isEmpty()) return false;
                else lSalesmanUserEntity1.setMobile(lSalesmanUserEntity.getMobile());
            }
            if(lSalesmanUserEntity.getPwd() != null)
                lSalesmanUserEntity1.setPwd(DigestUtils.md5DigestAsHex(lSalesmanUserEntity.getName().getBytes()));
            if(lSalesmanUserEntity.getAreaId() != 0)
                lSalesmanUserEntity1.setAreaId(lSalesmanUserEntity.getAreaId());
            if(lSalesmanUserEntity.getEmail() != null)
                lSalesmanUserEntity1.setEmail(lSalesmanUserEntity.getEmail());
            if(lSalesmanUserEntity.getImage() != null)
                lSalesmanUserEntity1.setImage(lSalesmanUserEntity.getImage());
            if(lSalesmanUserEntity.getIdCard() != null)
                lSalesmanUserEntity1.setIdCard(lSalesmanUserEntity.getIdCard());
            if(lSalesmanUserEntity.getIdcardBphoto() != null)
                lSalesmanUserEntity1.setIdcardBphoto(lSalesmanUserEntity.getIdcardBphoto());
            if(lSalesmanUserEntity.getIdcardFphoto() != null)
                lSalesmanUserEntity1.setIdcardFphoto(lSalesmanUserEntity.getIdcardFphoto());

            if(lSalesmanUserEntity.getLowerCount() != 0)
                lSalesmanUserEntity1.setLowerCount(lSalesmanUserEntity.getLowerCount());
            if(lSalesmanUserEntity.getAddTime() != 0)
                lSalesmanUserEntity1.setAddTime(lSalesmanUserEntity.getAddTime());
            if(lSalesmanUserEntity.getUpdTime() != 0)
                lSalesmanUserEntity1.setUpdTime(lSalesmanUserEntity.getUpdTime());
            if(lSalesmanUserEntity.getStatus() != 0)
                lSalesmanUserEntity1.setStatus(lSalesmanUserEntity.getStatus());
            if(lSalesmanUserEntity.getProvince() != null)
                lSalesmanUserEntity1.setProvince(lSalesmanUserEntity.getProvince());
            if(lSalesmanUserEntity.getCity() != null)
                lSalesmanUserEntity1.setCity(lSalesmanUserEntity.getCity());
            if(lSalesmanUserEntity.getDescription() != null)
                lSalesmanUserEntity1.setDescription(lSalesmanUserEntity.getDescription());
            if(lSalesmanUserEntity.getKind() != 0)
                lSalesmanUserEntity1.setKind(lSalesmanUserEntity.getKind());

            try{
                session.update(lSalesmanUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("SalesmanUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id进行查询
    * @Param:  int
    * @return:  LSalesmanUserEntity
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @SuppressWarnings("unchecked")
    @Override
    public LSalesmanUserEntity listById(int userId) {
        Session session = sessionFactory.openSession();
        LSalesmanUserEntity lSalesmanUserEntity = null;
        lSalesmanUserEntity = (LSalesmanUserEntity)session.get(LSalesmanUserEntity.class, userId);
        session.close();
        return lSalesmanUserEntity;
    }

    /**
    * @Description: 查询所有业务员实体
    * @Param:
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> list() {
        Session session = sessionFactory.openSession();
        List<LSalesmanUserEntity> list = null;
        try {
            list = session.createNamedQuery("SALESMAN_USER.ORDER_BY.NAME", LSalesmanUserEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("SalesmanUserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过片区ID查询业务员实体类
    * @Param:  int
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> listByAreaId(int areaId) {
        Session session = sessionFactory.openSession();
        List<LSalesmanUserEntity> list = null;
        try {
            list = session.createNamedQuery("SALESMAN_USER.AREA_ID", LSalesmanUserEntity.class)
                    .setParameter("areaId", areaId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("SalesmanUserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过业务员类别查询业务员实体类
    * @Param:  int
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> listByKind(int kind) {
        Session session = sessionFactory.openSession();
        List<LSalesmanUserEntity> list = null;
        try {
            list = session.createNamedQuery("SALESMAN_USER.KIND", LSalesmanUserEntity.class)
                    .setParameter("kind", kind).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("SalesmanUserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 查询所有顶级业务员
    * @Param:
    * @return:  List<LSalesmanUserEntity>
    * @Author: DBC
    * @Date: 2019/8/25
    */
    @Override
    public List<LSalesmanUserEntity> listTop() {
        Session session = sessionFactory.openSession();
        List<LSalesmanUserEntity> list = null;
        try {
            list = session.createNamedQuery("SALESMAN_USER.PID_0", LSalesmanUserEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("SalesmanUserDao查询语句出现问题");
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
