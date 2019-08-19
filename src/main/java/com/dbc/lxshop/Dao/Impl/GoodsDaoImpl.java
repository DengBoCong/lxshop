package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.GoodsDao;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;
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
 * @create: 2019-08-18 16:50
 **/
@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加商品类
    * @Param:  LGoodsEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public boolean addGoods(LGoodsEntity lGoodsEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<LGoodsEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS.TITLE", LGoodsEntity.class)
                    .setParameter("title", lGoodsEntity.getTitle())
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        if(!list.isEmpty()) return false;
        else{
            try{
                session.save(lGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 删除商品类
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteGoods(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsEntity lGoodsEntity = null;
        lGoodsEntity = (LGoodsEntity)session.get(LGoodsEntity.class, id);
        if(lGoodsEntity == null) return false;
        else{
            try{
                session.delete(lGoodsEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新商品信息类
    * @Param:  LGoodsEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateGoods(LGoodsEntity lGoodsEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsEntity lGoodsEntity1 = null;
        lGoodsEntity1 = (LGoodsEntity) session.get(LGoodsEntity.class, lGoodsEntity.getId());
        if(lGoodsEntity1 == null) return false;
        else{
            if(lGoodsEntity.getTitle() != null){
                List<LGoodsEntity> list = null;
                try{
                    list = session.createNamedQuery("GOODS.TITLE", LGoodsEntity.class)
                            .setParameter("title", lGoodsEntity.getTitle()).getResultList();
                }catch (IllegalArgumentException e){
                    System.out.println("GoodsDao查询语句出现问题");
                    e.printStackTrace();
                }
                if(!list.isEmpty()) return false;
                else lGoodsEntity1.setTitle(lGoodsEntity.getTitle());
            }
            if(lGoodsEntity.getInventory() != 0)
                lGoodsEntity1.setInventory(lGoodsEntity.getInventory());
            if(lGoodsEntity.getInventoryUnit() != null)
                lGoodsEntity1.setInventoryUnit(lGoodsEntity.getInventoryUnit());
            if(lGoodsEntity.getImages() != null)
                lGoodsEntity1.setImages(lGoodsEntity.getImages());
            if(lGoodsEntity.getPrice() != null)
                lGoodsEntity1.setPrice(lGoodsEntity.getPrice());
            if(lGoodsEntity.getIsShelves() != 0)
                lGoodsEntity1.setIsShelves(lGoodsEntity.getIsShelves());
            if(lGoodsEntity.getIsHomeRecommended() != 0)
                lGoodsEntity1.setIsHomeRecommended(lGoodsEntity.getIsHomeRecommended());
            if(lGoodsEntity.getContent() != null)
                lGoodsEntity1.setContent(lGoodsEntity.getContent());
            if(lGoodsEntity.getSalesCount() != 0)
                lGoodsEntity1.setSalesCount(lGoodsEntity.getSalesCount());
            if(lGoodsEntity.getAccessCount() != 0)
                lGoodsEntity1.setAccessCount(lGoodsEntity.getAccessCount());
            if(lGoodsEntity.getAddTime() != 0)
                lGoodsEntity1.setAddTime(lGoodsEntity.getAddTime());
            if(lGoodsEntity.getUpdTime() != 0)
                lGoodsEntity1.setUpdTime(lGoodsEntity.getUpdTime());
            if(lGoodsEntity.getHomeRecommendedImages() != null)
                lGoodsEntity1.setHomeRecommendedImages(lGoodsEntity.getHomeRecommendedImages());
            if(lGoodsEntity.getAfterSalesInstruction() != null)
                lGoodsEntity1.setAfterSalesInstruction(lGoodsEntity.getAfterSalesInstruction());
            if(lGoodsEntity.getOrigin() != null)
                lGoodsEntity1.setOrigin(lGoodsEntity.getOrigin());
            if(lGoodsEntity.getKindName() != null)
                lGoodsEntity1.setKindName(lGoodsEntity.getKindName());
            if(lGoodsEntity.getModel() != null)
                lGoodsEntity1.setModel(lGoodsEntity.getModel());
            if(lGoodsEntity.getMaterial() != null)
                lGoodsEntity1.setMaterial(lGoodsEntity.getMaterial());
            if(lGoodsEntity.getStructure() != null)
                lGoodsEntity1.setStructure(lGoodsEntity.getStructure());
            if(lGoodsEntity.getStyle() != null)
                lGoodsEntity1.setStyle(lGoodsEntity.getStyle());
            if(lGoodsEntity.getUse() != null)
                lGoodsEntity1.setUse(lGoodsEntity.getUse());
            if(lGoodsEntity.getSaleMethod() != null)
                lGoodsEntity1.setSaleMethod(lGoodsEntity.getSaleMethod());
            if(lGoodsEntity.getSpecCode() != null)
                lGoodsEntity1.setSpecCode(lGoodsEntity.getSpecCode());

            try{
                session.update(lGoodsEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过in进行查询商品
    * @Param:  int
    * @return:  LGoodsEntity
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @SuppressWarnings("unchecked")
    @Override
    public LGoodsEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LGoodsEntity lGoodsEntity = null;
        lGoodsEntity = (LGoodsEntity)session.get(LGoodsEntity.class, id);
        session.close();
        return lGoodsEntity;
    }

    /**
    * @Description: 通过商品标题进行查询
    * @Param:  String
    * @return:  LGoodsEntity
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public LGoodsEntity listByTile(String title) {
        Session session = sessionFactory.openSession();
        List<LGoodsEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS.TITLE", LGoodsEntity.class)
                    .setParameter("title", title).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    /**
    * @Description: 查询所有商品的数量
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listGoodsCount() {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("GOODS.GOODS_COUNT").list();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    /**
    * @Description: 返回两个时间戳之间的商品数量
    * @Param:  int int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listBtwTimeGoodsCount(int beginMills, int endMills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("GOODS.BTW_TIME_GOODS_COUNT")
                    .setParameter("beginTime", beginMills)
                    .setParameter("endTime", endMills).list();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    /**
    * @Description: 返回时间戳以后的商品数量
    * @Param:  int
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public long listLastTimeGoodsCount(int mills) {
        Session session = sessionFactory.openSession();
        List list = null;
        try{
            list = session.createNamedQuery("GOODS.LAST_TIME_GOODS_COUNT")
                    .setParameter("mills", mills).list();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return (long)list.get(0);
    }

    /**
    * @Description: 查询该时间戳内，前N个销量排名商品
    * @Param:  int int
    * @return:  List<LGoodsEntity>
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public List<LGoodsEntity> listTopNByTime(int mills, int n) {
        Session session = sessionFactory.openSession();
        List<LGoodsEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS.ORDER_BY_MILLS", LGoodsEntity.class)
                    .setParameter("mills", mills).setFirstResult(0).setMaxResults(n)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsDao查询语句出现问题");
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
