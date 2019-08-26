package com.dbc.lxshop.Dao.Impl;

import com.dbc.lxshop.Dao.UserPhotoDao;
import com.dbc.lxshop.Model.Entity.LUserPhotoEntity;
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
 * @create: 2019-08-26 20:32
 **/
@Repository("userPhotoDao")
public class UserPhotoDaoImpl implements UserPhotoDao {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    /**
    * @Description: 添加实景图片实体类
    * @Param:  LUserPhotoEntity
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public boolean addUserPhoto(LUserPhotoEntity lUserPhotoEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(lUserPhotoEntity);
        transaction.commit();
        session.close();
        return true;
    }

    /**
    * @Description: 通过id删除实景图片实体类
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @SuppressWarnings("unchecked")
    @Override
    public boolean deleteUserPhoto(int userPhotoId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserPhotoEntity lUserPhotoEntity = null;
        lUserPhotoEntity = (LUserPhotoEntity)session.get(LUserPhotoEntity.class, userPhotoId);
        if(lUserPhotoEntity == null) return false;
        else{
            try{
                session.delete(lUserPhotoEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserPhotoDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    /**
    * @Description: 通过类别和所属用户查询
    * @Param:  int
    * @return:  List<LUserPhotoEntity>
    * @Author: DBC
    * @Date: 2019/8/26
    */
    @Override
    public List<LUserPhotoEntity> listByTypeUser(int type, int userId) {
        Session session = sessionFactory.openSession();
        List<LUserPhotoEntity> list = null;
        try {
            list = session.createNamedQuery("USERPHOTO.TYPE_USER_ID", LUserPhotoEntity.class)
                    .setParameter("type", (byte)type).setParameter("userId", userId).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserPhotoDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        return list;
    }

    @Override
    public LUserPhotoEntity listByTypeImageUser(String type, String images, int userId) {
        Session session = sessionFactory.openSession();
        List<LUserPhotoEntity> list = null;
        try {
            list = session.createNamedQuery("USERPHOTO.TYPE_USER_ID_IMAGES", LUserPhotoEntity.class)
                    .setParameter("type", (byte)Integer.parseInt(type)).setParameter("userId", userId)
                    .setParameter("images", images).getResultList();
        }catch (IllegalArgumentException e){
            System.out.println("UserPhotoDao查询语句出现问题");
            e.printStackTrace();
        }
        session.close();
        if(list.isEmpty()) return null;
        else return list.get(0);
    }

    /**
    * @Description: 通过id和排序更新
    * @Param:  int
    * @return:  boolean
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @Override
    public boolean updateUserPhoto(int userPhotoId, String sort) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LUserPhotoEntity lUserPhotoEntity = null;
        lUserPhotoEntity = (LUserPhotoEntity)session.get(LUserPhotoEntity.class, userPhotoId);
        if(lUserPhotoEntity == null) return false;
        else{
            lUserPhotoEntity.setSort((byte)Integer.parseInt(sort));
            try{
                session.update(lUserPhotoEntity);
                transaction.commit();
            }catch (Exception e){
                System.out.println("UserPhotoDao中Session操作出错！");
                e.printStackTrace();
            }
            session.close();
            return true;
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
