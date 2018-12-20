package com.reborn.service.Impl;

import com.reborn.entity.ShoppingCart;
import com.reborn.mapper.ShoppingCartMapper;
import com.reborn.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public void add(ShoppingCart shoppingCart) {
        shoppingCartMapper.addShoppingCart(shoppingCart);
    }

    @Override
    public void delete(int id) {
        shoppingCartMapper.deleteShoppingCart(id);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        shoppingCartMapper.updateShoppingCart(shoppingCart);
    }

    @Override
    public ShoppingCart getById(int id) {
        return shoppingCartMapper.findShoppingCartById(id);
    }
}
