package com.esdonmez.esd.healthmonitor.Models;

public class UserModel {

    private int UserId;
    private String UserName;
    private String Email;
    private String Password;


    public UserModel(int userId, String userName, String email, String password) {
        UserId = userId;
        UserName = userName;
        Email = email;
        Password = password;
    }


    public UserModel(){

    }


    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
