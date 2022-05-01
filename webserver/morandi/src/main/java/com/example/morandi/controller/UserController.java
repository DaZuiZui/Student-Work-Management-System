package com.example.morandi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.pojo.User;
import com.example.morandi.serivce.UserServiceImpl;
import com.example.morandi.util.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //获取yaml中配置的上传路径属性
    @Value(("${web.upload-path}"))
    private String uploadPath;
    @Autowired
    OSSUtil ossUtil ;

    @GetMapping("/getallcxz")
    public String getjazasd(){
        return userService.getjazasd();
    }

    @GetMapping("/cxzdinfor")
    public String cxzhidingxinxi(@RequestParam("username")String username){
        return userService.getjiazhangall(username);
    }

    @PostMapping("/uploadimage")
    public String upload(@RequestPart("files") MultipartFile file, @RequestParam("username")String username) throws IOException {
       try {
           InputStream inputStream = file.getInputStream();
           String name = file.getName();
           name = name + UUID.randomUUID().toString() +".png" ;
           String addOSS = ossUtil.addOSS(inputStream, username, name);
           userService.upimaurl("https://morandizj.oss-cn-beijing.aliyuncs.com/"+addOSS,username);
           return JSON.toJSONString(addOSS);
       }catch (Exception e){
           return JSON.toJSONString(false);
       }
    }

    @PostMapping(value ="/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@RequestParam("imgUrl") String imgUrl) throws IOException {
        File file = new File(uploadPath+"/"+imgUrl);

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @GetMapping("/user/setrole")
    public String setUser(@RequestParam("role") String role, @RequestParam("username") String username){
        userService.setUser(role,username);
        return "true";
    }

    @PostMapping("/user/login")
    public String login(@RequestBody User user){
        try {
            return userService.login(user);
        }catch (Exception e){
            return JSON.toJSONString(false);
        }

    }

    @PostMapping("/user/reg")
    public String reg(@RequestBody User user){
        System.err.println(user);
        return userService.insertdate(user);
    }

    @GetMapping("/user/gettheuser")
    public String selec(@RequestParam("username") String username){
        return JSONArray.toJSONString(userService.selec(username));
    }

    @GetMapping("/user/deleteusername")
    public void deletetheuser(String username){
        userService.deletetheuser(username);
        return;
    }
    @GetMapping("/user/updatePassword")
    public String updateUserPassword(String username , String password){
        try {
            return userService.updatePassword(password,username);
        }catch (Exception e){
            return JSON.toJSONString(false);
        }
    }
    @GetMapping("/user/role")
    public String roleList(){
        try {
            return userService.SelectUserByRole();
        }catch (Exception e){
            return JSON.toJSONString(false);
        }
    }

    @GetMapping("/user/role1")
    public String roleList1(){
        try {
            return userService.SelectUserByRole();
        }catch (Exception e){
            return JSON.toJSONString(false);
        }
    }

    @GetMapping("/hk/getstateaonallhomework")
    public String selectHomeWorkState(@RequestParam("homeworkid")String homeworkid){
        return userService.selectHomeWorkState(homeworkid);
    }

    @GetMapping("/user/updatename")
    public String updateName(String username  ,String name){
        try {
            return userService.updateName(username, name);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(false);
        }
    }
}
