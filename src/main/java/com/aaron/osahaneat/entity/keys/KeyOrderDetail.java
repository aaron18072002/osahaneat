package com.aaron.osahaneat.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyOrderDetail implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "food_id")
    private int foodId;

    public KeyOrderDetail() {

    }

    public KeyOrderDetail(int orderId, int foodId) {
        this.orderId = orderId;
        this.foodId = foodId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyOrderDetail that = (KeyOrderDetail) o;
        return orderId == that.orderId && foodId == that.foodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, foodId);
    }

}
