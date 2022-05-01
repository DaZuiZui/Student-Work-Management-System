package com.example.morandi.serivce;

import com.alibaba.fastjson.JSONArray;
import com.example.morandi.mapper.CjMapper;
import com.example.morandi.mapper.UserMapper;
import com.example.morandi.pojo.Cj;
import com.example.morandi.pojo.Transcript;
import com.example.morandi.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CjServiceImpl {
    @Autowired
    private CjMapper cjMapper;

    public void pfcj(@RequestBody Cj cj){
        cjMapper.pfcj(cj);
    }

    public void ucj(Cj cj){
        Cj cj1 = cjMapper.selectCj(cj.getUsername());
        if (cj1 == null) {
            cjMapper.pfcj(cj);
        }else{
            cjMapper.ucj(cj);
        }
    }
    public Cj selectCj(@Param("id") String id){
        return cjMapper.selectCj(id);
    }

    public void deletcj(@Param("id") String id){
        cjMapper.deletcj(id);
    }

    @Autowired
    private UserMapper userMapper;

    public String getsuoyouchengonanyonestudent(){
        List<Cj> cjs = cjMapper.selectAll();
        List<User> users = userMapper.roleList();
        List<Transcript> list = new ArrayList<>();
        for (User user : users) {
            Transcript transcript = new Transcript();
            transcript.setName(user.getName());
            transcript.setUsername(user.getUsername());
            transcript.setPrice(0.0);
            list.add(transcript);
        }
        for (Cj cj : cjs) {
            for (Transcript transcript : list) {
                if (cj.getUsername().equals(transcript.getUsername())){
                    transcript.setPrice(cj.getPrice());
                }
            }
        }

        return JSONArray.toJSONString(list);
    }
}
