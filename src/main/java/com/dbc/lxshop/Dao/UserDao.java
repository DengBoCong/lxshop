package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Model.Entity.LUserEntity;

import java.util.List;

public interface UserDao {
    public boolean addUser(LUserEntity lUserEntity);
    public boolean deleteUser(int id);
    public boolean updateUser(LUserEntity lUserEntity);
    public LUserEntity listById(int id);
    public List<LUserEntity> list();
    public LUserEntity listByMobile(String mobile);
    public long listLastTimeUserCount(int mills);
    public long listBtwTimeUserCount(int beginMills, int endMills);
    public long listUserCount();
}
