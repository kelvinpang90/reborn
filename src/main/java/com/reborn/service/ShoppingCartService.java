package com.reborn.service;

import com.reborn.entity.ShoppingCart;

public interface ShoppingCartService {
    void add(ShoppingCart shoppingCart);
    void delete(int id);
    void update(ShoppingCart shoppingCart);
    ShoppingCart getById(int id);
}
