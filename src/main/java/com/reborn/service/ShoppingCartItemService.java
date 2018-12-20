package com.reborn.service;

import com.reborn.entity.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemService {
    void add(ShoppingCartItem shoppingCartItem);
    void delete(int id);
    void update(ShoppingCartItem shoppingCartItem);
    ShoppingCartItem getById(int id);
    List<ShoppingCartItem> getByCartId(int cartId);
}
