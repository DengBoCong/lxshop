package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.FactoryUserDao;
import com.dbc.lxshop.Dao.OrderDao;
import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;
import com.dbc.lxshop.Model.Entity.LOrderEntity;
import com.dbc.lxshop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-28 10:19
 **/
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Qualifier("orderDao")
    @Autowired
    private OrderDao orderDao;

    @Qualifier("factoryUserDao")
    @Autowired
    private FactoryUserDao factoryUserDao;

    @Override
    public List<LOrderEntity> listOrder() {
        return orderDao.list();
    }

    /**
    * @Description: 通过订单状态查询
    * @Param:  int
    * @return:  List<LOrderEntity>
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public List<LOrderEntity> listOrderByStatus(int status) {
        return orderDao.listByStatus(status);
    }

    /**
    * @Description: 更新订单信息 ，不进行其他实体迭代
    * @Param:  LOrderEntity
    * @return:  String
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public String updateOrderNon(LOrderEntity lOrderEntity) {
        if(orderDao.updateOrder(lOrderEntity)) return "1";
        else return "0";
    }

    /**
    * @Description: 更新订单信息，并进行其他信息迭代
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/28
    */
    @Override
    public String updateOrder(LOrderEntity lOrderEntity) {
        if(orderDao.updateOrder(lOrderEntity)){
            if(lOrderEntity.getFactoryId() != 0){
                LFactoryUserEntity lFactoryUserEntity = factoryUserDao.listById(lOrderEntity.getFactoryId());
                LFactoryUserEntity lFactoryUserEntity1 = new LFactoryUserEntity();
                lFactoryUserEntity1.setId(lOrderEntity.getFactoryId());
                lFactoryUserEntity1.setOrderCount(lFactoryUserEntity.getOrderCount()+1);
                lFactoryUserEntity1.setSellCount(lFactoryUserEntity.getSellCount().add(lOrderEntity.getTotalPrice()));
                factoryUserDao.updateFactoryUser(lFactoryUserEntity1);
            }
            return "1";
        }else return "0";
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public FactoryUserDao getFactoryUserDao() {
        return factoryUserDao;
    }

    public void setFactoryUserDao(FactoryUserDao factoryUserDao) {
        this.factoryUserDao = factoryUserDao;
    }
}
