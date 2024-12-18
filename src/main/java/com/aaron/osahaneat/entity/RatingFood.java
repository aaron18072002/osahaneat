package com.aaron.osahaneat.entity;

import jakarta.persistence.*;

@Entity(name = "rating_foods")
public class RatingFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingfood_id")
    private int ratingFoodId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(name = "content", columnDefinition = "VARCHAR(100)")
    private String content;

    @Column(name = "rate_point", columnDefinition = "INT(5)")
    private int ratePoint;

    public int getRatingFoodId() {
        return ratingFoodId;
    }

    public void setRatingFoodId(int ratingFoodId) {
        this.ratingFoodId = ratingFoodId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRatePoint() {
        return ratePoint;
    }

    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }

}
