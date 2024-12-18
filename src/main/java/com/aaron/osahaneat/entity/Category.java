package com.aaron.osahaneat.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name", columnDefinition = "VARCHAR(30) NOT NULL")
    private String categoryName;

    @Column(name = "create_date", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<Food> foods;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private List<MenuRestaurant> menuRestaurants;

    public List<MenuRestaurant> getMenuRestaurants() {
        return menuRestaurants;
    }

    public void setMenuRestaurants(List<MenuRestaurant> menuRestaurants) {
        this.menuRestaurants = menuRestaurants;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}
