package com.example.morandi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.pojo.HomeWorkState;
import com.example.morandi.pojo.Homework;
import com.example.morandi.serivce.HomeworkService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController

public class HomworkController {
    @Autowired
    private HomeworkService homeworkService;


    @GetMapping("/hk/gethomeWorkByusername")
    public String gethomeWorkByusername(@RequestParam("username")String username, @RequestParam("homewokeid")String id){
        return homeworkService.gethomeWorkByusername(username,id);
    }

    @GetMapping("/hk/getAll")
    public String getAll(){
      try {
           return homeworkService.getAll();
      }catch (Exception e){
          return JSON.toJSONString(false);
      }
    }

    @PostMapping("/hk/fabu")
    public String insert(@RequestBody Homework homework){
        if (homework.getTime() == null){
            homework.setTime(new Date());
        }

        try {
            return homeworkService.insert(homework);
        }catch (Exception e){
            return JSON.toJSONString(false);
        }

    }

    @PostMapping("/hk/wczy")
    public String overzuoye(@RequestBody HomeWorkState homeWorkState){
        System.out.println(homeWorkState);
        try {
            return homeworkService.insertdate(homeWorkState);
        }catch (Exception e){
            e.printStackTrace();
            return JSON.toJSONString(false);
        }

    }

    @PostMapping("/hk/xiugaizuoyezhuangtai")
    public String updateHomeWorkSDate(HomeWorkState homeWorkState){
        try {
            return homeworkService.updateHomeWorkSDate(homeWorkState);
        }catch (Exception e){
            return JSON.toJSONString(false);
        }
    }

    @GetMapping("/hk/shanchuzuoye")
    public void delhome(@Param("id")String id){
        homeworkService.delhome(id);
    }

    @PostMapping("/hk/updatehome")
    public String updatehome(@RequestBody Homework homework){
        System.err.println(homework);
       return homeworkService.updatehome(homework);
    }
    @GetMapping("hk/selectallstart")
    public String selectAllStart(String id){
        try {
            return homeworkService.SelectAllStart(id);
        }catch (Exception e){
            return JSON.toJSONString(false);
        }
    }

    @GetMapping("/hk/delthedata")
    public void delhomestate(@Param("username")String username,@Param("homewokeid")String homewokeid){
        System.err.println(username +"     " +homewokeid);
        homeworkService.delhomestate(username, homewokeid);
    }




}
