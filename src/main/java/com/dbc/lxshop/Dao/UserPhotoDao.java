package com.dbc.lxshop.Dao;

import com.dbc.lxshop.Model.Entity.LUserPhotoEntity;

import java.util.List;

public interface UserPhotoDao {
    public boolean addUserPhoto(LUserPhotoEntity lUserPhotoEntity);
    public boolean deleteUserPhoto(int userPhotoId);
    public boolean updateUserPhoto(int userPhotoId, String sort);
    public List<LUserPhotoEntity> listByTypeUser(int type, int userId);
    public LUserPhotoEntity listByTypeImageUser(String type, String images, int userId);
}
