package com.reborn.service;

import com.reborn.entity.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    Product getById(int id);
    List<Product> getByName(String productName);
}
