package com.reborn.entity;

import org.apache.ibatis.type.Alias;

import java.util.Set;

@Alias("product")
public class Product {
    private int id;
    private String name;
    private float price;
    private int CategoryId;

    private int quantity;
    private String description;
    private String detail;
    private int star;
    private Set<ProductReview> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Set<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ProductReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", CategoryId=" + CategoryId +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", star=" + star +
                ", reviews=" + reviews +
                '}';
    }
}
