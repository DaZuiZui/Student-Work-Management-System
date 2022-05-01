package com.example.morandi.mapper;

import com.example.morandi.pojo.Zpq;
import com.example.morandi.pojo.Zpqly;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Component
@Mapper
public interface ZpqMapper {
    @Insert("insert into zpq value(null,#{imaurl},#{miaoshu},#{username})")
    public void insertdate(Zpq zpq);
    @Select("select *from zpq")
    public ArrayList<Zpq> getalldate();
    @Select("select *from zpq where id = #{id}")
    public Zpq selectZpqByid(@Param("id")String id);
    @Insert("insert into zpqly value(null,#{zpdly},#{zpqid},#{username})")
    public void addly( Zpqly zpqly);
    @Select("select *from zpqly where zpqid = #{zpqid}")
    public ArrayList<Zpqly> cxzdly(@Param("zpqid")String zpqid);
}
