package com.reborn.service.Impl;

import com.reborn.entity.UploadFile;
import com.reborn.mapper.UploadFileMapper;
import com.reborn.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("uploadFileService")
public class UploadFileServiceImpl implements UploadFileService {
    @Resource
    private UploadFileMapper uploadFileMapper;
    @Override
    public void add(UploadFile uploadFile) {
        uploadFileMapper.add(uploadFile);
    }

    @Override
    public void deleteById(int id) {
        uploadFileMapper.deleteById(id);
    }

    @Override
    public UploadFile getById(int id) {
        return uploadFileMapper.getById(id);
    }

    @Override
    public List<UploadFile> getAll() {
        return uploadFileMapper.getAll();
    }

    @Override
    public List<UploadFile> getByType(String type) {
        return uploadFileMapper.getByType(type);
    }
}
