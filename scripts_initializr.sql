CREATE DATABASE osahaneat;
USE osahaneat;

CREATE TABLE Roles (
	role_id INT auto_increment PRIMARY KEY,
    role_name VARCHAR(20),
    create_date DATETIME
);

CREATE TABLE Users (
	user_id INT auto_increment PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(255),
    fullname VARCHAR(50),
    create_date DATETIME,
    role_id INT,
	FOREIGN KEY(role_id) REFERENCES Roles(role_id)
);

CREATE TABLE RatingFoods (
	ratingfood_id INT auto_increment PRIMARY KEY,
    user_id INT,
    food_id INT,
    content VARCHAR(200),
    rate_point INT(5)
);

CREATE TABLE Categories (
	category_id INT auto_increment PRIMARY KEY,
    category_name VARCHAR(30) NOT NULL,
    create_date DATETIME
);

CREATE TABLE Foods (
	food_id INT auto_increment PRIMARY KEY,
    title VARCHAR(50),
    image TEXT,
    time_ship VARCHAR(10),
    price DECIMAL(10,2),
    category_id INT
);

CREATE TABLE RatingRestaurants (
	ratingrestaurant_id INT auto_increment PRIMARY KEY,
	user_id INT,
    restaurant_id INT,
    content VARCHAR(200),
    rate_point INT(5)
);

CREATE TABLE Orders (
	order_id INT auto_increment PRIMARY KEY,
    user_id INT,
    restaurant_id INT,
    create_date DATETIME
);

CREATE TABLE MenuRestaurants (
	category_id INT,
    restaurant_id INT,
    create_date DATETIME,
    
    PRIMARY KEY(category_id, restaurant_id)
);

CREATE TABLE Restaurants (
	restaurant_id INT auto_increment PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    subtitle VARCHAR(255),
    description TEXT,
    image TEXT,
    is_freeship BOOLEAN,
    address VARCHAR(150),
    open_date DATETIME
);

CREATE TABLE Promotions (
	promotion_id INT auto_increment PRIMARY KEY,
    restaurant_id INT,
    percent DECIMAL(4,2),
    start_date DATE,
    end_date DATE
);

CREATE TABLE OrderDetails (
	order_id INT,
    food_id INT,
    create_date DATETIME,
    
    PRIMARY KEY(order_id, food_id)
);

ALTER TABLE Users
ADD CONSTRAINT FOREIGN KEY(role_id) REFERENCES Roles(role_id);

ALTER TABLE RatingFoods
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES Users(user_id);
ALTER TABLE RatingFoods
ADD CONSTRAINT FOREIGN KEY(food_id) REFERENCES Foods(food_id);

ALTER TABLE Foods
ADD CONSTRAINT FOREIGN KEY(category_id) REFERENCES Categories(category_id);

ALTER TABLE RatingRestaurants
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES Users(user_id);
ALTER TABLE RatingRestaurants
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES Restaurants(restaurant_id);

ALTER TABLE Orders
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES Users(user_id);
ALTER TABLE Orders
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES Restaurants(restaurant_id);

ALTER TABLE OrderDetails
ADD CONSTRAINT FOREIGN KEY(order_id) REFERENCES Orders(order_id);
ALTER TABLE OrderDetails
ADD CONSTRAINT FOREIGN KEY(food_id) REFERENCES Foods(food_id);

ALTER TABLE MenuRestaurants
ADD CONSTRAINT FOREIGN KEY(category_id) REFERENCES Categories(category_id);
ALTER TABLE MenuRestaurants
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES Restaurants(restaurant_id);

ALTER TABLE Promotions
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES Restaurants(restaurant_id);



