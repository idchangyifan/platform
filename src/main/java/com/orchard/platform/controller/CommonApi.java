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

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody UserInfoDto userInfoDto) {
        return Result.success(commonService.register(userInfoDto));
    }

    @ApiOperation("用户注册")
    @GetMapping("/login")
    public Result<?> login(String s) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        return Result.success();
    }
}
