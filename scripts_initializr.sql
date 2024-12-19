CREATE DATABASE osahaneat;
USE osahaneat;

CREATE TABLE roles (
	role_id INT auto_increment PRIMARY KEY,
    role_name VARCHAR(20),
    create_date DATETIME
);

CREATE TABLE users (
	user_id INT auto_increment PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(255),
    fullname VARCHAR(50),
    create_date DATETIME,
    role_id INT,
	FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

CREATE TABLE rating_foods (
	ratingfood_id INT auto_increment PRIMARY KEY,
    user_id INT,
    food_id INT,
    content VARCHAR(200),
    rate_point INT(5)
);

CREATE TABLE categories (
	category_id INT auto_increment PRIMARY KEY,
    category_name VARCHAR(30) NOT NULL,
    create_date DATETIME
);

CREATE TABLE foods (
	food_id INT auto_increment PRIMARY KEY,
    title VARCHAR(50),
    image TEXT,
    time_ship VARCHAR(10),
    price DECIMAL(10,2),
    category_id INT
);

CREATE TABLE rating_restaurants (
	ratingrestaurant_id INT auto_increment PRIMARY KEY,
	user_id INT,
    restaurant_id INT,
    content VARCHAR(200),
    rate_point INT(5)
);

CREATE TABLE orders (
	order_id INT auto_increment PRIMARY KEY,
    user_id INT,
    restaurant_id INT,
    create_date DATETIME
);

CREATE TABLE menu_restaurants (
	category_id INT,
    restaurant_id INT,
    create_date DATETIME,
    
    PRIMARY KEY(category_id, restaurant_id)
);

CREATE TABLE restaurants (
	restaurant_id INT auto_increment PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    subtitle VARCHAR(255),
    description TEXT,
    image TEXT,
    is_freeship BOOLEAN,
    address VARCHAR(150),
    open_date DATETIME
);

CREATE TABLE promotions (
	promotion_id INT auto_increment PRIMARY KEY,
    restaurant_id INT,
    percent DECIMAL(4,2),
    start_date DATE,
    end_date DATE
);

CREATE TABLE order_details (
	order_id INT,
    food_id INT,
    create_date DATETIME,
    
    PRIMARY KEY(order_id, food_id)
);

ALTER TABLE users
ADD CONSTRAINT FOREIGN KEY(role_id) REFERENCES roles(role_id);

ALTER TABLE rating_foods
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE rating_foods
ADD CONSTRAINT FOREIGN KEY(food_id) REFERENCES foods(food_id);

ALTER TABLE foods
ADD CONSTRAINT FOREIGN KEY(category_id) REFERENCES categories(category_id);

ALTER TABLE rating_restaurants
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE rating_restaurants
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES restaurants(restaurant_id);

ALTER TABLE orders
ADD CONSTRAINT FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE orders
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES restaurants(restaurant_id);

ALTER TABLE order_details
ADD CONSTRAINT FOREIGN KEY(order_id) REFERENCES orders(order_id);
ALTER TABLE order_details
ADD CONSTRAINT FOREIGN KEY(food_id) REFERENCES foods(food_id);

ALTER TABLE menu_restaurants
ADD CONSTRAINT FOREIGN KEY(category_id) REFERENCES categories(category_id);
ALTER TABLE menu_restaurants
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES restaurants(restaurant_id);

ALTER TABLE promotions
ADD CONSTRAINT FOREIGN KEY(restaurant_id) REFERENCES restaurants(restaurant_id);

ALTER TABLE users
ALTER COLUMN role_id set default 3;

INSERT INTO roles(role_name,create_date)
VALUES	('ROLE_ADMIN', NOW()),
		('ROLE_GUEST', NOW()),
        ('ROLE_USER', NOW());
        
SELECT * FROM roles;

INSERT INTO users(user_name,password,fullname,create_date,role_id)
VALUES ('test1','123456','Nguyen Van Test1', NOW(),3);
INSERT INTO users(user_name,password,fullname,create_date,role_id)
VALUES ('test2','123456','Nguyen Van Test2', NOW(),3);
INSERT INTO users(user_name,password,fullname,create_date)
VALUES ('test3@gmail.com','123456','Nguyen Van Test3', NOW());

SELECT * FROM users;


