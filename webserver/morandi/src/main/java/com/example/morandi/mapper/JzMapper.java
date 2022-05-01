package com.example.morandi.mapper;

import com.example.morandi.pojo.Jz;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Component
public interface JzMapper {
    @Insert("insert into jz value(null,#{son},#{parent}) ")
    public void setdate(@RequestBody Jz jz);
    @Select("select *from jz where parent = #{parent}")
    public Jz selectdateojz(@Param("parent")String parent);
    @Select("select *from jz ")
    public List<Jz> selectAll();

    //select * FROM user u INNER JOIN jz j on j.son = u.username
}
