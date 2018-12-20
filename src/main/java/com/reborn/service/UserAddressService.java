package com.reborn.service;

import com.reborn.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    void add(UserAddress userAddress);
    void update(UserAddress userAddress);
    void delete(int id);
    UserAddress getById(int id);
    List<UserAddress> getByUserInfoId(int userInfoId);
}
