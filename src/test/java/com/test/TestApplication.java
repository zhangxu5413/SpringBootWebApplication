package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Application;
import org.example.bean.UserControllerInput;
import org.example.control.UserController;
import org.example.info.UserInfo;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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

    @Autowired
    private UserController userController;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void set() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test_1() throws Exception {
        List<UserInfo> userInfoList = userMapper.selectAll();
        String str = new ObjectMapper().writeValueAsString(userInfoList);
        System.out.println(str);
    }

    @Test
    public void test_get_userList() throws Exception {

        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/userList");
        MockHttpServletResponse response = mockMvc
                .perform(get)
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");
        String responseStr = response.getContentAsString();
        System.out.println(response.getStatus());
        System.out.println(responseStr);
    }

    @Test
    public void test_get_user() throws Exception {
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/user/002");
        MockHttpServletResponse response = mockMvc
                .perform(get)
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");
        String responseStr = response.getContentAsString();
        System.out.println(response.getStatus());
        System.out.println(responseStr);
    }

    @Test
    public void test_post_user() throws Exception {
        UserControllerInput input = new UserControllerInput();
        UserInfo submit = new UserInfo();
        submit.setId("004");
        submit.setName("四五六");
        input.setUser(submit);
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(input);

        MockHttpServletRequestBuilder post =
                MockMvcRequestBuilders
                        .post("/user")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc
                .perform(post)
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");
        String responseStr = response.getContentAsString();
        System.out.println(response.getStatus());
        System.out.println(responseStr);
    }

    @Test
    public void test_put_user() throws Exception {
        UserControllerInput input = new UserControllerInput();
        UserInfo submit = new UserInfo();
        submit.setId("003");
        submit.setName("四五六");
        input.setUser(submit);
        ObjectMapper objectMapper = new ObjectMapper();
        String content = objectMapper.writeValueAsString(input);

        MockHttpServletRequestBuilder put =
                MockMvcRequestBuilders
                        .put("/user/003")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON);

        MockHttpServletResponse response = mockMvc
                .perform(put)
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");
        String responseStr = response.getContentAsString();
        System.out.println(response.getStatus());
        System.out.println(responseStr);
    }

    @Test
    public void test_delete_user() throws Exception {
        MockHttpServletRequestBuilder delete = MockMvcRequestBuilders.delete("/user/003");

        MockHttpServletResponse response = mockMvc
                .perform(delete)
                .andReturn()
                .getResponse();

        response.setCharacterEncoding("UTF-8");
        String responseStr = response.getContentAsString();
        System.out.println(response.getStatus());
        System.out.println(responseStr);

    }
}
