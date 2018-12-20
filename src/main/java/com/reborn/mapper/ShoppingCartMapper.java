package com.reborn.mapper;

import com.reborn.entity.ShoppingCart;

public interface ShoppingCartMapper {
    void addShoppingCart(ShoppingCart shoppingCart);
    void deleteShoppingCart(int id);
    void updateShoppingCart(ShoppingCart shoppingCart);
    ShoppingCart findShoppingCartById(int id);
}
