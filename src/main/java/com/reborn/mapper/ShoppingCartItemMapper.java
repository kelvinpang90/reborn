package com.reborn.mapper;

import com.reborn.entity.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemMapper {
    void addShoppingCartItem(ShoppingCartItem shoppingCartItem);
    void updateShoppingCartItem(ShoppingCartItem shoppingCartItem);
    void deleteShoppingCartItem(int id);
    ShoppingCartItem findShoppingCartItemsById(int id);
    List<ShoppingCartItem> findShoppingCartItemsByCartId(int shoppingCartId);
}
