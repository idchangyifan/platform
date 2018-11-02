package com.orchard.platform.service.common.impl;
/**
 * @author Orchard.Chang
 */

import com.orchard.platform.dao.entity.auth.UserInfo;
import com.orchard.platform.dao.entity.auth.UserInfoExample;
import com.orchard.platform.dao.mapper.auth.UserInfoMapper;
import com.orchard.platform.dto.UserInfoDto;
import com.orchard.platform.service.common.CommonService;
import com.orchard.platform.service.utils.MyUtilService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *@Author orchard.chang
 *@Date 2018/10/2616:36
 *@Version 1.0
 **/
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean register(UserInfoDto userInfoDto) {
        String userName = userInfoDto.getUserName();
        String userId = userInfoDto.getUserId();
        String password = userInfoDto.getUserPassword();
        String userPhone = userInfoDto.getUserPhone();
        //通过校验
        if (verifyInput(userName) && verifyInput(userId) && !StringUtils.isEmpty(password) && MyUtilService.isNumeric(userPhone)) {
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userInfoDto, userInfo);
            userInfo.setId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
            userInfo.setUserType(1);
            userInfo.setCreateBy(userName);
            userInfo.setCreateDate(new Date());
            userInfo.setUpdateDate(new Date());
            userInfo.setUpdateBy(userName);
            userInfo.setUserName(userName);
            userInfo.setUserId(userId);
            userInfo.setUserPassword(password);
            userInfo.setUserPhone(userPhone);
            userInfoMapper.insert(userInfo);
        }
        return false;
    }

    @Override
    public boolean login(String userName, String password) {
        return false;
    }

    @Override
    public boolean verifyInput(String string) {
        return !StringUtils.isEmpty(string) && !StringUtils.containsWhitespace(string) && !MyUtilService.isSpecialChar(string);
    }

    @Override
    public UserInfo findByUserId(String userId) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return userInfoMapper.selectByExample(example).get(0);
    }
}
