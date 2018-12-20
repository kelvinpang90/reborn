package com.reborn.service.Impl;

import com.reborn.entity.Product;
import com.reborn.mapper.ProductMapper;
import com.reborn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public void add(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void delete(int id) {
        productMapper.deleteProduct(id);
    }

    @Override
    public void update(Product product) {
        productMapper.updateProductBySet(product);
    }

    @Override
    public Product getById(int id) {
        return productMapper.findProductById(id);
    }

    @Override
    public List<Product> getByName(String productName) {
        return productMapper.findProductByName(productName);
    }
}
