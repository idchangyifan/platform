package com.orchard.platform.dto;

/**
 *@Author orchard.chang
 *@Date 2018/10/1810:10
 *@Version 1.0
 **/
public class UserInfoDto {
    private String userName;

    private String userId;

    private String userPassword;

    private String userPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
