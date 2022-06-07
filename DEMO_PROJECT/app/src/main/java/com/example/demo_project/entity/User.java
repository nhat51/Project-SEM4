package com.example.demo_project.entity;

import java.util.Date;
public class User {
    private int userTd;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private int role;
    private int status;
    private Date created_at;
    private Date updated_at;


    public User() {
    }

    public User(int userTd, String userName, String password, String fullName, String email, String phone, int role, int status, Date created_at, Date updated_at) {
        this.userTd = userTd;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getUserTd() {
        return userTd;
    }

    public void setUserTd(int userTd) {
        this.userTd = userTd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
