package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.FactoryUserDao;
import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;
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
 * @create: 2019-08-26 16:28
 **/
@Repository("factoryUserDao")
public class FactoryUserDaoImpl implements FactoryUserDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加厂商用户实体类
    * @Param:  LFactoryUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public boolean addFactoryUser(LFactoryUserEntity lFactoryUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LFactoryUserEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORY_USER.MOBILE", LFactoryUserEntity.class)
                    .setParameter("mobile", lFactoryUserEntity.getMobile()).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryUserDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lFactoryUserEntity);
                System.out.println("111");
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id进行删除厂商实体类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteFactoryUser(int factoryId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryUserEntity lFactoryUserEntity = null;
        lFactoryUserEntity = (LFactoryUserEntity)session.get(LFactoryUserEntity.class, factoryId);
        if(lFactoryUserEntity == null) return false;
        else{
            try{
                session.delete(lFactoryUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新厂商实体类
    * @Param:  LFactoryUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateFactoryUser(LFactoryUserEntity lFactoryUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryUserEntity lFactoryUserEntity1 = null;
        lFactoryUserEntity1 = (LFactoryUserEntity)session.get(LFactoryUserEntity.class, lFactoryUserEntity.getId());
        if(lFactoryUserEntity1 == null) return false;
        else{
            if(lFactoryUserEntity.getAlipayAccount() != null)
                lFactoryUserEntity1.setAlipayAccount(lFactoryUserEntity.getAlipayAccount());
            if(lFactoryUserEntity.getWechatCode() != null)
                lFactoryUserEntity1.setWechatCode(lFactoryUserEntity.getWechatCode());
            if(lFactoryUserEntity.getBankAccount() != null)
                lFactoryUserEntity1.setBankAccount(lFactoryUserEntity.getBankAccount());
            if(lFactoryUserEntity.getBankName() != null)
                lFactoryUserEntity1.setBankName(lFactoryUserEntity.getBankName());
            if(lFactoryUserEntity.getName() != null)
                lFactoryUserEntity1.setName(lFactoryUserEntity.getName());
            if(lFactoryUserEntity.getPwd() != null)
                lFactoryUserEntity1.setPwd(DigestUtils.md5DigestAsHex(lFactoryUserEntity.getPwd().getBytes()));
            if(lFactoryUserEntity.getStatus() != 0)
                lFactoryUserEntity1.setStatus(lFactoryUserEntity.getStatus());
            if(lFactoryUserEntity.getMobile() != null){
                List<LFactoryUserEntity> list = null;
                try{
                    list = session.createNamedQuery("FACTORY_USER.MOBILE", LFactoryUserEntity.class)
                            .setParameter("mobile", lFactoryUserEntity.getMobile()).getResultList();
                }catch (IllegalArgumentException e){
                    System.out.println("FactoryUserDao查询语句出现问题");
                    e.printStackTrace();
                }
                if(!list.isEmpty()) return false;
                else lFactoryUserEntity1.setMobile(lFactoryUserEntity.getMobile());
            }
            if(lFactoryUserEntity.getEmail() != null)
                lFactoryUserEntity1.setEmail(lFactoryUserEntity.getEmail());
            if(lFactoryUserEntity.getAvatar() != null)
                lFactoryUserEntity1.setAvatar(lFactoryUserEntity.getAvatar());
            if(lFactoryUserEntity.getProvince() != null)
                lFactoryUserEntity1.setProvince(lFactoryUserEntity.getProvince());
            if(lFactoryUserEntity.getCity() != null)
                lFactoryUserEntity1.setCity(lFactoryUserEntity.getCity());
            if(lFactoryUserEntity.getAvatar() != null)
                lFactoryUserEntity1.setAvatar(lFactoryUserEntity.getAvatar());
            if(lFactoryUserEntity.getAddress() != null)
                lFactoryUserEntity1.setAddress(lFactoryUserEntity.getAddress());
            if(lFactoryUserEntity.getSalesmanId() != 0)
                lFactoryUserEntity1.setSalesmanId(lFactoryUserEntity.getSalesmanId());
            if(lFactoryUserEntity.getAddTime() != 0)
                lFactoryUserEntity1.setAddTime(lFactoryUserEntity.getAddTime());
            if(lFactoryUserEntity.getUpdTime() != 0)
                lFactoryUserEntity1.setUpdTime(lFactoryUserEntity.getUpdTime());
            if(lFactoryUserEntity.getLicenceId() != 0)
                lFactoryUserEntity1.setLicenceId(lFactoryUserEntity.getLicenceId());
            if(lFactoryUserEntity.getOrderCount() != 0)
                lFactoryUserEntity1.setOrderCount(lFactoryUserEntity.getOrderCount());
            if(lFactoryUserEntity.getSellCount() != null)
                lFactoryUserEntity1.setSellCount(lFactoryUserEntity.getSellCount());
            if(lFactoryUserEntity.getCapacity() != null)
                lFactoryUserEntity1.setCapacity(lFactoryUserEntity.getCapacity());
            if(lFactoryUserEntity.getQuality() != null)
                lFactoryUserEntity1.setQuality(lFactoryUserEntity.getQuality());
            if(lFactoryUserEntity.getStability() != null)
                lFactoryUserEntity1.setStability(lFactoryUserEntity.getStability());
            if(lFactoryUserEntity.getCircumstance() != null)
                lFactoryUserEntity1.setCircumstance(lFactoryUserEntity.getCircumstance());
            if(lFactoryUserEntity.getReport() != null)
                lFactoryUserEntity1.setReport(lFactoryUserEntity.getReport());
            if(lFactoryUserEntity.getAreaId() != 0)
                lFactoryUserEntity1.setAreaId(lFactoryUserEntity.getAreaId());

            try{
                session.update(lFactoryUserEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryUserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id查询厂商实体类
    * @Param: int
    * @return:  LFactoryUserEntity
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public LFactoryUserEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LFactoryUserEntity lFactoryUserEntity = null;
        lFactoryUserEntity = (LFactoryUserEntity)session.get(LFactoryUserEntity.class, id);
        session.close();
        return lFactoryUserEntity;
    }

    /**
    * @Description: 通过片区ID进行查询厂商实体类
    * @Param:  int
    * @return:  List<LFactoryUserEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LFactoryUserEntity> listByAreaId(int areaId) {
        Session session = sessionFactory.openSession();
        List<LFactoryUserEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORY_USER.AREA_ID", LFactoryUserEntity.class)
                    .setParameter("areaId", areaId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryUserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 查询所有厂商实体类
    * @Param:
    * @return:  List<LFactoryUserEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LFactoryUserEntity> list() {
        Session session = sessionFactory.openSession();
        List<LFactoryUserEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORY_USER.ORDER_BY_NAME", LFactoryUserEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryUserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    @Override
    public List<LFactoryUserEntity> listBySalesmanId(int salesmanId) {
        Session session = sessionFactory.openSession();
        List<LFactoryUserEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORY_USER.SALESMAN_ID", LFactoryUserEntity.class)
                    .setParameter("salesmanId", salesmanId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryUserDao查询语句出现问题");
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
