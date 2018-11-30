package com.orchard.platform.dao.entity.auth;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/30
*/
@Data
public class Permission implements Serializable {
    /* 主键*/
    private String id;

    /* 权限名*/
    private String name;

    /* 权限*/
    private String permission;

    /* 资源id*/
    private String resourceId;

    /* 域id*/
    private String scopeId;

    /* 动作id*/
    private String actionId;

    /* 资源实例*/
    private String resourceInstanceId;

    /* 状态*/
    private String status;

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