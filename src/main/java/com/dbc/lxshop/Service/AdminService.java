package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LAdminEntity;
import java.util.Map;

public interface AdminService {
    public Map<String, Object> checkLogin(String mobile, String pwd);
}
