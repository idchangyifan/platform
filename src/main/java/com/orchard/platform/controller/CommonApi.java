package com.orchard.platform.controller;

import com.orchard.platform.controller.anno.RestApi;
import com.orchard.platform.dto.Result;
import com.orchard.platform.dto.UserInfoDto;
import com.orchard.platform.service.common.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author orchard.chang
 *@Date 2018/10/2616:37
 *@Version 1.0
 **/
@Api(tags = {"通用接口"})
@RestApi

public class CommonApi {
    @Autowired
    CommonService commonService;

    //TODO:数据校验这一块重写 合理利用@valid
    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody UserInfoDto userInfoDto) {
        return Result.success(commonService.register(userInfoDto));
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody UserInfoDto userInfoDto) {
        String userId = userInfoDto.getUserId();
        String password = userInfoDto.getUserPassword();
        return Result.success();
    }
}
