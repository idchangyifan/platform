package com.orchard.platform.dao.mapper.auth;

import com.orchard.platform.dao.entity.auth.UserInfoRole;
import com.orchard.platform.dao.entity.auth.UserInfoRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/11/30
*/
@Mapper
public interface UserInfoRoleMapper {
    long countByExample(UserInfoRoleExample example);

    int deleteByExample(UserInfoRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserInfoRole record);

    int insertSelective(UserInfoRole record);

    List<UserInfoRole> selectByExample(UserInfoRoleExample example);

    UserInfoRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserInfoRole record, @Param("example") UserInfoRoleExample example);

    int updateByExample(@Param("record") UserInfoRole record, @Param("example") UserInfoRoleExample example);

    int updateByPrimaryKeySelective(UserInfoRole record);

    int updateByPrimaryKey(UserInfoRole record);
}