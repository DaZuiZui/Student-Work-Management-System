package com.example.morandi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.pojo.Zpq;
import com.example.morandi.pojo.Zpqly;
import com.example.morandi.serivce.ZpqServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@CrossOrigin
public class ZpqController {
    //获取yaml中配置的上传路径属性
    @Value(("${web.upload-path1}"))
    private String uploadPath;
    @Autowired
    private ZpqServiceImpl zpqService;

    @PostMapping("/zpq/getimage")
    public String upload(@RequestPart("files") MultipartFile file) throws IOException {

        String fileName   = UUID.randomUUID().toString()+file.getOriginalFilename();                   //获取文件原名
        String visibleUri ="/"+fileName;                                  //拼接访问图片的地址
        String saveUri    = uploadPath+"/"+ fileName;        //拼接保存图片的真实地址



        File saveFile = new File(saveUri);
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            file.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }

        saveUri = "http://127.0.0.1/getimage?imgUrl="+"/"+fileName;

        return saveUri;
    }


    @GetMapping("/getwenzhang")
    public String getalldate(){
        return JSONArray.toJSONString(zpqService.getalldate());
    }

    @GetMapping(value ="/zpq/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException {
        System.out.println(imgUrl);
        File file = new File(uploadPath+"/"+imgUrl);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }

    @PostMapping("/zpq/insertdate")
    public void insertdate(@RequestBody Zpq zpq){
        zpqService.insertdate(zpq);
    }

    @GetMapping("/zpq/getdate")
    public String getdate(@RequestParam("id") String id){
        return JSONArray.toJSONString(zpqService.selectZpqByid(id));
    }

    @PostMapping("/zpq/addly")
        public void addly(@RequestBody Zpqly zpqly){
        System.out.println(zpqly);
            zpqService.addly(zpqly);
        return;
    }

    @GetMapping("/zpq/cxpinglun")
    public String cxzdly(@RequestParam("zpqid") String zpqid){
        return JSONArray.toJSONString(zpqService.cxzdly(zpqid));
    }
}
