package com.example.morandi.pojo;

import java.io.Serializable;

public class Zpqly implements Serializable {
    private int id;
    private String zpdly;
    private int zpqid;
    private String username;

    @Override
    public String toString() {
        return "Zpqly{" +
                "id=" + id +
                ", zpdly='" + zpdly + '\'' +
                ", zpqid=" + zpqid +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZpdly() {
        return zpdly;
    }

    public void setZpdly(String zpdly) {
        this.zpdly = zpdly;
    }

    public int getZpqid() {
        return zpqid;
    }

    public void setZpqid(int zpqid) {
        this.zpqid = zpqid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Zpqly() {
    }

    public Zpqly(int id, String zpdly, int zpqid, String username) {
        this.id = id;
        this.zpdly = zpdly;
        this.zpqid = zpqid;
        this.username = username;
    }
}
