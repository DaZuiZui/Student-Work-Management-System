package com.example.morandi.serivce;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.mapper.HomeworkMapper;
import com.example.morandi.pojo.HomeWorkState;
import com.example.morandi.pojo.Homework;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {
    @Autowired
    private HomeworkMapper homeworkMapper;

    public String gethomeWorkByusername(@Param("username")String username, @Param("id")String id){
        System.out.println(username + ""+id);
        return JSONArray.toJSONString(homeworkMapper.gethomeWorkByusername(username, id));
    }

    public String getAll(){
        List<Homework> all =
                homeworkMapper.getAll();
        return JSON.toJSONString(all) ;
    }

    public String insert(Homework homework){
        int insert = homeworkMapper.insert(homework);
        if (insert>=1){
            return JSON.toJSONString(true);
        }else {
            return JSON.toJSONString(false);
        }
    }

    public String insertdate(HomeWorkState homeWorkState){
        int insertdate = homeworkMapper.insertdate(homeWorkState);
        if (insertdate>=1){
            return JSON.toJSONString(true);
        }else {
            return JSON.toJSONString(false);
        }
    }

    public String updateHomeWorkSDate(HomeWorkState homeWorkState){
        int i = homeworkMapper.updateHomeWorkSDate(homeWorkState);
        if (i>=1){
            return JSON.toJSONString(true);
        }else {
            return JSON.toJSONString(false);
        }
    }

    public void delhome(@Param("id")String id){
        homeworkMapper.delhome(id);
    }

    public String updatehome(Homework homework){
        int updatehome = homeworkMapper.updatehome(homework);
        if (updatehome>=1){
            return JSON.toJSONString(true);
        }else {
            return JSON.toJSONString(false);
        }
    }
    public void delhomestate(@Param("username")String username,@Param("homewokeid")String homewokeid){
        homeworkMapper.delhomestate(username, homewokeid);
    }

    public String SelectAllStart(String id){
        List<HomeWorkState> allStart = homeworkMapper.getAllStart(id);
        return JSON.toJSONString(allStart);
    }
}
