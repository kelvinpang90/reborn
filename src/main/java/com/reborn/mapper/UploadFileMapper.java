package com.reborn.mapper;

import com.reborn.entity.UploadFile;

import java.util.List;

public interface UploadFileMapper {
    void add(UploadFile uploadFile);
    UploadFile getById(int id);
    void deleteById(int id);
    List<UploadFile> getAll();
    List<UploadFile> getByType(String type);
}
