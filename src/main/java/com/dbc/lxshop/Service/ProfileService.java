package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Bean.ProfileDataBean;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;

import java.util.List;

public interface ProfileService {
    public ProfileDataBean profileDataBean();
    public List<LGoodsEntity> listTop15ByTime(int time);
}
