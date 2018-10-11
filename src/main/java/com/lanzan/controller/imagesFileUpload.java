package com.lanzan.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@MultipartConfig
public class imagesFileUpload {

    /**
     *
     * 上传图片
     */
    @RequestMapping(value = "uploadImg" , method = RequestMethod.POST , produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file) throws IOException {
        //如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            System.out.println("文件为空");
            //上传文件路径
            //http://192.168.13.88:8080/D:/MyPackage/tomcat7.0/apache-tomcat-7.0.68/webapps/farmimg
            //122.152.192.232--/usr/local/apache-tomcat-8.0.53/webapps/farmimg
            String path = "C:/Users/chen_/Desktop/farmimg";
            System.out.println("文件名称"+file.getOriginalFilename());
            //上传文件名
            String filename = System.nanoTime()+file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，没有就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文档中
            File file1 = new File(path + File.separator + filename);
            file.transferTo(file1);
            String url = "http://122.152.192.232:80/farmimg/"+filename;
            Map<String, Object> res = new HashMap<String, Object>();
            //返回的是一个url对象
            res.put("url", url);
            String jsonString=JSON.toJSONString(res);
            System.out.println("res:" + res);
            return jsonString;
        } else {
            System.out.println("文件不为空");
            Map<String, Object> res = new HashMap<String, Object>();
            //返回的是一个url对象
            res.put("code", 500);
            String jsonString=JSON.toJSONString(res);
            return jsonString;
        }

    }



}

