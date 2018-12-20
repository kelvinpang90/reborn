package com.reborn.taglib;

import com.reborn.entity.User;
import com.reborn.tool.Engine;

import java.util.List;

public class UserFunction {
    public static List<User> getAllUsers(){
        return Engine.userService.getAllUsers();
    }
}
