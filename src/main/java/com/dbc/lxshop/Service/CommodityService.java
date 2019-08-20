package com.dbc.lxshop.Service;

import com.dbc.lxshop.Model.Entity.LGoodsEntity;

import java.util.List;

public interface CommodityService {
    public List<LGoodsEntity> listCommodity();
    public String deleteCommodity(int id);
    public String addCommodity(String title, String afterSale, String kindName, String model, String material,
                               String struct, String style, String use, String saleMethod, String unit, String shelves,
                               String home);
    public LGoodsEntity listOCommodity(String tile);
}
