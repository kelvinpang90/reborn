package com.reborn.mapper;

import com.reborn.entity.UserInfo;

public interface UserInfoMapper {
    void addUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(int id);
    UserInfo findUserInfoById(int id);
}
