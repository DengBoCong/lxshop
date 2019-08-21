package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.GoodsCategoryDao;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;
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
 * @create: 2019-08-21 09:56
 **/
@Repository("goodsCategoryDao")
public class GoodsCategoryDaoImpl implements GoodsCategoryDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加商品分类
    * @Param:  LGoodsCategoryEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @Override
    public boolean addGoodsCategory(LGoodsCategoryEntity lGoodsCategoryEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LGoodsCategoryEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY.NAME.PID", LGoodsCategoryEntity.class)
                    .setParameter("pid", lGoodsCategoryEntity.getPid())
                    .setParameter("name", lGoodsCategoryEntity.getName())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsCategoryDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lGoodsCategoryEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsCategoryDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除商品分类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteGoodsCategory(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsCategoryEntity lGoodsCategoryEntity = null;
        lGoodsCategoryEntity = (LGoodsCategoryEntity)session.get(LGoodsCategoryEntity.class, id);
        if(lGoodsCategoryEntity == null) return false;
        else{
            try{
                session.delete(lGoodsCategoryEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsCategoryDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新商品分类
    * @Param:  LGoodsCategoryEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateGood(LGoodsCategoryEntity lGoodsCategoryEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsCategoryEntity lGoodsCategoryEntity1 = null;
        lGoodsCategoryEntity1 = (LGoodsCategoryEntity)session.get(LGoodsCategoryEntity.class, lGoodsCategoryEntity.getId());
        if (lGoodsCategoryEntity1 == null) return false;
        else{
            if(lGoodsCategoryEntity.getPid() != 0)
                lGoodsCategoryEntity1.setPid(lGoodsCategoryEntity.getPid());
            if(lGoodsCategoryEntity.getIcon() != null)
                lGoodsCategoryEntity1.setIcon(lGoodsCategoryEntity.getIcon());
            if(lGoodsCategoryEntity.getName() != null)
                lGoodsCategoryEntity1.setName(lGoodsCategoryEntity.getName());
            if(lGoodsCategoryEntity.getIsHomeRecommended() != 0)
                lGoodsCategoryEntity1.setIsHomeRecommended(lGoodsCategoryEntity.getIsHomeRecommended());
            if(lGoodsCategoryEntity.getSort() != 0)
                lGoodsCategoryEntity1.setSort(lGoodsCategoryEntity.getSort());
            if(lGoodsCategoryEntity.getAddTime() != 0)
                lGoodsCategoryEntity1.setAddTime(lGoodsCategoryEntity.getAddTime());
            if(lGoodsCategoryEntity.getUpdTime() != 0)
                lGoodsCategoryEntity1.setUpdTime(lGoodsCategoryEntity.getUpdTime());

            try{
                session.update(lGoodsCategoryEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsCategoryDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /** 
    * @Description: 通过id查询 
    * @Param:  int
    * @return:  LGoodsCategory
    * @Author: DBC
    * @Date: 2019/8/21 
    */ 
    @SuppressWarnings("unchecked")
    @Override
    public LGoodsCategoryEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LGoodsCategoryEntity lGoodsCategoryEntity = null;
        lGoodsCategoryEntity = (LGoodsCategoryEntity)session.get(LGoodsCategoryEntity.class, id);
        session.close();
        return lGoodsCategoryEntity;
    }

    /** 
    * @Description: 查询所有商品分类 
    * @Param:  
    * @return:  List<LGoodsCategoryEntity>
    * @Author: DBC
    * @Date: 2019/8/21 
    */ 
    @Override
    public List<LGoodsCategoryEntity> list() {
        Session session = sessionFactory.openSession();
        List<LGoodsCategoryEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY.ORDER_BY_PID", LGoodsCategoryEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsCategoryDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 查询所有一级商品分类
    * @Param:
    * @return:  List<LGoodsCategoryEntity>
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @Override
    public List<LGoodsCategoryEntity> listByFirst() {
        Session session = sessionFactory.openSession();
        List<LGoodsCategoryEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY.PARENT_PID", LGoodsCategoryEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsCategoryDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 查询二级商品分类
    * @Param:
    * @return:  List<LGoodsCategoryEntity>
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @Override
    public List<LGoodsCategoryEntity> listBySecond() {
        Session session = sessionFactory.openSession();
        List<LGoodsCategoryEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY.CHILDREN_PID", LGoodsCategoryEntity.class)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsCategoryDao查询语句出现问题");
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
