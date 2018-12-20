package com.reborn.service;

import com.reborn.entity.UserInfo;

public interface UserInfoService {
    void add(UserInfo userInfo);
    void update(UserInfo userInfo);
    void delete(int id);
    UserInfo getById(int id);
}
