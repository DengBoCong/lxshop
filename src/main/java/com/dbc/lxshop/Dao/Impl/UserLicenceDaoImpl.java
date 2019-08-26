package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.UserLicenceDao;
import com.dbc.lxshop.Model.Entity.LUserLicenceEntity;
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
 * @create: 2019-08-26 20:05
 **/
@Repository("userLicenceDao")
public class UserLicenceDaoImpl implements UserLicenceDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加经销商营业执照实体类
    * @Param:  LUserLicenceEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public boolean addUserLicence(LUserLicenceEntity lUserLicenceEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LUserLicenceEntity> list = null;
        try{
            list = session.createNamedQuery("USERLICENCE.USER_ID", LUserLicenceEntity.class)
                    .setParameter("userId", lUserLicenceEntity.getUserId()).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserLicenceDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lUserLicenceEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserLicenceDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id删除经销商营业执照实体类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteUserLicence(int userLicenceId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserLicenceEntity lUserLicenceEntity = null;
        lUserLicenceEntity = (LUserLicenceEntity)session.get(LUserLicenceEntity.class, userLicenceId);
        if(lUserLicenceEntity == null) return false;
        else{
            try{
                session.delete(lUserLicenceEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserLicenceDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新经销商营业执照实体类
    * @Param:  LUserLicenceEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateUserLicence(LUserLicenceEntity lUserLicenceEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserLicenceEntity lUserLicenceEntity1 = null;
        lUserLicenceEntity1 = (LUserLicenceEntity)session.get(LUserLicenceEntity.class, lUserLicenceEntity.getId());
        if(lUserLicenceEntity1 == null) return false;
        else{
            if(lUserLicenceEntity.getLicenceNumber() != null)
                lUserLicenceEntity1.setLicenceNumber(lUserLicenceEntity.getLicenceNumber());
            if(lUserLicenceEntity.getLicenceName() != null)
                lUserLicenceEntity1.setLicenceName(lUserLicenceEntity.getLicenceName());
            if(lUserLicenceEntity.getLegalPerson() != null)
                lUserLicenceEntity1.setLegalPerson(lUserLicenceEntity.getLegalPerson());
            if(lUserLicenceEntity.getLegalPersonTel() != null)
                lUserLicenceEntity1.setLegalPersonTel(lUserLicenceEntity.getLegalPersonTel());
            if(lUserLicenceEntity.getLegalPersonIdcard() != null)
                lUserLicenceEntity1.setLegalPersonIdcard(lUserLicenceEntity.getLegalPersonIdcard());
            if(lUserLicenceEntity.getLicencePhoto() != null)
                lUserLicenceEntity1.setLicencePhoto(lUserLicenceEntity.getLicencePhoto());
            if(lUserLicenceEntity.getLegalPersonBphoto() != null)
                lUserLicenceEntity1.setLegalPersonBphoto(lUserLicenceEntity.getLegalPersonBphoto());
            if(lUserLicenceEntity.getLegalPersonFphoto() != null)
                lUserLicenceEntity1.setLegalPersonFphoto(lUserLicenceEntity.getLegalPersonFphoto());

            try{
                session.update(lUserLicenceEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserLicenceDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id查询经销商营业执照实体类
    * @Param:  int
    * @return:  LUserLicenceEntity
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public LUserLicenceEntity listById(int userLicenceId) {
        Session session = sessionFactory.openSession();
        LUserLicenceEntity lUserLicenceEntity = null;
        lUserLicenceEntity = (LUserLicenceEntity)session.get(LUserLicenceEntity.class, userLicenceId);
        session.close();
        return lUserLicenceEntity;
    }

    /**
    * @Description: 通过经销商ID查询经销商营业执照实体类
    * @Param:  int
    * @return:  LUserLicenceEntity
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public LUserLicenceEntity listByUserId(int userId) {
        Session session = sessionFactory.openSession();
        List<LUserLicenceEntity> list = null;
        try{
            list = session.createNamedQuery("USERLICENCE.USER_ID", LUserLicenceEntity.class)
                    .setParameter("userId", userId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserLicenceDao查询语句出现问题");
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
