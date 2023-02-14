package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Application;
import org.example.UserInfo;
import org.example.UserMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Class Description:
 *
 * @author zxcbv
 */
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class TestApplication {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_1() throws Exception {
        List<UserInfo> userInfos = userMapper.selectAll();
        String str = new ObjectMapper().writeValueAsString(userInfos);
        System.out.println(str);
    }
}
