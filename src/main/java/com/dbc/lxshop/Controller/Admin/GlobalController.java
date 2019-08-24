package com.dbc.lxshop.Controller.Admin;

import com.dbc.lxshop.Utils.ConfigInfo;
import com.dbc.lxshop.Utils.ImageCutUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: lxshop
 * @description:
 * @author: DBC
 * @create: 2019-08-17 16:55
 **/
@Controller
@RequestMapping("/Admin")
public class GlobalController {
    @RequestMapping(method = RequestMethod.GET, value = "/Test")
    public String test(ModelMap modelMap){
        return "admin/test";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/UploadImage")
    @ResponseBody
    public Map<String, Object> uploadCR(@RequestParam(value = "imgFile",required=false)MultipartFile imgFile, String goodId, String key,
                                        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap modelMap){
        Map<String, Object> map = new HashMap<String, Object>();

        String dir = ConfigInfo.goods_images_upload_path + goodId + "/details/";
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
            map.put("flag", "1");
        }
        map.put("flag", ConfigInfo.url_path+"upload/admin/images/goods/" + goodId + "/details/" + fileName);
        return map;
    }
}
