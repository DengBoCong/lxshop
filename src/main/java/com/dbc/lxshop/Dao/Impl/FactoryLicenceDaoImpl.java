package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.FactoryLicenceDao;
import com.dbc.lxshop.Model.Entity.LFactoryLicenceEntity;
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
 * @create: 2019-08-27 10:30
 **/
@Repository("factoryLicenceDao")
public class FactoryLicenceDaoImpl implements FactoryLicenceDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Description: 添加经销商营业执照实体类
     * @Param:  LFactoryLicenceEntity
     * @return:  boolean
     * @Author: DBC
     * @Date: 2019/8/26
     */
    @Override
    public boolean addFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LFactoryLicenceEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORYLICENCE.FACTORY_ID", LFactoryLicenceEntity.class)
                    .setParameter("userId", lFactoryLicenceEntity.getUserId()).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryLicenceDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lFactoryLicenceEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryLicenceDao中Session操作出错！");
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
    public boolean deleteFactoryLicence(int factoryLicenceId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryLicenceEntity lFactoryLicenceEntity = null;
        lFactoryLicenceEntity = (LFactoryLicenceEntity)session.get(LFactoryLicenceEntity.class, factoryLicenceId);
        if(lFactoryLicenceEntity == null) return false;
        else{
            try{
                session.delete(lFactoryLicenceEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryLicenceDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
     * @Description: 更新经销商营业执照实体类
     * @Param:  LFactoryLicenceEntity
     * @return:  boolean
     * @Author: DBC
     * @Date: 2019/8/26
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateFactoryLicence(LFactoryLicenceEntity lFactoryLicenceEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryLicenceEntity lFactoryLicenceEntity1 = null;
        lFactoryLicenceEntity1 = (LFactoryLicenceEntity)session.get(LFactoryLicenceEntity.class, lFactoryLicenceEntity.getId());
        if(lFactoryLicenceEntity1 == null) return false;
        else{
            if(lFactoryLicenceEntity.getLicenceNumber() != null)
                lFactoryLicenceEntity1.setLicenceNumber(lFactoryLicenceEntity.getLicenceNumber());
            if(lFactoryLicenceEntity.getLicenceName() != null)
                lFactoryLicenceEntity1.setLicenceName(lFactoryLicenceEntity.getLicenceName());
            if(lFactoryLicenceEntity.getLegalPerson() != null)
                lFactoryLicenceEntity1.setLegalPerson(lFactoryLicenceEntity.getLegalPerson());
            if(lFactoryLicenceEntity.getLegalPersonTel() != null)
                lFactoryLicenceEntity1.setLegalPersonTel(lFactoryLicenceEntity.getLegalPersonTel());
            if(lFactoryLicenceEntity.getLegalPersonIdcard() != null)
                lFactoryLicenceEntity1.setLegalPersonIdcard(lFactoryLicenceEntity.getLegalPersonIdcard());
            if(lFactoryLicenceEntity.getLicencePhoto() != null)
                lFactoryLicenceEntity1.setLicencePhoto(lFactoryLicenceEntity.getLicencePhoto());
            if(lFactoryLicenceEntity.getLegalPersonBphoto() != null)
                lFactoryLicenceEntity1.setLegalPersonBphoto(lFactoryLicenceEntity.getLegalPersonBphoto());
            if(lFactoryLicenceEntity.getLegalPersonFphoto() != null)
                lFactoryLicenceEntity1.setLegalPersonFphoto(lFactoryLicenceEntity.getLegalPersonFphoto());

            try{
                session.update(lFactoryLicenceEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryLicenceDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
     * @Description: 通过id查询经销商营业执照实体类
     * @Param:  int
     * @return:  LFactoryLicenceEntity
     * @Author: DBC
     * @Date: 2019/8/26
     */
    @SuppressWarnings("unchecked")
    @Override
    public LFactoryLicenceEntity listById(int factoryLicenceId) {
        Session session = sessionFactory.openSession();
        LFactoryLicenceEntity lFactoryLicenceEntity = null;
        lFactoryLicenceEntity = (LFactoryLicenceEntity)session.get(LFactoryLicenceEntity.class, factoryLicenceId);
        session.close();
        return lFactoryLicenceEntity;
    }

    /**
     * @Description: 通过经销商ID查询经销商营业执照实体类
     * @Param:  int
     * @return:  LFactoryLicenceEntity
     * @Author: DBC
     * @Date: 2019/8/26
     */
    @Override
    public LFactoryLicenceEntity listByFactoryId(int factoryId) {
        Session session = sessionFactory.openSession();
        List<LFactoryLicenceEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORYLICENCE.FACTORY_ID", LFactoryLicenceEntity.class)
                    .setParameter("userId", factoryId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryLicenceDao查询语句出现问题");
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
