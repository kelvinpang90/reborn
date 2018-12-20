package com.reborn.tool;

import com.reborn.service.UploadFileService;
import com.reborn.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class Engine {
    public static UserService userService;
    public static UploadFileService uploadFileService;

    public void setUserService(UserService userService) {
        Engine.userService = userService;
    }

    public void setUploadFileService(UploadFileService uploadFileService) {
        Engine.uploadFileService = uploadFileService;
    }
}
