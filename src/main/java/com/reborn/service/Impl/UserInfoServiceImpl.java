package com.reborn.service.Impl;

import com.reborn.entity.UserInfo;
import com.reborn.mapper.UserInfoMapper;
import com.reborn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public void delete(int id) {

        userInfoMapper.deleteUserInfo(id);
    }

    @Override
    public UserInfo getById(int id) {
        return userInfoMapper.findUserInfoById(id);
    }
}
