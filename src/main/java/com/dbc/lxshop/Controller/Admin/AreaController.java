package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Entity.LAreaEntity;
import com.dbc.lxshop.Model.Entity.LGoodsEntity;
import com.dbc.lxshop.Model.Entity.LSalesmanUserEntity;
import com.dbc.lxshop.Service.AreaService;
import com.dbc.lxshop.Service.SalesmanService;
import com.dbc.lxshop.Utils.ConfigInfo;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.ImageCutUtil;
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
 * @create: 2019-08-24 23:09
 **/
@Controller
@RequestMapping("/Admin/Area")
public class AreaController {
    @Qualifier("areaService")
    @Autowired
    private AreaService areaService;

    @Qualifier("salesmanService")
    @Autowired
    private SalesmanService salesmanService;

    @RequestMapping(method = RequestMethod.GET, value = "/Divide")
    public String divide(ModelMap modelMap){
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        return "admin/area/divide";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Principal")
    public String principal(ModelMap modelMap){
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SalesmanTopList", areaService.listSalesmanUserTop());
        return "admin/area/principal";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Salesman")
    public String salesman(ModelMap modelMap){
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        return "admin/area/salesman";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddAreaInfo")
    @ResponseBody
    public Map<String, Object> addAreaInfo(String areaName, String areaDescription, String areaSalesman, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.addArea(areaName, areaDescription, areaSalesman));
        map.put("manInfo", areaService.listOneAreaByName(areaName));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteArea")
    @ResponseBody
    public Map<String, Object> deleteArea(String areaId, HttpServletResponse httpServletResponse,
                                          HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.deleteArea(Integer.parseInt(areaId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateArea")
    @ResponseBody
    public Map<String, Object> updateArea(String areaId, String areaName, String areaDescription, String areaSalesman,
                                          HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", areaService.updateArea(areaId, areaName, areaDescription, areaSalesman));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ListCity")
    @ResponseBody
    public Map<String, Object> listCity(String pid, HttpServletResponse httpServletResponse,
                                        HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", salesmanService.listCityByPid(Integer.parseInt(pid)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/SalesmanUserList")
    @ResponseBody
    public Map<String, Object> salesmanUserList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                                ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LSalesmanUserEntity> list = areaService.listSalesmanUser();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ListSalesmanByAreaId")
    @ResponseBody
    public Map<String, Object> listSalesmanByAreaId(String areaId, HttpServletResponse httpServletResponse,
                                                    HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", salesmanService.listSalesmanUserByAreaId(Integer.parseInt(areaId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/ListSalesmanByAreaIdKind")
    @ResponseBody
    public Map<String, Object> listSalesmanByAreaIdKind(String kind, String areaId, HttpServletResponse httpServletResponse,
                                                    HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", salesmanService.listSalesmanUserByAreaIdKind(Integer.parseInt(kind), Integer.parseInt(areaId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteSalesman")
    @ResponseBody
    public Map<String, Object> deleteSalesman(String salesmanId, HttpServletResponse httpServletResponse,
                                              HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", salesmanService.deleteSalesman(Integer.parseInt(salesmanId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddSalesman")
    @ResponseBody
    public Map<String, Object> addSalesman(String name, String email, String mobile, String idCard, String province, String city, String areaId,
                                           String pid, String kind, String status, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        if(pid.equals("0") && !kind.equals("3")) {
            map.put("flag", "0");
            map.put("error", "业务员上级和其身份不符");
        }else{
            map.put("flag", salesmanService.addSalesman(name, email, mobile, idCard, province, city, areaId, pid, kind, status));
            map.put("error", "账号已存在(即手机号已存在)");
        }
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/SalesmanDetails/{salesmanId}")
    public String salesmanDetails(@PathVariable int salesmanId, ModelMap modelMap){
        modelMap.addAttribute("SalesmanInfo", areaService.listOneSalesmanUser(salesmanId));
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SALESMAN_ID", salesmanId);
        return "admin/area/salesmanDetails";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadSalesmanIdCard")
    @ResponseBody
    public Map<String, Object> uploadCR(String tag, String salesmanId, @RequestParam(value = "imgFile",required=false)MultipartFile imgFile, String imgData,
                                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();

        String dir = ConfigInfo.salesman_images_upload_path + salesmanId + "/";
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
        LSalesmanUserEntity lSalesmanUserEntity = new LSalesmanUserEntity();
        lSalesmanUserEntity.setId(Integer.parseInt(salesmanId));
        lSalesmanUserEntity.setUpdTime(DateUtil.NewDateInt());
        if(tag.equals("1")) {
            lSalesmanUserEntity.setIdcardFphoto(ConfigInfo.url_path+"upload/admin/images/salesman/" + salesmanId + "/" + fileName);
            map.put("tag", salesmanService.updateSalesman(lSalesmanUserEntity));
        }
        else if(tag.equals("2")) {
            lSalesmanUserEntity.setIdcardBphoto(ConfigInfo.url_path+"upload/admin/images/salesman/" + salesmanId + "/" + fileName);
            map.put("tag", salesmanService.updateSalesman(lSalesmanUserEntity));
        }
        else{
            lSalesmanUserEntity.setImage(ConfigInfo.url_path+"upload/admin/images/salesman/" + salesmanId + "/" + fileName);
            map.put("tag", salesmanService.updateSalesman(lSalesmanUserEntity));
        }
        map.put("flag", "1");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateSalesman")
    @ResponseBody
    public Map<String, Object> updateSalesman(String salesmanId, String name, String mobile, String idCard, String province, String city, String areaId,
                                           String pid, String kind, String status, HttpServletRequest httpServletRequest,
                                           HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        if(pid.equals("0") && !kind.equals("3")) {
            map.put("flag", "0");
            map.put("error", "业务员上级和其身份不符");
        }else{
            if(!pid.equals("0")){
                LAreaEntity lAreaEntity = areaService.listAreaByPrincipalId(Integer.parseInt(salesmanId));
                if(lAreaEntity != null){
                    LAreaEntity lAreaEntity1 = new LAreaEntity();
                    lAreaEntity1.setId(lAreaEntity.getId());
                    lAreaEntity1.setPrincipalId(0);
                    areaService.updateArea(lAreaEntity);
                }
            }
            LSalesmanUserEntity lSalesmanUserEntity = new LSalesmanUserEntity();
            lSalesmanUserEntity.setId(Integer.parseInt(salesmanId));
            lSalesmanUserEntity.setuName(name);
            lSalesmanUserEntity.setMobile(mobile);
            lSalesmanUserEntity.setIdCard(idCard);
            lSalesmanUserEntity.setProvince(province);
            lSalesmanUserEntity.setCity(city);
            lSalesmanUserEntity.setAreaId(Integer.parseInt(areaId));
            lSalesmanUserEntity.setPid(Integer.parseInt(pid));
            lSalesmanUserEntity.setKind((byte)Integer.parseInt(kind));
            lSalesmanUserEntity.setStatus((byte)Integer.parseInt(status));
            lSalesmanUserEntity.setUpdTime(DateUtil.NewDateInt());
            map.put("flag", salesmanService.updateSalesman(lSalesmanUserEntity));
            map.put("error", "账号已存在(即手机号已存在)");
        }
        return map;
    }

    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    public AreaService getAreaService() {
        return areaService;
    }

    public void setSalesmanService(SalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

    public SalesmanService getSalesmanService() {
        return salesmanService;
    }
}
