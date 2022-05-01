package com.example.morandi.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.morandi.pojo.Admin;
import com.example.morandi.pojo.User;
import com.example.morandi.serivce.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/admin/login")
    public String login(@RequestBody Admin user){
        return adminService.login(user);
    }

    @PostMapping("/admin/reg")
    public String reg(@RequestBody Admin user){
        return adminService.insertdate(user);
    }

    @GetMapping("/admin/gettheuser")
    public String selec(@RequestParam("username") String username){
        return JSONArray.toJSONString(adminService.selec(username));
    }

    @GetMapping("/admin/deleteusername")
    public void deletetheuser(String username){
        adminService.deletetheuser(username);
        return;
    }
}
