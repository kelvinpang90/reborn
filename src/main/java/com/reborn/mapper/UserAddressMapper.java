package com.reborn.mapper;

import com.reborn.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    void addAddress(UserAddress userAddress);
    void updateAddress(UserAddress userAddress);
    void deleteAddress(int id);
    UserAddress findAddressById(int id);
    List<UserAddress> findAddressByUserInfoId(int userInfoId);
}
