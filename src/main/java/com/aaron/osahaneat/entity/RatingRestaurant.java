package com.aaron.osahaneat.entity;

import jakarta.persistence.*;

@Entity(name = "RatingRestaurants")
public class RatingRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingrestaurant_id")
    private int ratingrestaurantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "content", columnDefinition = "VARCHAR(200)")
    private String content;

    @Column(name = "rate_point", columnDefinition = "INT(5)")
    private int ratePoint;

    public int getRatingrestaurantId() {
        return ratingrestaurantId;
    }

    public void setRatingrestaurantId(int ratingrestaurantId) {
        this.ratingrestaurantId = ratingrestaurantId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
