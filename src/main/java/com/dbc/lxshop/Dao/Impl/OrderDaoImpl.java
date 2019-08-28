package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.OrderDao;
import com.dbc.lxshop.Model.Entity.LOrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-17 22:08
 **/
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加订单类
    * @Param:  LOrderEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/17
    */
    @Override
    public boolean addOrder(LOrderEntity lOrderEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LOrderEntity> list = null;
        try{
            list = session.createNamedQuery("ORDER.ORDER_NO", LOrderEntity.class)
                    .setParameter("orderNo", lOrderEntity.getOrderNo())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lOrderEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("OrderDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 对订单类进行更新
    * @Param:  LOrderEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateOrder(LOrderEntity lOrderEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOrderEntity lOrderEntity1 = null;
        lOrderEntity1 = (LOrderEntity)session.get(LOrderEntity.class, lOrderEntity.getId());
        if(lOrderEntity1 == null) return false;
        else{
            if(lOrderEntity.getFactoryId() != 0)
                lOrderEntity1.setFactoryId(lOrderEntity.getFactoryId());
            if(lOrderEntity.getUserId() != 0)
                lOrderEntity1.setUserId(lOrderEntity.getUserId());
            if(lOrderEntity.getReceiveName() != null)
                lOrderEntity1.setReceiveName(lOrderEntity.getReceiveName());
            if(lOrderEntity.getReceiveTel() != null)
                lOrderEntity1.setReceiveTel(lOrderEntity.getReceiveTel());
            if(lOrderEntity.getReceiveProvince() != null)
                lOrderEntity1.setReceiveProvince(lOrderEntity.getReceiveProvince());
            if(lOrderEntity.getReceiveCity() != null)
                lOrderEntity1.setReceiveCity(lOrderEntity.getReceiveCity());
            if(lOrderEntity.getReceiveCounty() != null)
                lOrderEntity1.setReceiveCounty(lOrderEntity.getReceiveCounty());
            if(lOrderEntity.getReceiveAddress() != null)
                lOrderEntity1.setReceiveAddress(lOrderEntity.getReceiveAddress());
            if(lOrderEntity.getUserNote() != null)
                lOrderEntity1.setUserNote(lOrderEntity.getUserNote());
            if(lOrderEntity.getExpressNumber() != null)
                lOrderEntity1.setExpressNumber(lOrderEntity.getExpressNumber());
            if(lOrderEntity.getExpress() != null)
                lOrderEntity1.setExpress(lOrderEntity.getExpress());
            if(lOrderEntity.getPayment() != null)
                lOrderEntity1.setPayment(lOrderEntity.getPayment());
            if(lOrderEntity.getStatus() != 0)
                lOrderEntity1.setStatus(lOrderEntity.getStatus());
            if(lOrderEntity.getPayStatus() != 0)
                lOrderEntity1.setPayStatus(lOrderEntity.getPayStatus());
            if(lOrderEntity.getPreferentialPrice() != null)
                lOrderEntity1.setPreferentialPrice(lOrderEntity.getPreferentialPrice());
            if(lOrderEntity.getPrice() != null)
                lOrderEntity1.setPrice(lOrderEntity.getPrice());
            if(lOrderEntity.getTotalPrice() != null)
                lOrderEntity1.setTotalPrice(lOrderEntity.getTotalPrice());
            if(lOrderEntity.getPayPrice() != null)
                lOrderEntity1.setPayPrice(lOrderEntity.getPayPrice());
            if(lOrderEntity.getPayTime() != 0)
                lOrderEntity1.setPayTime(lOrderEntity.getPayTime());
            if(lOrderEntity.getConfirmTime() != 0)
                lOrderEntity1.setConfirmTime(lOrderEntity.getConfirmTime());
            if(lOrderEntity.getDeliveryTime() != 0)
                lOrderEntity1.setDeliveryTime(lOrderEntity.getDeliveryTime());
            if(lOrderEntity.getCancelTime() != 0)
                lOrderEntity1.setCancelTime(lOrderEntity.getCancelTime());
            if(lOrderEntity.getCollectTime() != 0)
                lOrderEntity1.setCollectTime(lOrderEntity.getCollectTime());
            if(lOrderEntity.getCloseTime() != 0)
                lOrderEntity1.setCloseTime(lOrderEntity.getCloseTime());
            if(lOrderEntity.getAddTime() != 0)
                lOrderEntity1.setAddTime(lOrderEntity.getAddTime());
            if(lOrderEntity.getUpdTime() != 0)
                lOrderEntity1.setUpdTime(lOrderEntity.getUpdTime());
            if(lOrderEntity.getInteger() != 0)
                lOrderEntity1.setInteger(lOrderEntity.getInteger());
            if(lOrderEntity.getSpecCode() != null)
                lOrderEntity1.setSpecCode(lOrderEntity.getSpecCode());

            try{
                session.update(lOrderEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("OrderDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除订单类
    * @Param:  LOrderEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/17
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteOrder(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOrderEntity lOrderEntity = null;
        lOrderEntity = (LOrderEntity)session.get(LOrderEntity.class, id);
        if(lOrderEntity == null) return false;
        else{
            try{
                session.delete(lOrderEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("OrderDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id查询订单
    * @Param:  int
    * @return:  LOrderEntity
    * @Author: DBC
    * @Date: 2019/8/17
    */
    @SuppressWarnings("unchecked")
    @Override
    public LOrderEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LOrderEntity lOrderEntity = null;
        lOrderEntity = (LOrderEntity) session.get(LOrderEntity.class, id);
        session.close();
        return lOrderEntity;
    }

    /**
    * @Description: 返回订单所有列表，默认排序状态，订单号
    * @Param:
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LOrderEntity> list() {
        Session session = sessionFactory.openSession();
        List<LOrderEntity> list = null;
        try{
             list = session
                    .createNamedQuery("ORDER.ORDERBY.STATUS_ORDERNO", LOrderEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过厂家id查询订单
    * @Param:  int
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LOrderEntity> listByFactoryId(int factoryId) {
        Session session = sessionFactory.openSession();
        List<LOrderEntity> list = null;
        try{
            list = session
                    .createNamedQuery("ORDER.FACTORY_ID", LOrderEntity.class)
                    .setParameter("factoryId", factoryId)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过订单号查询订单
    * @Param:  String
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LOrderEntity> listByOrderNo(String orderNo) {
        Session session = sessionFactory.openSession();
        List<LOrderEntity> list = null;
        try{
            list = session.createNamedQuery("ORDER.ORDER_NO", LOrderEntity.class)
                    .setParameter("orderNo", orderNo)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过订单状态查询订单
    * @Param:  int
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LOrderEntity> listByStatus(int status) {
        Session session = sessionFactory.openSession();
        List<LOrderEntity> list = null;
        try{
            list = session.createNamedQuery("ORDER.STATUS", LOrderEntity.class)
                    .setParameter("status", (byte)status)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过经销商id进行查询订单
    * @Param:  int
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public List<LOrderEntity> listByUserId(int userId) {
        Session session = sessionFactory.openSession();
        List<LOrderEntity> list = null;
        try{
            list = session.createNamedQuery("ORDER.USER_ID", LOrderEntity.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 输出该时间戳之后的销售额
    * @Param:  int
    * @return:  BigDecimal
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public BigDecimal listLastTimeSellCount(int mills) {
        Session session = sessionFactory.openSession();
        /*BigDecimal bigDecimal = null;*/
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_LAST_TIME_SELL_COUNT")
                    .setParameter("mills", mills).list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return new BigDecimal(0.00);
        else return (BigDecimal)list.get(0);
    }


    /**
    * @Description: 返回该时间戳之后的订单数量
    * @Param:  int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listLastTimeOrderCount(int mills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_LAST_TIME_ORDER_COUNT")
                    .setParameter("mills", mills).list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if (list.isEmpty()) return new Long(0);
        else return (long)list.get(0);
    }

    /**
    * @Description: 查询所有销售额
    * @Param:
    * @return:  BigDecimal
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public BigDecimal listSellCount() {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_SELL_COUNT").list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return new BigDecimal(0.00);
        else return (BigDecimal) list.get(0);
    }

    /**
    * @Description:  查询所有订单量
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listOrderCount() {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_ORDER_COUNT").list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return new Long(0);
        else return (long) list.get(0);
    }

    /**
    * @Description: 查询两个时间戳之间的销售额
    * @Param:  int int
    * @return:  BigDecimal
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public BigDecimal listBtwTimeSellCount(int beginMills, int endMills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_BTW_TIME_SELL_COUNT")
                    .setParameter("beginTime", beginMills)
                    .setParameter("endTime", endMills).list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return new BigDecimal(0.00);
        else return (BigDecimal) list.get(0);
    }

    /**
    * @Description: 查询两个时间戳之间的订单量
    * @Param:  int int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listBtwTimeOrderCount(int beginMills, int endMills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("ORDER.C_BTW_TIME_ORDER_COUNT")
                    .setParameter("beginTime", beginMills)
                    .setParameter("endTime", endMills).list();
        }catch (IllegalArgumentException e){
            System.out.println("OrderDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return new Long(0);
        else return (long) list.get(0);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
