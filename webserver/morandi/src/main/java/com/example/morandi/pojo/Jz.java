package com.example.morandi.pojo;

import java.io.Serializable;

public class Jz  implements Serializable {
    private int id;
    private String son;
    private String parent;

    @Override
    public String toString() {
        return "Jz{" +
                "id=" + id +
                ", son='" + son + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Jz() {
    }

    public Jz(int id, String son, String parent) {
        this.id = id;
        this.son = son;
        this.parent = parent;
    }
}
