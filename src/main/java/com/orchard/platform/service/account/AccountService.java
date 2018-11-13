package com.orchard.platform.service.account;

import com.orchard.platform.dao.entity.auth.UserInfo;
import com.orchard.platform.dto.UserInfoDto;

/**
 *@Author orchard.chang
 *@Date 2018/10/1715:04
 *@Version 1.0
 **/
public interface AccountService {
    /**
     * 注册
     *
     * @param userInfoDto
     * @return
     */
    boolean register(UserInfoDto userInfoDto);

    /**
     * 登陆
     *
     * @param userInfoDto
     * @return
     */
    boolean login(UserInfoDto userInfoDto);

    /**
     * 校验输入不为空、不包含特殊字符、不包含空格
     *
     * @param string
     * @return
     */
    boolean verifyInput(String string);

    /**
     * 根据用户账号查找用户信息
     * @param userId
     * @return
     */
    UserInfo findByUserId(String userId);


}
