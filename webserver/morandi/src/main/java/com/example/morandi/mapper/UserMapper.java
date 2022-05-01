package com.example.morandi.mapper;

import com.example.morandi.pojo.GGG;
import com.example.morandi.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Mapper
public interface UserMapper {
    @Select("(SELECT " +
            " u1.username as 'studentusername', " +
            " u1.name as 'studentname', " +
            " u2.username as 'parentusername', " +
            " u2.name as 'parentname', " +
            " u2.`password` as 'parentpassword' " +
            " from " +
            "  user u1 " +
            "  INNER JOIN " +
            " user u2 " +
            " where " +
            " u1.username = ( " +
            " SELECT " +
            " u.sonusername " +
            " FROM " +
            " user u " +
            " where " +
            " u.username = #{username} " +
            " ) " +
            " and " +
            " u2.username  = #{username} " +
            " ) ")
    public ArrayList<GGG> getjiazhangall(@Param("username")String username);



    @Select(" SELECT " +
            " u2.username as 'parentusername', " +
            " u2.name as 'parentname', " +
            " u1.username as 'studentusername', " +
            " u2.password as 'parentpassword', "+
            " u1.`name`   as 'studentname' " +
            " from " +
            "  user u1 " +
            " INNER JOIN " +
            " user u2 " +
            " where  " +
            " u2.role = 'guardian' and " +
            " u1.username = u2.sonusername ")
    public ArrayList<GGG> getjazasd();


    @Select("select *from user where username = #{username} and password = #{password}")
    public User login(User user);
    @Select("select * from user where role = 'student'")
    public List<User> roleList();

    @Select("select *from user where username = #{username}")
    public User selec(@RequestParam("username") String username);

    @Insert("insert into user(username,password,name,role,sonusername) values(#{username},#{password},#{name},#{role},#{sonusername})")
    public void insertdate(User user);

    @Delete("delete from user where username = #{username}")
    public void deletetheuser(@RequestParam("username")String username);

    @Update("update user set role = #{role} where username = #{username}")
    public void setUser(@Param("role") String role,@Param("username") String username);

    @Update("update user set imaurl = #{imaurl} where username = #{username}")
    public void upimaurl(@Param("imaurl")String url ,@Param("username")String username);

    @Update("update user set password = #{password} where username = #{username}")
    public int updatePassword(@Param("password")String password , @Param("username")String username) ;
//

    @Update("update user set name =#{name}  where username = #{username}")
    public int updataName(String username , String name);



}
