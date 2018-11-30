package com.orchard.platform.dao.entity.auth;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/30
*/
@Data
public class Roles implements Serializable {
    /* 主键*/
    private String id;

    /* 角色名称*/
    private String roleName;

    /* 角色描述*/
    private String roleDescription;

    /* 是否可用,如果不可用将不会添加给用户*/
    private String available;

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