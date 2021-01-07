package edu.nifu.sas.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private int type;
    private String stuno;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.userName = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                ", stuno='" + stuno + '\'' +
                '}';
    }
}
