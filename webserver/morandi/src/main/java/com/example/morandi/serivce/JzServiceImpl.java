package com.example.morandi.serivce;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.morandi.mapper.JzMapper;
import com.example.morandi.pojo.Jz;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JzServiceImpl {
    @Autowired
    private JzMapper jzMapper;



    public void setdate(@RequestBody Jz jz){
        jzMapper.setdate(jz);
    }

    public String selectdateojz(@Param("parent")String parent){
        Jz selectdateojz = jzMapper.selectdateojz(parent);
        return JSONArray.toJSONString(selectdateojz);
    }

    public String JZselectAll(){
        List<Jz> jzs = jzMapper.selectAll();
        return JSON.toJSONString(jzs);
    }
}
