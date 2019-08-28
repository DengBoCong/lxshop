package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.OrderGoodsDao;
import com.dbc.lxshop.Model.Entity.LOrderGoodsEntity;
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
 * @create: 2019-08-28 23:30
 **/
@Repository("orderGoodsDao")
public class OrderGoodsDaoImpl implements OrderGoodsDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加订单商品实体类
    * @Param:  LOrderGoodsEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public boolean addOrderGoods(LOrderGoodsEntity lOrderGoodsEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LOrderGoodsEntity> list = null;
        try{
            list = session.createNamedQuery("ORDER_GOODS.ORDER_ID_GOODS_ID", LOrderGoodsEntity.class)
                    .setParameter("orderId", lOrderGoodsEntity.getOrderId())
                    .setParameter("goodsId", lOrderGoodsEntity.getGoodsId())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderGoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lOrderGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("OrderGoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id删除订单商品
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public boolean deleteOrderGoods(int orderGoodsId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LOrderGoodsEntity lOrderGoodsEntity = null;
        lOrderGoodsEntity = (LOrderGoodsEntity)session.get(LOrderGoodsEntity.class, orderGoodsId);
        if(lOrderGoodsEntity == null) return false;
        else{
            try{
                session.delete(lOrderGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("OrderGoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过订单id查询订单商品
    * @Param:  int
    * @return:  List<LOrderGoodsEntity>
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public List<LOrderGoodsEntity> listByOrderId(int orderId) {
        Session session = sessionFactory.openSession();
        List<LOrderGoodsEntity> list = null;
        try {
            list = session.createNamedQuery("ORDER_GOODS.ORDER_ID", LOrderGoodsEntity.class)
                    .setParameter("orderId", orderId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("OrderGoodsDao查询语句出现问题");
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
