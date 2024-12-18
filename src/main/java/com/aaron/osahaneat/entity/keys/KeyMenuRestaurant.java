package com.aaron.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyMenuRestaurant implements Serializable {

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "restaurant_id")
    private int restaurantId;

    public KeyMenuRestaurant() {

    }

    public KeyMenuRestaurant(int categoryId, int restaurantId) {
        this.categoryId = categoryId;
        this.restaurantId = restaurantId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyMenuRestaurant that = (KeyMenuRestaurant) o;
        return categoryId == that.categoryId && restaurantId == that.restaurantId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, restaurantId);
    }


}
