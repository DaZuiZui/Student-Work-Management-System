package com.example.morandi.pojo;

import java.io.Serializable;

public class GGG implements Serializable {
    private String studentusername;
    private String studentname;
    private String parentusername;
    private String parentname;
    private String parentpassword;

    public GGG() {
    }

    public GGG(String studentusername, String studentname, String parentusername, String parentname, String parentpassword) {
        this.studentusername = studentusername;
        this.studentname = studentname;
        this.parentusername = parentusername;
        this.parentname = parentname;
        this.parentpassword = parentpassword;
    }

    public String getStudentusername() {
        return studentusername;
    }

    public void setStudentusername(String studentusername) {
        this.studentusername = studentusername;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getParentusername() {
        return parentusername;
    }

    public void setParentusername(String parentusername) {
        this.parentusername = parentusername;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getParentpassword() {
        return parentpassword;
    }

    public void setParentpassword(String parentpassword) {
        this.parentpassword = parentpassword;
    }

    @Override
    public String toString() {
        return "GGG{" +
                "studentusername='" + studentusername + '\'' +
                ", studentname='" + studentname + '\'' +
                ", parentusername='" + parentusername + '\'' +
                ", parentname='" + parentname + '\'' +
                ", parentpassword='" + parentpassword + '\'' +
                '}';
    }
}
