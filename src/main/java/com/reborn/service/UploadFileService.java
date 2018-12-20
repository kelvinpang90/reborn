package com.reborn.service;

import com.reborn.entity.UploadFile;

import java.util.List;

public interface UploadFileService {
    void add(UploadFile uploadFile);
    void deleteById(int id);
    UploadFile getById(int id);
    List<UploadFile> getAll();
    List<UploadFile> getByType(String type);
}
