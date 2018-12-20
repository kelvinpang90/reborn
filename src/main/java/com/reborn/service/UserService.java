package com.reborn.service;

import com.reborn.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User getUserById(int id);
    User findUserById2(int id);
    User getUser(User user);
    List<User> getAllUsers();
}
