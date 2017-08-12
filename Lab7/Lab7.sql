CREATE TABLE foodmenu (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    imgURL TEXT,
    price DOUBLE
);

CREATE TABLE orders (
	order_id INTEGER AUTO_INCREMENT PRIMARY KEY,
	customer_name VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	order_time TIMESTAMP NOT NULL
);


CREATE TABLE order_foods (
	order_foods_id INTEGER NOT NULL REFERENCES orders(orders_id),
	menu_id INTEGER NOT NULL REFERENCES menu(id)
	
);


INSERT INTO foodmenu (id, name, description, imgURL, price) VALUES
(1, "Pizza", "Yummy", "https://thumbs.dreamstime.com/z/pepperoni-pizza-thinly-sliced-popular-topping-american-style-pizzerias-30402134.jpg", 6.99),
(2, "Hamburger", "Delicious", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Big_Mac_hamburger.jpg/220px-Big_Mac_hamburger.jpg", 6.99),
(3, "Pancakes", "Mouth-Watering", "https://static01.nyt.com/images/2017/03/24/dining/24COOKING-CLASSICPANCAKES/24COOKING-CLASSICPANCAKES-videoSixteenByNineJumbo1600.jpg", 5.99);


INSERT INTO orders (order_id, customer_name, status, order_time) VALUES
(1, "Eric", "IN PROGRESS", NOW()),
(2, "Charu", "IN QUEUE", NOW());


INSERT INTO order_foods (order_foods_id, menu_id) VALUES 
(1, 2),
(1, 3),
(2, 2);