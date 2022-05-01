package com.example.morandi.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.morandi.pojo.Cj;
import com.example.morandi.serivce.CjServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class CjController {
    @Autowired
    private CjServiceImpl cjService;

    @GetMapping("/cj/getallchengji")
    public String getsuoyouchengonanyonestudent(){ return cjService.getsuoyouchengonanyonestudent();
    }

    @PostMapping("/cj/ucj")
    public void ucj(@RequestBody Cj cj){
        System.out.println(cj);
        cjService.ucj(cj);
    }

    @GetMapping("/cj/sbyid")
    public String selectCj(@Param("id") String id){
        return JSONArray.toJSONString(cjService.selectCj(id));
    }

    @GetMapping("/cj/fbcj")
    public void pfcj(@RequestBody Cj cj){
        cjService.pfcj(cj);
    }

    @GetMapping("/cj/del")
    public void deletcj(@RequestParam("id") String id){
        cjService.deletcj(id);
    }



}
