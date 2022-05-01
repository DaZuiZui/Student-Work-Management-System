package com.example.morandi.mapper;

import com.example.morandi.pojo.HomeWorkState;
import com.example.morandi.pojo.Homework;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeworkMapper {
    @Select("select * from homework;")
    public List<Homework>  getAll() ;
    @Select("select * from  homewokeS where homewokeid=#{id}")
    public List<HomeWorkState> getAllStart(String id);

    @Insert("insert into homework value(null,#{name},#{time},#{teacher},#{context})")
    public int insert(Homework homework);

    @Select("select * from  homewokeS where homewokeid = #{id} and username = #{username}")
    public List<HomeWorkState> gethomeWorkByusername(@Param("username")String username,@Param("id")String id);

    /*
        完成作业
     */
    @Insert("insert into homewokeS value(null,#{homewokeid},#{username},#{state})")
    public int insertdate(HomeWorkState homeWorkState);

    /**
     * 修改作业完成情况
     */
    @Update("update homeworkS set username = #{username} , state = #{state} , homewokeid = #{homewokeid} where id = #{id}")
    public int updateHomeWorkSDate(HomeWorkState homeWorkState);

    @Delete("delete from homework where id = #{id}")
    public void delhome(@Param("id")String id);

    @Update("update homework set name = #{name} , context=#{context}  where id = #{id}")
    public int updatehome(Homework homework);

    @Select("select * from homeworkS where username = #{username} and homewokeid =#{homewokeid}")
    public List<HomeWorkState> gethomestate(@Param("username")String username,@Param("homewokeid")String homewokeid);
    @Select("select * from homewokeS where  homewokeid = #{homework}")
    public List<HomeWorkState> getHomeworkState(String homework) ;

    @Delete("delete from homewokeS where username = #{username} and homewokeid =#{homewokeid}")
    public void delhomestate(@Param("username")String username,@Param("homewokeid")String homewokeid);
}
