package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.GoodsPhotoDao;
import com.dbc.lxshop.Model.Entity.LGoodsPhotoEntity;
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
 * @create: 2019-08-23 15:12
 **/
@Repository("goodsPhotoDao")
public class GoodsPhotoDaoImpl implements GoodsPhotoDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 对商品图片进行添加
    * @Param:  LGoodsPhotoEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public boolean addGoodsPhoto(LGoodsPhotoEntity lGoodsPhotoEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lGoodsPhotoEntity);
        transaction.commit();
        session.close();
        return true;
    }

    /**
    * @Description: 删除商品图片
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteGoodsPhoto(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsPhotoEntity lGoodsPhotoEntity = null;
        lGoodsPhotoEntity = (LGoodsPhotoEntity)session.get(LGoodsPhotoEntity.class, id);
        if(lGoodsPhotoEntity == null) return false;
        else{
            try{
                session.delete(lGoodsPhotoEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsPhotoDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 更新商品图片
    * @Param:  LGoodsPhotoEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean updateGoodsPhoto(LGoodsPhotoEntity lGoodsPhotoEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LGoodsPhotoEntity lGoodsPhotoEntity1 = null;
        lGoodsPhotoEntity1 = (LGoodsPhotoEntity)session.get(LGoodsPhotoEntity.class, lGoodsPhotoEntity.getId());
        if(lGoodsPhotoEntity1 == null) return false;
        else{
            if(lGoodsPhotoEntity.getSort() != 0)
                lGoodsPhotoEntity1.setSort(lGoodsPhotoEntity.getSort());

            try{
                session.update(lGoodsPhotoEntity1);
                transaction.commit();
            }catch (Exception e){
                System.out.println("GoodsPhotoDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过商品id查询商品图片
    * @Param:  int
    * @return:  List<LGoodsPhotoEntity>
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public List<LGoodsPhotoEntity> listByGoodsId(int goodsId) {
        Session session = sessionFactory.openSession();
        List<LGoodsPhotoEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_PHOTO.GOODS_ID", LGoodsPhotoEntity.class)
                    .setParameter("goodsId", goodsId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsPhotoDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过id查询商品图片
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @SuppressWarnings("unchecked")
    @Override
    public LGoodsPhotoEntity listById(int id) {
        Session session = sessionFactory.openSession();
        LGoodsPhotoEntity lGoodsPhotoEntity = null;
        lGoodsPhotoEntity = (LGoodsPhotoEntity)session.get(LGoodsPhotoEntity.class, id);
        session.close();
        return lGoodsPhotoEntity;
    }

    /**
    * @Description: 查询所有商品图片
    * @Param:
    * @return:  List<LGoodsPhotoEntity>
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public List<LGoodsPhotoEntity> list() {
        Session session = sessionFactory.openSession();
        List<LGoodsPhotoEntity> list = null;
        try {
            list = session.createNamedQuery("GOODS_PHOTO", LGoodsPhotoEntity.class)
                    .list();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsPhotoDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    /**
    * @Description: 通过商品id和图片地址查询
    * @Param:  int
    * @Param:  int
    * @return:  LGoodsPhotoEntity
    * @Author: DBC
    * @Date: 2019/8/23
    */
    @Override
    public LGoodsPhotoEntity listByGoodsIdImage(int goodsId, String image) {
        Session session = sessionFactory.openSession();
        List<LGoodsPhotoEntity> list = null;
        try{
            list = session.createNamedQuery("GOODS_PHOTO.GOODS_ID_IMAGE", LGoodsPhotoEntity.class)
                    .setParameter("goodsId", goodsId).setParameter("image", image)
                    .getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("GoodsPhotoDao查询语句出现问题");
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
