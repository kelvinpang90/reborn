package com.reborn.entity;


import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("shopping_cart")
public class ShoppingCart {
    private int id;
    private int count;
    private List<ShoppingCartItem> shoppingCartItemList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ShoppingCartItem> getShoppingCartItemList() {
        return shoppingCartItemList;
    }

    public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
        this.shoppingCartItemList = shoppingCartItemList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", count=" + count +
                ", shoppingCartItemList=" + shoppingCartItemList +
                '}';
    }
}
