package com.example.morandi.serivce;

import com.example.morandi.mapper.ZpqMapper;
import com.example.morandi.pojo.Zpq;
import com.example.morandi.pojo.Zpqly;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class ZpqServiceImpl {
    @Autowired
    private ZpqMapper zpqMapper;

    public void insertdate(Zpq zpq){
        zpqMapper.insertdate(zpq);
    }

    public Zpq selectZpqByid(@Param("id")String id){
       return zpqMapper.selectZpqByid(id);
    }


    public ArrayList<Zpq> getalldate(){
        return zpqMapper.getalldate();
    }

    public void addly(@RequestBody Zpqly zpqly){
        zpqMapper.addly(zpqly);
        return;
    }

    public ArrayList<Zpqly> cxzdly( String zpqid){
        return zpqMapper.cxzdly(zpqid);
    }
}
