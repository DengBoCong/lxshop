package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.AdminDao;
import com.dbc.lxshop.Model.Entity.LAdminEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-16 11:08
 **/
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加工作人员类
    * @Param:  LAdminEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/16
    */
    @Override
    public boolean addAdmin(LAdminEntity lAdminEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LAdminEntity> list = null;
        try{
            list = session
                    .createNamedQuery("ADMIN.MOBILE", LAdminEntity.class)
                    .setParameter("mobile", lAdminEntity.getMobile())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AdminDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lAdminEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AdminDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除工作人员类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/16
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteAdmin(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LAdminEntity lAdminEntity = null;
        lAdminEntity = (LAdminEntity)session.get(LAdminEntity.class, id);
        if(lAdminEntity == null) return false;
        else{
            try{
                session.delete(lAdminEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AdminDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新工作人员信息类
    * @Param:  LAdminEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/16
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateAdmin(LAdminEntity lAdminEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LAdminEntity lAdminEntity1 = null;
        lAdminEntity1 = (LAdminEntity)session.get(LAdminEntity.class, lAdminEntity.getId());
        if(lAdminEntity1 == null) return false;
        else{
            if(lAdminEntity.getName() != null)
                lAdminEntity1.setName(lAdminEntity.getName());
            if(lAdminEntity.getPwd() != null)
                lAdminEntity1.setPwd(DigestUtils.md5DigestAsHex(lAdminEntity.getPwd().getBytes()));
            if(lAdminEntity.getLoginTotal() != 0)
                lAdminEntity1.setLoginTotal(lAdminEntity.getLoginTotal());
            if(lAdminEntity.getLoginTime() != 0)
                lAdminEntity1.setLoginTime(lAdminEntity.getLoginTime());
            if(lAdminEntity.getRoleId() != 0)
                lAdminEntity1.setRoleId(lAdminEntity.getRoleId());
            if(lAdminEntity.getGender() != 0)
                lAdminEntity1.setGender(lAdminEntity.getGender());
            if(lAdminEntity.getAddTime() != 0)
                lAdminEntity1.setAddTime(lAdminEntity.getAddTime());
            if(lAdminEntity.getUpdTime() != 0)
                lAdminEntity1.setUpdTime(lAdminEntity.getUpdTime());
            if(lAdminEntity.getEmail() != null)
                lAdminEntity1.setEmail(lAdminEntity.getEmail());
            if(lAdminEntity.getImage() != null)
                lAdminEntity1.setImage(lAdminEntity.getImage());

            try{
                session.update(lAdminEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("AdminDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /** 
    * @Description: 通过手机号查询工作人员类 
    * @Param:  String
    * @return:  
    * @Author: DBC
    * @Date: 2019/8/16 
    */ 
    @Override
    public LAdminEntity listByMobile(String mobile) {
        Session session = sessionFactory.openSession();
        List<LAdminEntity> list = null;
        try{
            list = session
                    .createNamedQuery("ADMIN.MOBILE").setParameter("mobile", mobile)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AdminDao查询语句出现问题");
            e.printStackTrace();
        }
        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    /** 
    * @Description: 通过ID查询工作人员信息类 
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/16 
    */ 
    @SuppressWarnings("unchecked")
    @Override
    public LAdminEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LAdminEntity lAdminEntity = null;
        lAdminEntity = (LAdminEntity)session.get(LAdminEntity.class, id);
        return lAdminEntity;
    }

    /** 
    * @Description: 一次性查询所有工作人员列表，默认角色排序，角色排序中默认名字升序排序
    * @Param:  
    * @return:  List<LAdminEntity>
    * @Author: DBC
    * @Date: 2019/8/16 
    */ 
    @Override
    public List<LAdminEntity> list() {
        Session session = sessionFactory.openSession();
        List<LAdminEntity> list = null;
        try{
            list = session
                    .createNamedQuery("ADMIN.ORDER.ROLE_NAME")
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AdminDao查询语句出现问题");
            e.printStackTrace();
        }
        return list;
    }

    /**
    * @Description: 通过角色分组进行查询列表
    * @Param:  int
    * @return:  List<LAdminEntity>
    * @Author: DBC
    * @Date: 2019/8/16
    */
    @Override
    public List<LAdminEntity> listByRoleID(int roleID) {
        Session session = sessionFactory.openSession();
        List<LAdminEntity> list = null;
        try{
            list = session
                    .createNamedQuery("ADMIN.ROLE_ID")
                    .setParameter("roleID", roleID)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("AdminDao查询语句出现问题");
            e.printStackTrace();
        }

        return list;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
