CREATE TABLE FoodItems (
    ID int AUTO_INCREMENT PRIMARY KEY,
    FoodName varchar(255),
    ImageUrl varchar(500),
    Description varchar(255),
    Price float
    
);

INSERT INTO FoodItems(ID, FoodName,ImageUrl, Description,Price)
VALUES (1, 'Hamburger','https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Big_Mac_hamburger.jpg/220px-Big_Mac_hamburger.jpg', 'A Hamburger', 9.99 ),
(2, 'Fries','https://i.ytimg.com/vi/ETTyVQrUZt8/maxresdefault.jpg', 'Some Fries', 4.99 ),
(3, 'Coke','http://www.lipsmacker.com/media/catalog/product/cache/1/flavor_image/9df78eab33525d08d6e5fb8d27136e95/c/o/coke-ro_13.jpg', 'Coke Cola', 2.99 );

SELECT * FROM 
FoodItems;

UPDATE FoodItems set Description='Fluffy pancakes made with buttermilk'
WHERE ID=4;







