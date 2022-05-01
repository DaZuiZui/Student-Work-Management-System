package com.example.morandi;

import com.example.morandi.controller.HomworkController;
import com.example.morandi.mapper.HomeworkMapper;
import com.example.morandi.pojo.HomeWorkState;
import com.example.morandi.pojo.Homework;
import com.example.morandi.serivce.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.Target;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MorandiApplicationTests {
    @Autowired
    HomeworkMapper homeworkMapper ;
    @Test
    void contextLoads() {
        Homework homework = new Homework();
        homework.setTime(new Date());
        homework.setContext("这是正文");
        homework.setName("我是张三");
        homework.setTeacher("wu");
        homeworkMapper.insert(homework);
    }
    @Autowired
    HomworkController homworkControll ;
    @Test
    void test1(){
        List<Homework> all = homeworkMapper.getAll();
    }


    @Test
    void test2(){
        Homework homework = new Homework( );
        homework.setId(9) ;
        homework.setName("我是赵四");
        homework.setContext("我不是正文");
//        homeworkMapper.updatehome(homework);
        homworkControll.updatehome(homework);
    }
    @Test
    void test4(){
        HomeWorkState homeWorkState = new HomeWorkState();
        homeWorkState.setState("已完成");
        homeWorkState.setUsername("6688");
        homeWorkState.setHomewokeid(1);
        homeworkMapper.insertdate(homeWorkState);
    }
    @Test
    public  void  test5(){
        List<HomeWorkState> homeworkState = homeworkMapper.getHomeworkState("18");
        homeworkState.forEach(System.out::println);
    }
    @Autowired
    UserServiceImpl userService;

    @Test
    public void test6(){
        String s = userService.selectHomeWorkState("25");
        System.out.println(s);
    }

}
