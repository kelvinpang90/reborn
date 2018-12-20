package com.reborn.mapper;

import com.reborn.entity.Product;

import java.util.List;

public interface ProductMapper {
    void addProduct(Product product);
    void updateProductBySet(Product product);
    void deleteProduct(int id);
    Product findProductById(int id);
    List<Product> findProductByName(String name);
    List<Product> findProductByIds(List<Integer> ids);
}
