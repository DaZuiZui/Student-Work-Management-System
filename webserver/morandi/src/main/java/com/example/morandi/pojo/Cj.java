package com.example.morandi.pojo;

import java.io.Serializable;

public class Cj  implements Serializable {
    private int id;
    private String kemu;
    private double price;
    private String username;

    @Override
    public String toString() {
        return "Cj{" +
                "id=" + id +
                ", kemu='" + kemu + '\'' +
                ", price=" + price +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cj() {
    }

    public Cj(int id, String kemu, double price, String username) {
        this.id = id;
        this.kemu = kemu;
        this.price = price;
        this.username = username;
    }
}
