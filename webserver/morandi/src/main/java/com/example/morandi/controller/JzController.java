package com.example.morandi.controller;

import com.alibaba.fastjson.JSON;
import com.example.morandi.pojo.Jz;
import com.example.morandi.serivce.JzServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class JzController {
    @Autowired
    private JzServiceImpl jzService;

    @PostMapping("/jz/setdate")
    public void setdate(@RequestBody Jz jz){
        jzService.setdate(jz);
    }

    @GetMapping("/cj/selecthaizi")
    public String selecthaizi(@RequestParam("parent")String parent){
        return jzService.selectdateojz(parent);
    }
    @GetMapping("/jz/all")
    public String selectAllJZ(){
        try {
            return jzService.JZselectAll();
        }catch (Exception e){
            return JSON.toJSONString(false);
        }

    }
}
