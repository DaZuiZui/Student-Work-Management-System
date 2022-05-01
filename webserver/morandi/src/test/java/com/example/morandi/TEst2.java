package com.example.morandi;

import com.example.morandi.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TEst2 {
    @Autowired
    UserMapper userMapper ;
    @Test
    public void test1(){
        userMapper.updataName("6687","打仗三");
    }
}
