package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.UserDao;
import com.dbc.lxshop.Model.Entity.LUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-18 17:32
 **/
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description:  添加进销商用户类
    * @Param:  LUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public boolean addUser(LUserEntity lUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LUserEntity> list = null;
        try{
            list = session.createNamedQuery("USER.MOBILE", LUserEntity.class)
                    .setParameter("mobile", lUserEntity.getMobile()).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除经销商类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("umchecked")
    @Override
    public boolean deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserEntity lUserEntity = null;
        lUserEntity = (LUserEntity)session.get(LUserEntity.class, id);
        if(lUserEntity == null) return false;
        else{
            try{
                session.delete(lUserEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新经销商信息类
    * @Param:  LUserEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public boolean updateUser(LUserEntity lUserEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserEntity lUserEntity1 = null;
        lUserEntity1 = (LUserEntity)session.get(LUserEntity.class, lUserEntity.getId());
        if(lUserEntity1 == null) return false;
        else{
            if(lUserEntity.getAlipayAccount() != null)
                lUserEntity1.setAlipayAccount(lUserEntity.getAlipayAccount());
            if(lUserEntity.getWechatCode() != null)
                lUserEntity1.setWechatCode(lUserEntity.getWechatCode());
            if(lUserEntity.getBankAccount() != null)
                lUserEntity1.setBankAccount(lUserEntity.getBankAccount());
            if(lUserEntity.getBankName() != null)
                lUserEntity1.setBankName(lUserEntity.getBankName());
            if(lUserEntity.getName() != null)
                lUserEntity1.setName(lUserEntity.getName());
            if(lUserEntity.getPwd() != null)
                lUserEntity1.setPwd(DigestUtils.md5DigestAsHex(lUserEntity.getPwd().getBytes()));
            if(lUserEntity.getStatus() != 0)
                lUserEntity1.setStatus(lUserEntity.getStatus());
            if(lUserEntity.getMobile() != null){
                List<LUserEntity> list = null;
                try{
                    list = session.createNamedQuery("USER.MOBILE", LUserEntity.class)
                            .setParameter("mobile", lUserEntity.getMobile()).getResultList();
                }catch (IllegalArgumentException e){
                    System.out.println("UserDao查询语句出现问题");
                    e.printStackTrace();
                }
                if(!list.isEmpty()) return false;
                else lUserEntity1.setMobile(lUserEntity.getMobile());
            }
            if(lUserEntity.getEmail() != null)
                lUserEntity1.setEmail(lUserEntity.getEmail());
            if(lUserEntity.getAvatar() != null)
                lUserEntity1.setAvatar(lUserEntity.getAvatar());
            if(lUserEntity.getProvince() != null)
                lUserEntity1.setProvince(lUserEntity.getProvince());
            if(lUserEntity.getCity() != null)
                lUserEntity1.setCity(lUserEntity.getCity());
            if(lUserEntity.getAvatar() != null)
                lUserEntity1.setAvatar(lUserEntity.getAvatar());
            if(lUserEntity.getAddress() != null)
                lUserEntity1.setAddress(lUserEntity.getAddress());
            if(lUserEntity.getIntegral() != 0)
                lUserEntity1.setIntegral(lUserEntity.getIntegral());
            if(lUserEntity.getSalesmanId() != 0)
                lUserEntity1.setSalesmanId(lUserEntity.getSalesmanId());
            if(lUserEntity.getAddTime() != 0)
                lUserEntity1.setAddTime(lUserEntity.getAddTime());
            if(lUserEntity.getUpdTime() != 0)
                lUserEntity1.setUpdTime(lUserEntity.getUpdTime());
            if(lUserEntity.getLicenceId() != 0)
                lUserEntity1.setLicenceId(lUserEntity.getLicenceId());
            if(lUserEntity.getOrderCount() != 0)
                lUserEntity1.setOrderCount(lUserEntity.getOrderCount());
            if(lUserEntity.getSellCount() != null)
                lUserEntity1.setSellCount(lUserEntity.getSellCount());
            if(lUserEntity.getAreaId() != 0)
                lUserEntity1.setAreaId(lUserEntity.getAreaId());

            try{
                session.update(lUserEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id查询经销商信息类
    * @Param:  int
    * @return:  LUserEntity
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("unchecked")
    @Override
    public LUserEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LUserEntity lUserEntity = null;
        lUserEntity = (LUserEntity)session.get(LUserEntity.class, id);
        session.close();
        return lUserEntity;
    }

    /**
    * @Description: 通过手机号查询经销商
    * @Param:  String
    * @return:  LUserEntity
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public LUserEntity listByMobile(String mobile) {
        Session session = sessionFactory.openSession();
        List<LUserEntity> list = null;
        try{
            list = session.createNamedQuery("USER.MOBILE", LUserEntity.class)
                    .setParameter("mobile", mobile).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    /**
    * @Description: 查询所有经销商信息类
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LUserEntity> list() {
        Session session = sessionFactory.openSession();
        List<LUserEntity> list = null;
        try{
            list = session.createNamedQuery("USER.ORDERBY_NAME", LUserEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 返回所有经销商用户数量
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listUserCount() {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("USER.USER_COUNT").list();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    /**
    * @Description: 返回该时间戳之后的经销商用户数量
    * @Param:  int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listLastTimeUserCount(int mills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("USER.LAST_TIME_USER_COUNT")
                    .setParameter("mills", mills).list();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    /**
    * @Description: 返回两个时间戳之间的经销商用户数量
    * @Param:  int int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listBtwTimeUserCount(int beginMills, int endMills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("USER.BTW_TIME_USER_COUNT")
                    .setParameter("beginTime", beginMills)
                    .setParameter("endTime", endMills).list();
        }catch (IllegalArgumentException e){
            System.out.println("UserDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
