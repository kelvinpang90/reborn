package com.reborn.service.Impl;

import com.reborn.entity.ShoppingCartItem;
import com.reborn.mapper.ShoppingCartItemMapper;
import com.reborn.service.ShoppingCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("shoppingCartItemService")
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
    @Autowired
    ShoppingCartItemMapper shoppingCartItemMapper;
    @Override
    public void add(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemMapper.addShoppingCartItem(shoppingCartItem);
    }

    @Override
    public void delete(int id) {
        shoppingCartItemMapper.deleteShoppingCartItem(id);
    }

    @Override
    public void update(ShoppingCartItem shoppingCartItem) {
        shoppingCartItemMapper.updateShoppingCartItem(shoppingCartItem);
    }

    @Override
    public ShoppingCartItem getById(int id) {
        return shoppingCartItemMapper.findShoppingCartItemsById(id);
    }

    @Override
    public List<ShoppingCartItem> getByCartId(int cartId) {
        return shoppingCartItemMapper.findShoppingCartItemsByCartId(cartId);
    }
}
