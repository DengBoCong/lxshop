package com.dbc.lxshop.Model.Bean;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-23 00:18
 **/
public class ResultBean {
    private boolean success;
    private String info;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
