#Lab5
USE RESTAURANT;
#Creating table Food_Items
CREATE TABLE Food_Items (
    ID int,
    FoodName varchar(255),
    Description varchar(255),
    Price float
    
);
#Creating Orders
CREATE TABLE Orders (
    ID int,
    CustomerName varchar(255),
    Created datetime
);

#Creating Order foods table
CREATE TABLE OrderFoods (
    OrderID int,
    FoodId int,
    Quantity int
    
);
#Creating the shopping cart table
CREATE TABLE Shopping_cart (
    ID int,
    CustomerName varchar(255),
    FoodID int,
    Quantity int
    
);
#Inserting values into the table food items
INSERT INTO Food_Items(ID, FoodName, Description,Price)
VALUES (1, 'Hamburger', 'A Hamburger', 9.99 ),
(2, 'Fries', 'Some Fries', 4.99 ),
(3, 'Coke', 'Coke Cola', 2.99 );

#Inserting values into the table orders
INSERT INTO Orders(ID, CustomerName, Created)
VALUES (1, 'Eric', now()),
(2, 'John', now()),
(3, 'Jane', now()),
(4, 'Alice', now());

#Inserting values into the table order foods
INSERT INTO OrderFoods(OrderID, FoodId, Quantity)
VALUES (1, 1, 1),
(1, 2, 2),
(2, 2,2),
(2,3,1),
(3, 3, 1),
(4, 2, 1),
(4, 3, 2);

#Inserting values into the table shopping-cart
INSERT INTO Shopping_cart(ID, CustomerName, FoodID,Quantity)
VALUES (1, 'Anonymous', 1, 2 ),
(1, 'Anonymous', 2, 1 ),
(1, 'Anonymous', 2, 1 ),
(2, 'Mike', 1, 1 ),
(2, 'Mike', 2, 1 ),
(3, 'Bob', 3, 1 );

#all the select statements for all the tables.
SELECT * FROM Food_Items;
SELECT * FROM Orders;
SELECT * FROM OrderFoods;
SELECT * FROM Shopping_cart;

#Update food item name from "Hamburger" to "Salad"
UPDATE Food_Items
SET FoodName = 'Salad'
WHERE id = 1;

#Find out which food item has the most orders
SELECT orderfoods.FoodId,
COUNT(orderfoods.foodid) AS 'Frequency',food_items.foodname 
FROM orderfoods  INNER JOIN food_items
ON orderfoods.FoodId=food_items.ID
GROUP BY FoodId DESC LIMIT 2;

#Find out which food item in least shopping carts
SELECT shopping_cart.foodid,
COUNT(shopping_cart.foodid) AS 'Frequency' ,food_items.foodname
FROM shopping_cart INNER JOIN food_items
ON shopping_cart.FoodID=FOOD_ITEMS.id
GROUP BY(foodid) 
ORDER BY COUNT(foodid)   LIMIT 1;

#Find out all restaurant food items using SELECT query
SELECT * FROM food_items;

#Find out all restaurant order statuses using SELECT query
SELECT * FROM orders;



#Find out the order statuses that is created today
SELECT * FROM orders
WHERE DATE(Created)=DATE(NOW());

#DELETE restaurant food items table
DROP TABLE food_items;

#Delete restaurant order statuses table
DROP TABLE orders;

#Delete restaurant cart table
DROP TABLE shopping_cart;








