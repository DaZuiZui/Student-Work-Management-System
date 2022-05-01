package com.example.morandi.serivce;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.mapper.HomeworkMapper;
import com.example.morandi.mapper.UserMapper;
import com.example.morandi.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public String getjazasd(){
        return JSONArray.toJSONString(userMapper.getjazasd());
    }

    public String getjiazhangall(String username){
        return JSONArray.toJSONString(userMapper.getjiazhangall(username));
    }

    public String login(@RequestBody User user){
        return JSON.toJSONString(userMapper.login(user));
    }

    public void setUser(@RequestParam("role") String role, @RequestParam("username") String username){
        userMapper.setUser(role,username);
    }

    public void upimaurl(@Param("imaurl")String url , @Param("username")String username){
        userMapper.upimaurl(url,username);
    }

    public User selec(@RequestParam("username") String username){
       return userMapper.selec(username);
    }


    public void deletetheuser(String username){
        userMapper.deletetheuser(username);
    }

    public String insertdate(User user){
        User selec = this.selec(user.getUsername());
        if (selec == null)
            userMapper.insertdate(user);
        else
            return "false";

        return "true";
    }

    public String updatePassword( String password,String username ){

        int i = userMapper.updatePassword(password, username);
        if (i>=1){
            return JSON.toJSONString(true);
        }else {
            return  JSON.toJSONString(false);
        }
    }
    public String SelectUserByRole(){
        List<User> users = userMapper.roleList();
        return JSON.toJSONString(users);
    }
    @Autowired
    HomeworkMapper homeworkMapper;
    public String selectHomeWorkState(String homeworkId){
        List<User> users = userMapper.roleList();
        List<HomeWorkS> homeWorkS = new ArrayList<>();
        List<HomeWorkState> homeworkState = homeworkMapper.getHomeworkState(homeworkId);
        for (User user : users) {
            HomeWorkS workS = new HomeWorkS();
            workS.setName(user.getName());
            workS.setUsername(user.getUsername());
            workS.setState("未提交");
            workS.setId(user.getId());
            homeWorkS.add(workS);
        }
        for (HomeWorkState state : homeworkState) {
            for (HomeWorkS work : homeWorkS) {
                if (work.getUsername().equals(state.getUsername())){
                    work.setState("已提交");
                }
            }
        }
        return JSON.toJSONString(homeWorkS);
    }


    public String updateName(String username ,String name){
        int i = userMapper.updataName(username, name);
        if (i>=1){
            return JSON.toJSONString(true);
        }else {
            return JSON.toJSONString(false);
        }
    }
}
