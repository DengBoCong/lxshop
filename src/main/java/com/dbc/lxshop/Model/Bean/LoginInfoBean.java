package com.dbc.lxshop.Model.Bean;

import java.util.Date;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-26 10:20
 **/
public class LoginInfoBean {
    private int userId;
    private String userName;
    private int type;
    private String role;
    private Date loginTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
