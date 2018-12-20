package com.reborn.entity;

import org.apache.ibatis.type.Alias;

@Alias("shopping_cart_item")
public class ShoppingCartItem {
    private int id;
    private Product product;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
