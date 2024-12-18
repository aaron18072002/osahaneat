package com.aaron.osahaneat.entity;

import com.aaron.osahaneat.entity.keys.KeyOrderDetail;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "OrderDetails")
public class OrderDetail {

    @EmbeddedId
    private KeyOrderDetail keyOrderDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "food_id", insertable = false, updatable = false)
    private Food food;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    public KeyOrderDetail getKeyOrderDetail() {
        return keyOrderDetail;
    }

    public void setKeyOrderDetail(KeyOrderDetail keyOrderDetail) {
        this.keyOrderDetail = keyOrderDetail;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}
