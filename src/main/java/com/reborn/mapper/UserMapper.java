package com.reborn.mapper;

import com.reborn.entity.User;

import java.util.List;

public interface UserMapper {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User findUserById(int id);
    User findUserById2(int id);
    User findUserByNameAndPassword(String loginName,String password);
    List<User> getAllUsers();
}
