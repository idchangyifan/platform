package com.orchrad.platform;

import com.orchard.platform.CloudOrchardApplication;
import com.orchard.platform.dao.mapper.auth.UserInfoMapper;
import com.orchard.platform.service.common.CommonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CloudOrchardApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlatformApplicationTests {
    @Autowired
    CommonService commonService;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testFindUserInfoByUserId(){
        Assert.assertEquals(commonService.findByUserId("orchard").getUserPassword(), "12345");
    }
}
