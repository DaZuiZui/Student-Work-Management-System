package com.example.morandi;

import com.example.morandi.mapper.CjMapper;
import com.example.morandi.mapper.UserMapper;
import com.example.morandi.pojo.Cj;
import com.example.morandi.pojo.Transcript;
import com.example.morandi.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class T1 {
    @Autowired
    CjMapper cjMapper ;
    @Autowired
    UserMapper userMapper ;
    @Test
    public void test1(){
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
        for (Transcript transcript : list) {
            System.out.println(transcript);
        }

    }
}
