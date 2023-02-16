package org.example.control;

import org.example.bean.UserControllerInput;
import org.example.bean.UserControllerOutput;
import org.example.info.UserInfo;
import org.example.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Description:
 *
 * @author zxcbv
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserMapper mapper;

    @GetMapping(value = "userList", name = "全部")
    public UserControllerOutput getUserList() {
        logger.info("GetMapping /userList start");
        UserControllerOutput out = createOutput();
        List<UserInfo> userInfoList = mapper.selectAll();
        out.setUserInfoList(userInfoList);

        return out;
    }

    @GetMapping(value = "user/{id}", name = "查询")
    public UserControllerOutput getUser(@PathVariable("id") String id) {
        logger.info("GetMapping /user/{id} start");
        logger.info("id = " + id);
        UserControllerOutput output = createOutput();
        UserInfo userInfo = mapper.selectById(id);
        output.setUserInfo(userInfo);

        return output;
    }

    @PostMapping(value = "user", name = "增加")
    public UserControllerOutput addUser(@RequestBody UserControllerInput input) {
        logger.info("PostMapping /user start");

        UserControllerOutput output = createOutput();

        UserInfo submit = input.getUser();
        mapper.insert(submit);

        output.setUserInfo(submit);

        return output;
    }

    @PutMapping(value = "user/{id}", name = "修改")
    public UserControllerOutput updateUser(@PathVariable("id") String id, @RequestBody UserControllerInput input) {
        logger.info("PutMapping /user start");

        UserControllerOutput output = createOutput();

        UserInfo userInfo = mapper.selectById(id);
        UserInfo submit = input.getUser();

        userInfo.setName(submit.getName());

        mapper.update(userInfo);

        output.setUserInfo(userInfo);

        return output;
    }

    @DeleteMapping(value = "user/{id}", name = "删除")
    public UserControllerOutput deleteUser(@PathVariable("id") String id) {
        logger.info("DeleteMapping /user start");

        UserControllerOutput output = createOutput();

        UserInfo userInfo = mapper.selectById(id);

        mapper.delete(userInfo);

        output.setUserInfo(userInfo);

        return output;
    }

    public UserControllerOutput createOutput() {
        return new UserControllerOutput();
    }
}
