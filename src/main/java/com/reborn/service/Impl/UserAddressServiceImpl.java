package com.reborn.service.Impl;

import com.reborn.entity.UserAddress;
import com.reborn.mapper.UserAddressMapper;
import com.reborn.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;
    @Override
    public void add(UserAddress userAddress) {
        userAddressMapper.addAddress(userAddress);
    }

    @Override
    public void update(UserAddress userAddress) {
        userAddressMapper.updateAddress(userAddress);
    }

    @Override
    public void delete(int id) {
        userAddressMapper.deleteAddress(id);
    }

    @Override
    public UserAddress getById(int id) {
        return userAddressMapper.findAddressById(id);
    }

    @Override
    public List<UserAddress> getByUserInfoId(int userInfoId) {
        return userAddressMapper.findAddressByUserInfoId(userInfoId);
    }
}
