package com.reborn.service.Impl;

import com.reborn.entity.User;
import com.reborn.mapper.UserMapper;
import com.reborn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private JdbcTemplate mysqlJdbcTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserById2(int id) {
        return userMapper.findUserById2(id);
    }

    @Override
    public User getUser(User user) {
        return userMapper.findUserByNameAndPassword(user.getLoginName(),user.getPassword());
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
