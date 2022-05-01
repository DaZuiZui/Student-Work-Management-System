package com.example.morandi.pojo;

public class HomeWorkState {
    private int id;
    private int homewokeid;
    private String username;
    private String state;

    public HomeWorkState() {
    }

    @Override
    public String toString() {
        return "HomeWorkState{" +
                "id=" + id +
                ", homewokeid=" + homewokeid +
                ", username='" + username + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHomewokeid() {
        return homewokeid;
    }

    public void setHomewokeid(int homewokeid) {
        this.homewokeid = homewokeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public HomeWorkState(int id, int homewokeid, String username, String state) {
        this.id = id;
        this.homewokeid = homewokeid;
        this.username = username;
        this.state = state;
    }
}
