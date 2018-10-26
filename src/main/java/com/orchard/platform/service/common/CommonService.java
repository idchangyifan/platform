package com.orchard.platform.service.common;/**
 * @author Orchard.Chang
 */

import com.orchard.platform.dto.UserInfoDto;

/**
 *@Author orchard.chang
 *@Date 2018/10/1715:04
 *@Version 1.0
 **/
public interface CommonService {
    /**
     * 注册
     * @param userInfoDto
     * @return
     */
    boolean register(UserInfoDto userInfoDto);

    /**
     * 登陆
     * @param userName
     * @param password
     * @return
     */
    boolean login(String userName, String password);

    /**
     * 校验输入不为空、不包含特殊字符、不包含空格
     * @param string
     * @return
     */
    boolean verifyInput(String string);
}
