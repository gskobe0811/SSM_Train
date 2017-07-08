package com.gushuai.ssm.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * mybatis 映射输出的pojo对象
 */
public class User {

    private int id;


    @Size(min = 2, max = 16, message = "{用户名长度不对}")
    @Pattern(regexp = "[^\'\"]*", message = "{用户名格式不正确}")
    private String username;


    @Size(min = 2, max = 20, message = "{密码长度不对}")
    @Pattern(regexp = "[^\'\"]*", message = "{密码格式不正确}")
    private String password;


    private String address;
    private int telPhone;

    private int userType;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(int telPhone) {
        this.telPhone = telPhone;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", telPhone=" + telPhone +
                '}';
    }



}
