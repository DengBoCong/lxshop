package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Model.Entity.LFactoryLicenceEntity;
import com.dbc.lxshop.Model.Entity.LFactoryUserEntity;
import com.dbc.lxshop.Model.Entity.LUserEntity;
import com.dbc.lxshop.Model.Entity.LUserLicenceEntity;
import com.dbc.lxshop.Service.AgencyUserService;
import com.dbc.lxshop.Service.AreaService;
import com.dbc.lxshop.Service.FactoryUserService;
import com.dbc.lxshop.Service.SalesmanService;
import com.dbc.lxshop.Utils.ConfigInfo;
import com.dbc.lxshop.Utils.DateUtil;
import com.dbc.lxshop.Utils.ImageCutUtil;
import com.dbc.lxshop.Utils.InitEntityUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
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
 * @create: 2019-08-26 11:10
 **/
@Controller
@RequestMapping("/Admin/NonStaff")
public class NonStaffController {
    @Qualifier("areaService")
    @Autowired
    private AreaService areaService;

    @Qualifier("salesmanService")
    @Autowired
    private SalesmanService salesmanService;

    @Qualifier("agencyUserService")
    @Autowired
    private AgencyUserService agencyUserService;

    @Qualifier("factoryUserService")
    @Autowired
    private FactoryUserService factoryUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/AgencyRecord")
    public String agencyRecord(ModelMap modelMap){
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        return "admin/nonStaff/agencyRecord";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/FactoryRecord")
    public String factoryRecord(ModelMap modelMap){
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        return "admin/nonStaff/factoryRecord";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddAgencyUser")
    @ResponseBody
    public Map<String, Object> addAgencyUser(String name, String mobile, String email, String address,
                                             String integral, String province, String city, String areaId, String pid, String status,
                                             HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LUserEntity lUserEntity = InitEntityUtil.InitLUserEntity();
        lUserEntity.setName(name);
        lUserEntity.setMobile(mobile);
        if (!email.equals("")) lUserEntity.setEmail(email);
        if (!address.equals("")) lUserEntity.setAddress(address);
        lUserEntity.setIntegral(Integer.parseInt(integral));
        if(province.equals("")) lUserEntity.setProvince(province);
        if(city.equals("")) lUserEntity.setCity(city);
        lUserEntity.setAreaId(Integer.parseInt(areaId));
        lUserEntity.setSalesmanId(Integer.parseInt(pid));
        lUserEntity.setStatus((byte)Integer.parseInt(status));
        lUserEntity.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        map.put("flag", agencyUserService.addAgencyUser(lUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateAgencyUser")
    @ResponseBody
    public Map<String, Object> updateAgencyUser(String name, String mobile, String email, String address,
                                             String integral, String province, String city, String areaId, String pid, String status,
                                             HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LUserEntity lUserEntity = InitEntityUtil.InitLUserEntity();
        lUserEntity.setName(name);
        lUserEntity.setMobile(mobile);
        if (!email.equals("")) lUserEntity.setEmail(email);
        if (!address.equals("")) lUserEntity.setAddress(address);
        lUserEntity.setIntegral(Integer.parseInt(integral));
        if(province.equals("")) lUserEntity.setProvince(province);
        if(city.equals("")) lUserEntity.setCity(city);
        lUserEntity.setAreaId(Integer.parseInt(areaId));
        lUserEntity.setSalesmanId(Integer.parseInt(pid));
        lUserEntity.setStatus((byte)Integer.parseInt(status));
        lUserEntity.setUpdTime(DateUtil.NewDateInt());
        map.put("flag", agencyUserService.updateAgencyUser(lUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateAgencyPwd")
    @ResponseBody
    public Map<String, Object> updateAgencyPwd(String agencyId, HttpServletRequest httpServletRequest,
                                               HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LUserEntity lUserEntity = new LUserEntity();
        lUserEntity.setId(Integer.parseInt(agencyId));
        lUserEntity.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        map.put("flag", agencyUserService.updateAgencyUserNon(lUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AgencyUserList")
    @ResponseBody
    public Map<String, Object> agencyUserList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                                ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LUserEntity> list = agencyUserService.listAgencyUser();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteAgencyUser")
    @ResponseBody
    public Map<String, Object> deleteAgencyUser(String userId, HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", agencyUserService.deleteAgencyUser(Integer.parseInt(userId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/AgencyUserDetails/{userId}")
    public String agencyUserDetails(@PathVariable int userId, ModelMap modelMap){
        LUserEntity lUserEntity = agencyUserService.listOneAgencyUserById(userId);
        modelMap.addAttribute("AgencyInfo", lUserEntity);
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        LUserLicenceEntity lUserLicenceEntity = agencyUserService.listUserLicenceById(lUserEntity.getLicenceId());
        if (lUserEntity.getLicenceId() == 0) lUserLicenceEntity = new LUserLicenceEntity();
        else modelMap.addAttribute("LicenceInfo", lUserLicenceEntity);
        modelMap.addAttribute("AgencyPhotoList", agencyUserService.listUserPhotoByType(1, userId));
        modelMap.addAttribute("AGENCYUSER_ID", userId);
        return "admin/nonStaff/agencyDetails";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/FactoryUserDetails/{factoryId}")
    public String factoryUserDetails(@PathVariable int factoryId, ModelMap modelMap){
        LFactoryUserEntity lFactoryUserEntity = factoryUserService.listOneFactoryUserById(factoryId);
        modelMap.addAttribute("AgencyInfo", lFactoryUserEntity);
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        LFactoryLicenceEntity lFactoryLicenceEntity = factoryUserService.listFactoryLicenceById(lFactoryUserEntity.getLicenceId());
        if (lFactoryUserEntity.getLicenceId() == 0) lFactoryLicenceEntity = new LFactoryLicenceEntity();
        else modelMap.addAttribute("LicenceInfo", lFactoryLicenceEntity);
        modelMap.addAttribute("AgencyPhotoList", agencyUserService.listUserPhotoByType(2, factoryId));
        modelMap.addAttribute("AGENCYUSER_ID", factoryId);
        /*modelMap.addAttribute("SalesmanInfo", areaService.listOneSalesmanUser(salesmanId));
        modelMap.addAttribute("ProvinceList", salesmanService.listProvince());
        modelMap.addAttribute("SalesmanList", areaService.listSalesmanUser());
        modelMap.addAttribute("AreaList", areaService.listAreaInfo());
        modelMap.addAttribute("SALESMAN_ID", salesmanId);*/
        return "admin/nonStaff/factoryDetails";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/FactoryUserList")
    @ResponseBody
    public Map<String, Object> factoryUserList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                              ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        List<LFactoryUserEntity> list = factoryUserService.listFactoryUser();
        map.put("draw", UUID.randomUUID().toString());
        map.put("data", list);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteFactoryUser")
    @ResponseBody
    public Map<String, Object> deleteFactoryUser(String factoryId, HttpServletRequest httpServletRequest,
                                                HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", factoryUserService.deleteFactoryUser(Integer.parseInt(factoryId)));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/AddFactoryUser")
    @ResponseBody
    public Map<String, Object> addFactoryUser(String name, String mobile, String email, String address, String province,
                                              String city, String areaId, String pid, String status, HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LFactoryUserEntity lFactoryUserEntity = InitEntityUtil.InitLFactoryUserEntity();
        lFactoryUserEntity.setName(name);
        lFactoryUserEntity.setMobile(mobile);
        if(email.equals("")) lFactoryUserEntity.setEmail(email);
        if(address.equals("")) lFactoryUserEntity.setAddress(address);
        if(province.equals("")) lFactoryUserEntity.setProvince(province);
        if(city.equals("")) lFactoryUserEntity.setCity(city);
        lFactoryUserEntity.setAreaId(Integer.parseInt(areaId));
        lFactoryUserEntity.setSalesmanId(Integer.parseInt(pid));
        lFactoryUserEntity.setStatus((byte)Integer.parseInt(status));
        lFactoryUserEntity.setAddTime(DateUtil.NewDateInt());
        lFactoryUserEntity.setUpdTime(DateUtil.NewDateInt());
        lFactoryUserEntity.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        map.put("flag", factoryUserService.addFactoryUser(lFactoryUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadAgencyLicenceInfo")
    @ResponseBody
    public Map<String, Object> uploadAgencyLicenceInfo(String licenceId, String licenceNumber, String licenceName, String legalPerson,
                    String legalPersonTel, String legalPersonIdCard, HttpServletResponse httpServletResponse,
                                                       HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LUserLicenceEntity lUserLicenceEntity = new LUserLicenceEntity();
        lUserLicenceEntity.setLicenceNumber(licenceNumber);
        lUserLicenceEntity.setLicenceName(licenceName);
        lUserLicenceEntity.setLegalPerson(legalPerson);
        lUserLicenceEntity.setLegalPersonTel(legalPersonTel);
        lUserLicenceEntity.setLegalPersonIdcard(legalPersonIdCard);
        if (licenceId.equals("0")){
            map.put("flag", agencyUserService.addUserLicence(lUserLicenceEntity));
        }else{
            lUserLicenceEntity.setId(Integer.parseInt(licenceId));
            map.put("flag", agencyUserService.updateUserLicence(lUserLicenceEntity));
        }
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadAgencyUserImage")
    @ResponseBody
    public Map<String, Object> uploadCR(String tag, String agencyUserId, @RequestParam(value = "imgFile",required=false)MultipartFile imgFile, String imgData,
                                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();

        String dir = ConfigInfo.agency_images_upload_path + agencyUserId + "/";
        String path = httpServletRequest.getSession().getServletContext().getRealPath(dir);

        String name = imgFile.getOriginalFilename();
        //判断文件的MIMEtype
        String type = imgFile.getContentType();
        if(type==null || !type.toLowerCase().startsWith("image/")) map.put("flag", "不支持的文件类型，仅支持图片！");
        System.out.println("file type:"+type);
        String fileName = new Date().getTime()+""+new Random().nextInt(10000)+""+name.substring(name.lastIndexOf('.'));
        System.out.println("文件路径："+path+"_"+fileName);

        if(tag.equals("6")){
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
            map.put("flag", agencyUserService.addAgencyUserPhoto("1", Integer.parseInt(agencyUserId), ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName, "1"));
            map.put("tag", agencyUserService.listAgencyPhotoId(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName, Integer.parseInt(agencyUserId), "1").getId());
            map.put("image", ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            return map;
        }

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
        LUserEntity lUserEntity = new LUserEntity();
        lUserEntity.setId(Integer.parseInt(agencyUserId));
        lUserEntity.setUpdTime(DateUtil.NewDateInt());
        if(tag.equals("1")) {
            lUserEntity.setWechatCode(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            map.put("tag", agencyUserService.updateAgencyUser(lUserEntity));
        }
        else if(tag.equals("2")) {
            lUserEntity.setAvatar(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            map.put("tag", agencyUserService.updateAgencyUser(lUserEntity));
        }
        else if(tag.equals("3")){
            LUserEntity lUserEntity1 = agencyUserService.listOneAgencyUserById(Integer.parseInt(agencyUserId));
            LUserLicenceEntity lUserLicenceEntity = agencyUserService.listUserLicenceById(lUserEntity1.getLicenceId());
            lUserLicenceEntity.setLegalPersonFphoto(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            map.put("tag", agencyUserService.updateUserLicence(lUserLicenceEntity));
        }else if (tag.equals("4")){
            LUserEntity lUserEntity1 = agencyUserService.listOneAgencyUserById(Integer.parseInt(agencyUserId));
            LUserLicenceEntity lUserLicenceEntity = agencyUserService.listUserLicenceById(lUserEntity1.getLicenceId());
            lUserLicenceEntity.setLegalPersonBphoto(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            map.put("tag", agencyUserService.updateUserLicence(lUserLicenceEntity));
        }else if(tag.equals("5")){
            LUserEntity lUserEntity1 = agencyUserService.listOneAgencyUserById(Integer.parseInt(agencyUserId));
            LUserLicenceEntity lUserLicenceEntity = agencyUserService.listUserLicenceById(lUserEntity1.getLicenceId());
            lUserLicenceEntity.setLicencePhoto(ConfigInfo.url_path+"upload/admin/images/agency/" + agencyUserId + "/" + fileName);
            map.put("tag", agencyUserService.updateUserLicence(lUserLicenceEntity));
        }
        map.put("flag", "1");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/DeleteAgencyPhoto")
    @ResponseBody
    public Map<String, Object> deleteAgencyPhoto(String photoId, HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", agencyUserService.deleteAgencyUserPhoto(photoId));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateAgencyPhoto")
    @ResponseBody
    public Map<String, Object> updateAgencyPhoto(String photoId, String sort, HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("flag", agencyUserService.updateAgencyUserPhoto(photoId, sort));
        return map;
    }

    /**
    * @Description: 更新厂商信息
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/27
    */
    @RequestMapping(method = RequestMethod.POST, value = "/UploadFactoryUserImage")
    @ResponseBody
    public Map<String, Object> uploadFactoryUserImage(String tag, String agencyUserId, @RequestParam(value = "imgFile",required=false)MultipartFile imgFile, String imgData,
                                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();

        String dir = ConfigInfo.factory_images_upload_path + agencyUserId + "/";
        String path = httpServletRequest.getSession().getServletContext().getRealPath(dir);

        String name = imgFile.getOriginalFilename();
        //判断文件的MIMEtype
        String type = imgFile.getContentType();
        if(type==null || !type.toLowerCase().startsWith("image/")) map.put("flag", "不支持的文件类型，仅支持图片！");
        System.out.println("file type:"+type);
        String fileName = new Date().getTime()+""+new Random().nextInt(10000)+""+name.substring(name.lastIndexOf('.'));
        System.out.println("文件路径："+path+"_"+fileName);

        if(tag.equals("6")){
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
            map.put("flag", agencyUserService.addAgencyUserPhoto("2", Integer.parseInt(agencyUserId), ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName, "1"));
            map.put("tag", agencyUserService.listAgencyPhotoId(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName, Integer.parseInt(agencyUserId), "2").getId());
            map.put("image", ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            return map;
        }

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
        LFactoryUserEntity lFactoryUserEntity = new LFactoryUserEntity();
        lFactoryUserEntity.setId(Integer.parseInt(agencyUserId));
        lFactoryUserEntity.setUpdTime(DateUtil.NewDateInt());
        if(tag.equals("1")) {
            lFactoryUserEntity.setWechatCode(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            map.put("tag", factoryUserService.updateFactoryUser(lFactoryUserEntity));
        }
        else if(tag.equals("2")) {
            lFactoryUserEntity.setAvatar(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            map.put("tag", factoryUserService.updateFactoryUser(lFactoryUserEntity));
        }
        else if(tag.equals("3")){
            LFactoryUserEntity lFactoryUserEntity1 = factoryUserService.listOneFactoryUserById(Integer.parseInt(agencyUserId));
            LFactoryLicenceEntity lFactoryLicenceEntity = factoryUserService.listFactoryLicenceById(lFactoryUserEntity1.getLicenceId());
            lFactoryLicenceEntity.setLegalPersonFphoto(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            map.put("tag", factoryUserService.updateFactoryLicence(lFactoryLicenceEntity));
        }else if (tag.equals("4")){
            LFactoryUserEntity lFactoryUserEntity1 = factoryUserService.listOneFactoryUserById(Integer.parseInt(agencyUserId));
            LFactoryLicenceEntity lFactoryLicenceEntity = factoryUserService.listFactoryLicenceById(lFactoryUserEntity1.getLicenceId());
            lFactoryLicenceEntity.setLegalPersonBphoto(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            map.put("tag", factoryUserService.updateFactoryLicence(lFactoryLicenceEntity));
        }else if(tag.equals("5")){
            LFactoryUserEntity lFactoryUserEntity1 = factoryUserService.listOneFactoryUserById(Integer.parseInt(agencyUserId));
            LFactoryLicenceEntity lFactoryLicenceEntity = factoryUserService.listFactoryLicenceById(lFactoryUserEntity1.getLicenceId());
            lFactoryLicenceEntity.setLicencePhoto(ConfigInfo.url_path+"upload/admin/images/factory/" + agencyUserId + "/" + fileName);
            map.put("tag", factoryUserService.updateFactoryLicence(lFactoryLicenceEntity));
        }
        map.put("flag", "1");
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateFactoryUser")
    @ResponseBody
    public Map<String, Object> updateFactoryUser(String factoryId, String name, String mobile, String email, String address,
                                                String province, String city, String areaId, String pid, String status,
                                                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LFactoryUserEntity lFactoryUserEntity = InitEntityUtil.InitLFactoryUserEntity();
        lFactoryUserEntity.setId(Integer.parseInt(factoryId));
        lFactoryUserEntity.setName(name);
        lFactoryUserEntity.setMobile(mobile);
        if (!email.equals("")) lFactoryUserEntity.setEmail(email);
        if (!address.equals("")) lFactoryUserEntity.setAddress(address);
        if(province.equals("")) lFactoryUserEntity.setProvince(province);
        if(city.equals("")) lFactoryUserEntity.setCity(city);
        lFactoryUserEntity.setAreaId(Integer.parseInt(areaId));
        lFactoryUserEntity.setSalesmanId(Integer.parseInt(pid));
        lFactoryUserEntity.setStatus((byte)Integer.parseInt(status));
        lFactoryUserEntity.setUpdTime(DateUtil.NewDateInt());
        map.put("flag", factoryUserService.updateFactoryUser(lFactoryUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateFactoryUserAnay")
    @ResponseBody
    public Map<String, Object> updateFactoryUserAnay(String factoryId, String capacity, String quality, String stability,
                                                 String circumstance, String report, HttpServletRequest httpServletRequest,
                                                     HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LFactoryUserEntity lFactoryUserEntity = InitEntityUtil.InitLFactoryUserEntity();
        lFactoryUserEntity.setId(Integer.parseInt(factoryId));
        lFactoryUserEntity.setCapacity(capacity);
        lFactoryUserEntity.setQuality(quality);
        lFactoryUserEntity.setStability(stability);
        lFactoryUserEntity.setCircumstance(circumstance);
        lFactoryUserEntity.setReport(report);
        lFactoryUserEntity.setUpdTime(DateUtil.NewDateInt());
        map.put("flag", factoryUserService.updateFactoryUser(lFactoryUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UpdateFactoryPwd")
    @ResponseBody
    public Map<String, Object> updateFactoryPwd(String agencyId, HttpServletRequest httpServletRequest,
                                               HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LFactoryUserEntity lFactoryUserEntity = new LFactoryUserEntity();
        lFactoryUserEntity.setId(Integer.parseInt(agencyId));
        lFactoryUserEntity.setPwd(DigestUtils.md5DigestAsHex("123456".getBytes()));
        map.put("flag", factoryUserService.updateFactoryUserNon(lFactoryUserEntity));
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadFactoryLicenceInfo")
    @ResponseBody
    public Map<String, Object> uploadFactoryLicenceInfo(String licenceId, String licenceNumber, String licenceName, String legalPerson,
                                                       String legalPersonTel, String legalPersonIdCard, HttpServletResponse httpServletResponse,
                                                       HttpServletRequest httpServletRequest, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();
        LFactoryLicenceEntity lFactoryLicenceEntity = new LFactoryLicenceEntity();
        lFactoryLicenceEntity.setLicenceNumber(licenceNumber);
        lFactoryLicenceEntity.setLicenceName(licenceName);
        lFactoryLicenceEntity.setLegalPerson(legalPerson);
        lFactoryLicenceEntity.setLegalPersonTel(legalPersonTel);
        lFactoryLicenceEntity.setLegalPersonIdcard(legalPersonIdCard);
        if (licenceId.equals("0")){
            map.put("flag", factoryUserService.addFactoryLicence(lFactoryLicenceEntity));
        }else{
            lFactoryLicenceEntity.setId(Integer.parseInt(licenceId));
            map.put("flag", factoryUserService.updateFactoryLicence(lFactoryLicenceEntity));
        }
        return map;
    }








    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    public AreaService getAreaService() {
        return areaService;
    }

    public SalesmanService getSalesmanService() {
        return salesmanService;
    }

    public void setSalesmanService(SalesmanService salesmanService) {
        this.salesmanService = salesmanService;
    }

    public AgencyUserService getAgencyUserService() {
        return agencyUserService;
    }

    public void setAgencyUserService(AgencyUserService agencyUserService) {
        this.agencyUserService = agencyUserService;
    }

    public void setFactoryUserService(FactoryUserService factoryUserService) {
        this.factoryUserService = factoryUserService;
    }

    public FactoryUserService getFactoryUserService() {
        return factoryUserService;
    }
}
