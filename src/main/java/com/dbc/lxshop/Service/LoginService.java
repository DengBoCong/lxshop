package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LAdminEntity;
import java.util.Map;

public interface LoginService {
    public Map<String, Object> checkLogin(String mobile, String pwd);
}
