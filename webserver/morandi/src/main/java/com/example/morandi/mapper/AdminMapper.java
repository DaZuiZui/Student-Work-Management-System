package com.example.morandi.mapper;

import com.example.morandi.pojo.Admin;
import com.example.morandi.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AdminMapper {
    @Select("select *from admin  where username = #{username} and password=#{password}")
    public Admin login(Admin user);

    @Select("select *from admin where username = #{username}")
    public Admin selec(@RequestParam("username") String username);

    @Insert("insert into admin value(null,#{username},#{password},#{name},null)")
    public void insertdate(Admin user);

    @Delete("delete from admin where username = #{username}")
    public void deletetheuser(@RequestParam("username")String username);
}
