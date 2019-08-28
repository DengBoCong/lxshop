package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.FactoryGoodsDao;
import com.dbc.lxshop.Model.Entity.LFactoryGoodsEntity;
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
 * @create: 2019-08-28 23:43
 **/
@Repository("factoryGoodsDao")
public class FactoryGoodsDaoImpl implements FactoryGoodsDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加厂商商品实体类
    * @Param:  LFactoryGoodsEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public boolean addFactoryGoods(LFactoryGoodsEntity lFactoryGoodsEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LFactoryGoodsEntity> list = null;
        try{
            list = session.createNamedQuery("FACTORY_GOODS.FACTORY_ID_KIND_NAME", LFactoryGoodsEntity.class)
                    .setParameter("factoryId", lFactoryGoodsEntity.getFactoryId())
                    .setParameter("kindName", lFactoryGoodsEntity.getKindName())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryGoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lFactoryGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryGoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id删除厂商商品实体类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public boolean deleteFactoryGoods(int factoryGoodsId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryGoodsEntity lFactoryGoodsEntity = null;
        lFactoryGoodsEntity = (LFactoryGoodsEntity)session.get(LFactoryGoodsEntity.class, factoryGoodsId);
        if(lFactoryGoodsEntity == null) return false;
        else{
            try{
                session.delete(lFactoryGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryGoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新厂商实体类
    * @Param:  LFactoryGoodsEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/29
    */
    @Override
    public boolean updateFactoryGoods(LFactoryGoodsEntity lFactoryGoodsEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LFactoryGoodsEntity lFactoryGoodsEntity1 = null;
        lFactoryGoodsEntity1 = (LFactoryGoodsEntity)session.get(LFactoryGoodsEntity.class, lFactoryGoodsEntity.getId());
        if(lFactoryGoodsEntity1 == null) return false;
        else{
            if(lFactoryGoodsEntity.getKindName() != null){
                List<LFactoryGoodsEntity> list = null;
                try{
                    list = session.createNamedQuery("FACTORY_GOODS.FACTORY_ID_KIND_NAME", LFactoryGoodsEntity.class)
                            .setParameter("factoryId", lFactoryGoodsEntity.getFactoryId())
                            .setParameter("kindName", lFactoryGoodsEntity.getKindName()).getResultList();
                }catch (IllegalArgumentException e){
                    System.out.println("GoodsDao查询语句出现问题");
                    e.printStackTrace();
                }
                if(!list.isEmpty()) return false;
                else lFactoryGoodsEntity1.setKindName(lFactoryGoodsEntity.getKindName());
            }
            if(lFactoryGoodsEntity.getModel() != null)
                lFactoryGoodsEntity1.setModel(lFactoryGoodsEntity.getModel());
            if(lFactoryGoodsEntity.getMaterial() != null)
                lFactoryGoodsEntity1.setMaterial(lFactoryGoodsEntity.getMaterial());
            if(lFactoryGoodsEntity.getStructure() != null)
                lFactoryGoodsEntity1.setStructure(lFactoryGoodsEntity.getStructure());
            if(lFactoryGoodsEntity.getStyle() != null)
                lFactoryGoodsEntity1.setStyle(lFactoryGoodsEntity.getStyle());
            if(lFactoryGoodsEntity.getUse() != null)
                lFactoryGoodsEntity1.setUse(lFactoryGoodsEntity.getUse());
            if(lFactoryGoodsEntity.getSaleMethod() != null)
                lFactoryGoodsEntity1.setSaleMethod(lFactoryGoodsEntity.getSaleMethod());
            if(lFactoryGoodsEntity.getInventory() != null)
                lFactoryGoodsEntity1.setInventory(lFactoryGoodsEntity.getInventory());
            if(lFactoryGoodsEntity.getRemark() != null)
                lFactoryGoodsEntity1.setRemark(lFactoryGoodsEntity.getRemark());

            try{
                session.update(lFactoryGoodsEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("FactoryGoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    @Override
    public boolean listByFactoryId(int factoryId) {
        Session session = sessionFactory.openSession();
        List<LFactoryGoodsEntity> list = null;
        try {
            list = session.createNamedQuery("FACTORY_GOODS.FACTORY_ID", LFactoryGoodsEntity.class)
                    .setParameter("factoryId", factoryId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("FactoryGoodsDao中Session操作出错！");
            e.printStackTrace();
        }
        session.close();
        return true;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
