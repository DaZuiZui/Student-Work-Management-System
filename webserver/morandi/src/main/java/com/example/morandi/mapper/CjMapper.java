package com.example.morandi.mapper;

import com.example.morandi.pojo.Cj;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@Mapper
public interface CjMapper {
    @Insert("insert into cj value(null,' ',#{price},#{username})")
    public void pfcj(@RequestBody Cj cj);

    @Delete("delete from cj where id = #{id}")
    public void deletcj(@Param("id") String id);

    @Select("select *from cj where username = #{username}")
    public Cj selectCj(@Param("username") String username);

    @Update("update cj set price =#{price} where username = #{username}")
    public void ucj(Cj cj);
    @Select("select *from cj")
    public List<Cj> selectAll();

}
