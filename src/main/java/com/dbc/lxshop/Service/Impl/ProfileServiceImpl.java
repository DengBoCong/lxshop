package com.dbc.lxshop.Service.Impl;

import com.dbc.lxshop.Dao.GoodsDao;
import com.dbc.lxshop.Dao.OrderDao;
import com.dbc.lxshop.Dao.UserDao;
import com.dbc.lxshop.Model.Bean.ProfileDataBean;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Service.ProfileService;
import com.dbc.lxshop.Utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-18 22:43
 **/
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
    @Qualifier("orderDao")
    @Autowired
    private OrderDao orderDao;

    @Qualifier("goodsDao")
    @Autowired
    private GoodsDao goodsDao;

    @Qualifier("userDao")
    @Autowired
    private UserDao userDao;

    /**
    * @Description: 输出profile顶部八个数据的Bean
    * @Param:
    * @return:  ProfileDataBean
    * @Author: DBC
    * @Date: 2019/8/18
    */
    @Override
    public ProfileDataBean profileDataBean() {
        ProfileDataBean profileDataBean = new ProfileDataBean();
        long lastTimeOrderCount = orderDao.listLastTimeOrderCount(DateUtil.LastWeekTime());
        BigDecimal lastTimeSellCount = orderDao.listLastTimeSellCount(DateUtil.LastWeekTime());
        long lastTwoOrderCount = orderDao.listBtwTimeOrderCount(DateUtil.LastTwoWeekTime(), DateUtil.LastWeekTime());
        BigDecimal lastTwoSellCount = orderDao.listBtwTimeSellCount(DateUtil.LastTwoWeekTime(), DateUtil.LastWeekTime());
        long lastTimeGoodsCount = goodsDao.listLastTimeGoodsCount(DateUtil.LastWeekTime());
        long lastTwoTimeGoodsCount = goodsDao.listBtwTimeGoodsCount(DateUtil.LastTwoWeekTime(), DateUtil.LastWeekTime());
        long lastTimeUserCount = userDao.listLastTimeUserCount(DateUtil.LastWeekTime());
        long lastTwoTimeUserCount = userDao.listBtwTimeUserCount(DateUtil.LastTwoWeekTime(), DateUtil.LastWeekTime());

        long allOrderCount = orderDao.listOrderCount();
        BigDecimal allSellCount = orderDao.listSellCount();
        long allGoodsCount = goodsDao.listGoodsCount();
        long allUserCount = userDao.listUserCount();

        profileDataBean.setAllGoodsCount(allGoodsCount);
        profileDataBean.setAllOrderCount(allOrderCount);
        profileDataBean.setAllSellCount(allSellCount.doubleValue());
        profileDataBean.setAllUserCount(allUserCount);
        profileDataBean.setWeekGoodsCount(lastTimeGoodsCount);
        profileDataBean.setWeekOrderCount(lastTimeOrderCount);
        profileDataBean.setWeekSellCount(lastTimeSellCount.doubleValue());
        profileDataBean.setWeekUserCount(lastTimeUserCount);
        if(lastTwoSellCount == null) lastTwoSellCount = BigDecimal.valueOf(0.00);
        if(lastTimeSellCount == null) lastTimeSellCount = BigDecimal.valueOf(0.00);
        profileDataBean.setSellPrecent(lastTimeSellCount.subtract(lastTwoSellCount).doubleValue());
        profileDataBean.setUserPrecent(lastTimeUserCount - lastTwoTimeUserCount);
        profileDataBean.setGoodPrecent(lastTimeGoodsCount - lastTwoTimeGoodsCount);
        profileDataBean.setOrderPrecent(lastTimeOrderCount - lastTwoOrderCount);
        return profileDataBean;
    }

    /**
    * @Description: 计算该时间内销售量最好的前十五个商品
    * @Param:
    * @return:  List<LGoodsEntity>
    * @Author: DBC
    * @Date: 2019/8/19
    */
    @Override
    public List<LGoodsEntity> listTop15ByTime(int time) {
        return goodsDao.listTopNByTime(time, 15);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }
}
