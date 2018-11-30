package com.orchard.platform.dao.entity.auth;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/30
*/
@Data
public class UserInfoRole implements Serializable {
    /* 主键*/
    private String id;

    /* 用户id*/
    private String userInfoId;

    /* 角色id*/
    private String roleId;

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