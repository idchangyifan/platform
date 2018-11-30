package com.orchard.platform.dao.entity.auth;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/30
*/
@Data
public class UserInfo implements Serializable {
    /* 主键*/
    private String id;

    /* 真实姓名*/
    private String userName;

    /* 账号*/
    private String userId;

    /* 密码*/
    private String userPassword;

    /* 盐*/
    private String salt;

    /* 用户类型*/
    private Integer userType;

    /* 手机号*/
    private String userPhone;

    /* 创建时间*/
    private Date createDate;

    /* 更新时间*/
    private Date updateDate;

    /* 创建者*/
    private String createBy;

    /* 修改者*/
    private String updateBy;

    private static final long serialVersionUID = 1L;
}