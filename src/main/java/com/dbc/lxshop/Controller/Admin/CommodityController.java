package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Bean.GoodsCategoryBean;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryEntity;
import com.dbc.lxshop.Model.Entity.LGoodsCategoryJoinEntity;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Service.CommodityDetailsService;
import com.dbc.lxshop.Service.CommodityService;
import com.dbc.lxshop.Utils.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-19 18:11
 **/
@Controller
@RequestMapping("/Admin/Commodity")
public class CommodityController {
    @Qualifier("commodityService")
    @Autowired
    private CommodityService commodityService;

    @Qualifier("commodityDetailsService")
    @Autowired
    private CommodityDetailsService commodityDetailsService;


    @RequestMapping(method = RequestMethod.GET, value = "/Record")
    public String record(ModelMap modelMap){
        return "admin/commodity/record";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Classify")
    public String classify(ModelMap modelMap){
        modelMap.addAttribute("CommodityClassFirst", commodityService.listByFirst());
        modelMap.addAttribute("CommodityClassSecond", commodityService.listBySecond());
        return "admin/commodity/classify";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddCommodity")
    @ResponseBody
    public Map<String, Object> addCommodity(String title, String afterSale, String kindName, String model, String material,
                                            String struct, String style, String use, String saleMethod, String unit, String shelves,
                                            String home, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.addCommodity(title, afterSale, kindName, model, material,
                struct, style, use, saleMethod, unit, shelves, home));
        /*LGoodsEntity lGoodsEntity = commodityService.listOCommodity(title);
        if(lGoodsEntity == null) map.put("id", "0");
        else {
            map.put("id", lGoodsEntity.getId());
            if(lGoodsEntity.getIsShelves() == 0) map.put("shelves", "已下架<i class=\"fa fa-check text-navy\"></i>");
            else map.put("shelves", "上架中<i class=\"fa fa-times text-navy\"></i>");
        }*/
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateCommodityInfo")
    @ResponseBody
    public Map<String, Object> updateCommodityInfo(String goodId, String title, String afterSale, String kindName, String model, String material,
                                                   String struct, String style, String use, String saleMethod, String unit, String shelves,
                                                   String home, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.updateCommodityInfo(Integer.parseInt(goodId), title, afterSale, kindName, model, material,
                struct, style, use, saleMethod, unit, shelves, home));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/CommodityList")
    @ResponseBody
    public Map<String, Object> commodityList(HttpServletResponse httpServletResponse,
                                             HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LGoodsEntity> list = commodityService.listCommodity();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodity")
    @ResponseBody
    public Map<String, Object> deleteCommodity(String id, HttpServletRequest httpServletRequest,
                                               HttpServletResponse httpServletResponse){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.deleteCommodity(Integer.parseInt(id)));
        return map;
    }

    /**
    * @Description: 删除商品分类
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/24
    */
    @RequestMapping(method = RequestMethod.POST, value = "/DeleteClassify")
    @ResponseBody
    public Map<String, Object> deleteClassify(String id, HttpServletRequest httpServletRequest,
                                              HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.deleteCommodityClassify(id));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddClassify")
    @ResponseBody
    public Map<String, Object> addClassify(String name, String pid, String isHome, String sort,
                                           HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                           ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.addCommodityClassify(pid, name, sort, isHome));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateClassify")
    @ResponseBody
    public Map<String, Object> updateClassify(String id, String name, String sort, String isHome, HttpServletRequest httpServletRequest,
                                              HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.updateCommodityClassify(id, name, sort, isHome));
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/GoodDetails/{goodId}")
    public String goodDetails(@PathVariable int goodId, ModelMap modelMap){
        modelMap.addAttribute("CommodityStandradList", commodityDetailsService.listCommodityStandrad(goodId));
        modelMap.addAttribute("GOOD_ID", goodId);
        modelMap.addAttribute("CommodityInfo", commodityService.listCommodityById(goodId));
        modelMap.addAttribute("CommodityPhotoList", commodityDetailsService.listCommodityGoodsPhotoByGoodsId(goodId));
        modelMap.addAttribute("CommodityCategoryList", commodityDetailsService.listCommodityCategoryJoinByGoodsId(goodId));
        modelMap.addAttribute("CommodityCategoryFirstList", commodityService.listByFirst());
        return "admin/commodity/goodDetails";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddGoodsStandrad")
    @ResponseBody
    public Map<String, Object> addGoodsStandrad(String goodId, String measure, String color, String inventory, String factoryPrice,
                                                String originPrice, String guidePrice, HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(goodId);
        map.put("flag", commodityDetailsService.addCommodityStandrad(goodId, measure, color, inventory, factoryPrice, originPrice, guidePrice));
        map.put("measureId", commodityDetailsService.listCommodityGoodsIdMeasureColor(goodId, measure, color).getId());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteGoodsStandrad")
    @ResponseBody
    public Map<String, Object> deleteGoodsStandrad(String id, HttpServletRequest httpServletRequest,
                                                   HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.deleteCommodityStandrad(id));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateGoodsStandrad")
    @ResponseBody
    public Map<String, Object> updateGoodsStandrad(String id, String measure, String color, String inventory, String factoryPrice,
                                                   String originPrice, String guidePrice, HttpServletRequest httpServletRequest,
                                                   HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.updateCommodityStandrad(id, measure, color, inventory, factoryPrice, originPrice, guidePrice));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadCR")
    @ResponseBody
    public Map<String, Object> uploadCR(String tag, String goodId, @RequestParam(value = "imgFile",required=false)MultipartFile imgFile, String imgData,
                                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();

        String dir = ConfigInfo.goods_images_upload_path + goodId + "/";
        String path = httpServletRequest.getSession().getServletContext().getRealPath(dir);

        String name = imgFile.getOriginalFilename();
        //判断文件的MIMEtype
        String type = imgFile.getContentType();
        if(type==null || !type.toLowerCase().startsWith("image/")) map.put("flag", "不支持的文件类型，仅支持图片！");
        System.out.println("file type:"+type);
        String fileName = new Date().getTime()+""+new Random().nextInt(10000)+""+name.substring(name.lastIndexOf('.'));
        System.out.println("文件路径："+path+"_"+fileName);

        JSONObject joData = JSONObject.fromObject(imgData);
        // 用户经过剪辑后的图片的大小
        double x = (double)joData.get("x");
        double y = (double)joData.get("y");
        double w =  (double)joData.get("width");
        double h =  (double)joData.get("height");

        //开始上传
        File targetFile = new File(path, fileName);
        //保存
        try {
            if(!targetFile.exists()){
                targetFile.mkdirs();
                InputStream is = imgFile.getInputStream();
                ImageCutUtil.cut(is, targetFile, (int)x,(int)y,(int)w,(int)h);
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "上传失败，出现异常："+e.getMessage());
        }
        LGoodsEntity lGoodsEntity = new LGoodsEntity();
        lGoodsEntity.setId(Integer.parseInt(goodId));
        lGoodsEntity.setUpdTime(DateUtil.NewDateInt());
        if(tag.equals("1")) {
            lGoodsEntity.setImages(ConfigInfo.url_path+"upload/admin/images/goods/" + goodId + "/" + fileName);
            map.put("tag", commodityService.updateCommodity(lGoodsEntity));
        }
        else if(tag.equals("2")) {
            lGoodsEntity.setHomeRecommendedImages(ConfigInfo.url_path+"upload/admin/images/goods/" + goodId + "/" + fileName);
            map.put("tag", commodityService.updateCommodity(lGoodsEntity));
        }
        else{
            System.out.println("******************************");
        }
        map.put("flag", "1");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddCommodityPhoto")
    @ResponseBody
    public Map<String, Object> addCommodityPhoto(String goodsId, @RequestParam(value = "imgFile",required=false)MultipartFile imgFile,
                                                 String sort, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                                 ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        String dir = ConfigInfo.goods_images_upload_path + goodsId + "/photo/";
        String path = httpServletRequest.getSession().getServletContext().getRealPath(dir);

        String name = imgFile.getOriginalFilename();
        //判断文件的MIMEtype
        String type = imgFile.getContentType();
        if(type==null || !type.toLowerCase().startsWith("image/")) map.put("flag", "不支持的文件类型，仅支持图片！");
        System.out.println("file type:"+type);
        String fileName = new Date().getTime()+""+new Random().nextInt(10000)+""+name.substring(name.lastIndexOf('.'));
        System.out.println("文件路径："+path+"_"+fileName);

        //开始上传
        File targetFile = new File(path, fileName);
        //保存
        try {
            if(!targetFile.exists()){
                targetFile.mkdirs();
                imgFile.transferTo(targetFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "上传失败，出现异常："+e.getMessage());
        }

        map.put("flag", commodityDetailsService.addCommodityPhoto(goodsId, ConfigInfo.url_path+"upload/admin/images/goods/" + goodsId + "/photo/" + fileName, sort));
        map.put("tag", commodityDetailsService.listCommodityPhotoId(goodsId, ConfigInfo.url_path+"upload/admin/images/goods/" + goodsId + "/photo/" + fileName));
        map.put("image", ConfigInfo.url_path+"upload/admin/images/goods/" + goodsId + "/photo/" + fileName);
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodityPhoto")
    @ResponseBody
    public Map<String, Object> deleteCommodityPhoto(String photoId, HttpServletRequest httpServletRequest,
                                                    HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.deleteCommodityPhoto(photoId));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateCommodityPhoto")
    @ResponseBody
    public Map<String, Object> updateCommodityPhoto(String photoId, String sort, HttpServletRequest httpServletRequest,
                                                    HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.updateCommodityPhoto(photoId, sort));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ListCommodityCategorySecond")
    @ResponseBody
    public Map<String, Object> listCommodityCategorySecond(String pid, HttpServletResponse httpServletResponse,
                                                           HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LGoodsCategoryEntity> list = commodityDetailsService.listCommodityCategoryByPid(Integer.parseInt(pid));
        map.put("count", list.size());
        map.put("value", list);
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddCommodityCategoryJoin")
    @ResponseBody
    public Map<String, Object> addCommodityCategoryJoin(String goodsId, String categoryId, HttpServletRequest httpServletRequest,
                                                        HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.addCommodityCategoryJoin(Integer.parseInt(goodsId), Integer.parseInt(categoryId)));
        /*GoodsCategoryBean goodsCategoryBean = commodityDetailsService.listOCommodityCategoryByGoodId(Integer.parseInt(goodsId), Integer.parseInt(categoryId));*/
        LGoodsCategoryJoinEntity lGoodsCategoryJoinEntity = commodityDetailsService.listCommodityCategoryByGoodIdCategoryId(Integer.parseInt(goodsId), Integer.parseInt(categoryId));
        map.put("tag", lGoodsCategoryJoinEntity.getId());
        map.put("tagName", lGoodsCategoryJoinEntity.getCategoryId());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteCommodityCategoryJoin")
    @ResponseBody
    public Map<String, Object>  deleteCommodityCategoryJoin(String id, HttpServletResponse httpServletResponse,
                                                            HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityDetailsService.deleteCommodityCategoryById(Integer.parseInt(id)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateCommodityContent")
    @ResponseBody
    public Map<String, Object> updateCommodityContent(String goodId, String content, HttpServletRequest httpServletRequest,
                                                      HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LGoodsEntity lGoodsEntity = new LGoodsEntity();
        lGoodsEntity.setContentWeb(content);
        lGoodsEntity.setId(Integer.parseInt(goodId));
        map.put("flag", commodityService.updateCommodity(lGoodsEntity));
        return map;
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/ListOneCommodity")
    @ResponseBody
    public Map<String, Object> listOneCommodity(String goodId, HttpServletResponse httpServletResponse,
                                                HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", commodityService.listCommodityById(Integer.parseInt(goodId)));
        return map;
    }*/

    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    public CommodityService getCommodityService() {
        return commodityService;
    }

    public void setCommodityDetailsService(CommodityDetailsService commodityDetailsService) {
        this.commodityDetailsService = commodityDetailsService;
    }

    public CommodityDetailsService getCommodityDetailsService() {
        return commodityDetailsService;
    }
}
