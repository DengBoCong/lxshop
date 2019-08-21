package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.GoodsCategoryJoinDao;
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
 * @create: 2019-08-21 10:35
 **/
@Repository("goodsCategoryJoinDao")
public class GoodsCategoryJoinDaoImpl implements GoodsCategoryJoinDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加商品至分类
    * @Param:  LGoodsCategoryJoinEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @Override
    public boolean addGoodsCategoryJoin(LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LGoodsCategoryJoinEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY_JOIN.GOODS_ID_CATEGORY_ID", LGoodsCategoryJoinEntity.class)
                    .setParameter("goodsId", lGoodsCategoryJoinEntity.getGoodsId())
                    .setParameter("categoryId", lGoodsCategoryJoinEntity.getCategoryId())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("LGoodsCategoryJoinDao查询语句出现问题");
            e.printStackTrace();
        }
        if (!list.isEmpty()) return false;
        else{
            try{
                session.save(lGoodsCategoryJoinEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("LGoodsCategoryJoinDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除商品分类信息
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteGoodsCategoryJoin(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity = null;
        lGoodsCategoryJoinEntity = (LGoodsCategoryJoinEntity)session.get(LGoodsCategoryJoinEntity.class, id);
        if(lGoodsCategoryJoinEntity == null) return false;
        else{
            try{
                session.delete(lGoodsCategoryJoinEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("LGoodsCategoryJoinDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过id查询
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/21
    */
    @Override
    public List<LGoodsCategoryJoinEntity> listByGoodsId(int goodsId) {
        Session session = sessionFactory.openSession();
        List<LGoodsCategoryJoinEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_CATEGORY_JOIN.GOODS_ID", LGoodsCategoryJoinEntity.class)
                    .setParameter("goodsId", goodsId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("LGoodsCategoryJoinDao查询语句出现问题");
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
