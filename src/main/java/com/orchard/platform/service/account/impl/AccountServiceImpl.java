package com.orchard.platform.service.account.impl;
/**
 * @author Orchard.Chang
 */

import com.orchard.platform.dao.entity.auth.UserInfo;
import com.orchard.platform.dao.entity.auth.UserInfoExample;
import com.orchard.platform.dao.mapper.auth.UserInfoMapper;
import com.orchard.platform.dto.Result;
import com.orchard.platform.dto.UserInfoDto;
import com.orchard.platform.service.account.AccountService;
import com.orchard.platform.service.utils.MyUtilService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.UUID;

/**
 *@Author orchard.chang
 *@Date 2018/10/2616:36
 *@Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean register(UserInfoDto userInfoDto) {
        String userName = userInfoDto.getUserName();
        String userId = userInfoDto.getUserId();
        String password = userInfoDto.getUserPassword();
        String userPhone = userInfoDto.getUserPhone();
        String password2 = userInfoDto.getUserPassword2();

        //通过校验
        if (verifyInput(userName) && verifyInput(userId) && !StringUtils.isEmpty(password) && MyUtilService.isNumeric(userPhone) && password.equals(password2)) {
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
            userInfo.setUserPhone(userPhone);
            String salt = RandomStringUtils.randomAlphanumeric(10) + userId;
            userInfo.setSalt(salt);
            userInfo.setUserPassword(new SimpleHash("MD5", password, salt,5).toString());
            userInfoMapper.insert(userInfo);
            return true;
        }
        throw new RuntimeException("输入有误，请校验输入");
    }

    @Override
    public boolean login(UserInfoDto userInfoDto) {
        String userId = userInfoDto.getUserId();
        String password = userInfoDto.getUserPassword();
        boolean rememberMe = userInfoDto.isRememberMe();
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(userId, password, rememberMe);
            try {
                //最终，会调用MyShiroRealm中override的doGetAuthenticationInfo方法
                currentUser.login(token);
                return true;
            }
            catch (AuthenticationException e) {
                throw new RuntimeException("账户或密码不正确");
            }
        }
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
