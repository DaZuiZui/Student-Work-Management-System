package com.example.morandi.serivce;

import com.example.morandi.mapper.AdminMapper;
import com.example.morandi.mapper.UserMapper;
import com.example.morandi.pojo.Admin;
import com.example.morandi.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AdminServiceImpl {
    @Autowired
    private AdminMapper adminMapper;

    public String login(@RequestBody Admin user){
        Admin login = adminMapper.login(user);
        if (login != null){
            return "true";
        }else{
            return "false";
        }
    }


    public Admin selec(@RequestParam("username") String username){
       return adminMapper.selec(username);
    }


    public void deletetheuser(String username){
        adminMapper.deletetheuser(username);
    }

    public String insertdate(Admin user){
        Admin selec = this.selec(user.getUsername());
        if (selec == null)
            adminMapper.insertdate(user);
        else
            return "false";

        return "true";
    }
}
