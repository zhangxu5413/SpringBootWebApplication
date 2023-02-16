package org.example.bean;

import org.example.info.UserInfo;

import java.util.List;

/**
 * Class Description:
 *
 * @author zxcbv
 */
public class UserControllerOutput {
    private UserInfo userInfo;

    private List<UserInfo> userInfoList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
