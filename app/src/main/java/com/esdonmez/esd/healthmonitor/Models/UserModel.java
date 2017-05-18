package com.esdonmez.esd.healthmonitor.Models;

public class UserModel {

    private String UserName;
    private String Email;
    private String Password;


    public UserModel(String userName, String email, String password) {
        UserName = userName;
        Email = email;
        Password = password;
    }


    public UserModel(){

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
