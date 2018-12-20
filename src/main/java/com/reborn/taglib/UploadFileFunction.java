package com.reborn.taglib;

import com.reborn.entity.UploadFile;
import com.reborn.tool.Engine;

import java.util.List;

public class UploadFileFunction {
    public static List<UploadFile> getAll(){
        return Engine.uploadFileService.getAll();
    }
}
