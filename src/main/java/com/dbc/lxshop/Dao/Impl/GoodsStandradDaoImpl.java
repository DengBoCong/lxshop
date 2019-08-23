package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.GoodsStandradDao;
import com.dbc.lxshop.Model.Entity.LGoodsStandradEntity;
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
 * @create: 2019-08-22 15:38
 **/
@Repository("goodsStandradDao")
public class GoodsStandradDaoImpl implements GoodsStandradDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加商品属性类
    * @Param:  LGoodsStandradEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @Override
    public boolean addGoodsStandrad(LGoodsStandradEntity lGoodsStandradEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LGoodsStandradEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_STANDRAD.MEASURE_COLOR", LGoodsStandradEntity.class)
                    .setParameter("goodsId", lGoodsStandradEntity.getGoodsId())
                    .setParameter("measure", lGoodsStandradEntity.getMeasure())
                    .setParameter("color", lGoodsStandradEntity.getColor())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsStandradDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lGoodsStandradEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsStandradDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除商品属性类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteGoodsStandrad(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsStandradEntity lGoodsStandradEntity = null;
        lGoodsStandradEntity = (LGoodsStandradEntity)session.get(LGoodsStandradEntity.class, id);
        if(lGoodsStandradEntity == null) return false;
        else{
            try{
                session.delete(lGoodsStandradEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsStandradDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新商品属性类
    * @Param:  LGoodsStandradEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateGoodsStandrad(LGoodsStandradEntity lGoodsStandradEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsStandradEntity lGoodsStandradEntity1 = null;
        lGoodsStandradEntity1 = (LGoodsStandradEntity)session.get(LGoodsStandradEntity.class, lGoodsStandradEntity.getId());
        if(lGoodsStandradEntity1 == null) return false;
        else{
            if(lGoodsStandradEntity.getMeasure() != null)
                lGoodsStandradEntity1.setMeasure(lGoodsStandradEntity.getMeasure());
            if(lGoodsStandradEntity.getColor() != null)
                lGoodsStandradEntity1.setColor(lGoodsStandradEntity.getColor());
            if(lGoodsStandradEntity.getFactoryPrice() != null)
                lGoodsStandradEntity1.setFactoryPrice(lGoodsStandradEntity.getFactoryPrice());
            if(lGoodsStandradEntity.getOriginPrice() != null)
                lGoodsStandradEntity1.setOriginPrice(lGoodsStandradEntity.getOriginPrice());
            if(lGoodsStandradEntity.getGuidePrice() != null)
                lGoodsStandradEntity1.setGuidePrice(lGoodsStandradEntity.getGuidePrice());
            if(lGoodsStandradEntity.getInventory() != 0)
                lGoodsStandradEntity1.setInventory(lGoodsStandradEntity.getInventory());
            if(lGoodsStandradEntity.getAddTime() != 0)
                lGoodsStandradEntity.setAddTime(lGoodsStandradEntity.getAddTime());

            try{
                session.update(lGoodsStandradEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsStandradDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 查询所有商品属性类
    * @Param:
    * @return:  List<LGoodsStandradEntity>
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @Override
    public List<LGoodsStandradEntity> list() {
        Session session = sessionFactory.openSession();
        List<LGoodsStandradEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_STANDRAD.ORDER_BY_GOODS_ID", LGoodsStandradEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsStandradDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过商品id进行查询
    * @Param:  int
    * @return:  List<LGoodsStandradEntity>
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @Override
    public List<LGoodsStandradEntity> listByGoodid(int goodId) {
        Session session = sessionFactory.openSession();
        List<LGoodsStandradEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_STANDRAD.GOODS_ID", LGoodsStandradEntity.class)
                    .setParameter("goodsId", goodId)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsStandradDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过商品id， 尺寸，颜色查询
    * @Param:  int String String
    * @return:  LGoodsStandradEntity
    * @Author: DBC
    * @Date: 2019/8/22
    */
    @Override
    public LGoodsStandradEntity listByGoodIdMeasureColor(int goodId, String measure, String color) {
        Session session = sessionFactory.openSession();
        List<LGoodsStandradEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_STANDRAD.MEASURE_COLOR", LGoodsStandradEntity.class)
                    .setParameter("goodsId", goodId)
                    .setParameter("measure", measure)
                    .setParameter("color", color)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsStandradDao查询语句出现问题");
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
