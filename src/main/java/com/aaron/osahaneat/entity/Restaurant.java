package com.aaron.osahaneat.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "title", columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;

    @Column(name = "subtitle", columnDefinition = "VARCHAR(255)")
    private String subTitle;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "is_freeship", columnDefinition = "BOOLEAN")
    private boolean isFreeship;

    @Column(name = "address", columnDefinition = "VARCHAR(150)")
    private String address;

    @Column(name = "open_date", columnDefinition = "DATETIME")
    private LocalDateTime openDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<RatingRestaurant> ratingRestaurants;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<MenuRestaurant> menuRestaurants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Promotion> promotions;

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<RatingRestaurant> getRatingRestaurants() {
        return ratingRestaurants;
    }

    public void setRatingRestaurants(List<RatingRestaurant> ratingRestaurants) {
        this.ratingRestaurants = ratingRestaurants;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<MenuRestaurant> getMenuRestaurants() {
        return menuRestaurants;
    }

    public void setMenuRestaurants(List<MenuRestaurant> menuRestaurants) {
        this.menuRestaurants = menuRestaurants;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

}
