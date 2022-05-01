package com.example.morandi.pojo;

import java.io.Serializable;

public class Zpq   implements Serializable  {
    private int id;
    private String imaurl;
    private String miaoshu;
    private String username;

    @Override
    public String toString() {
        return "Zpq{" +
                "id=" + id +
                ", imaurl='" + imaurl + '\'' +
                ", miaoshu='" + miaoshu + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImaurl() {
        return imaurl;
    }

    public void setImaurl(String imaurl) {
        this.imaurl = imaurl;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Zpq() {
    }

    public Zpq(int id, String imaurl, String miaoshu, String username) {
        this.id = id;
        this.imaurl = imaurl;
        this.miaoshu = miaoshu;
        this.username = username;
    }
}
