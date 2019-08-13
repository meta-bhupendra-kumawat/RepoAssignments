
-- Creating table user.
CREATE TABLE User (
email_id VARCHAR(30) NOT NULL,
Name VARCHAR(30),
DOB DATE,
phn_no INT NOT NULL,
CONSTRAINT PK_user PRIMARY KEY(email_id)
);

-- Specialization of table user by creating table shopper.
CREATE TABLE shopper (
email_id VARCHAR(30) PRIMARY KEY REFERENCES user(user_id)
);

-- Specialization of table user by creating table administrator.
CREATE TABLE administrator (
email_id VARCHAR(30) PRIMARY KEY REFERENCES user(user_id)
);

-- Creating orders table.
CREATE TABLE orders (
Order_id INT PRIMARY KEY,
order_timestamp timestamp DEFAULT current_timestamp,
shopper_id Varchar(30),
price DECIMAL(5,2),
 FOREIGN KEY (shopper_id) REFERENCES shopper(email_id)
);
Alter table orders modify column price decimal(9, 2);

-- Creating table for storing images.
CREATE TABLE images (
image_id INT PRIMARY KEY,
P_id INT UNIQUE
);

-- Creating table for products.
CREATE TABLE products (
p_id INT PRIMARY KEY,
p_Name VARCHAR(30) NOT NULL,
p_Price DECIMAL(7,2),
image_id INT UNIQUE,
FOREIGN KEY(image_id) REFERENCES images(image_id)
);

-- Referencing the images from the product.
ALTER TABLE images ADD CONSTRAINT FOREIGN KEY(p_id) REFERENCES products(p_id);

-- Creating products table.
CREATE TABLE products_order (
po_id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT,
order_id INT,
itm_price decimal(9, 2) NOT NULL,
ordr_status Varchar(30) NOT NULL DEFAULT ("PENDING"),
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES products(p_id)
); 

-- Creating table categories.
CREATE TABLE categories (
c_id INT PRIMARY KEY,
category_Name VARCHAR(30) UNIQUE,
parent_category VARCHAR(30) DEFAULT("Top_category")
);

-- Creating sub-categories table.
CREATE TABLE sub_categories (
sub_category_id INT PRIMARY KEY AUTO_INCREMENT,
sub_category_name VARCHAR(30) NOT NULL UNIQUE,
parent_category_id INT REFERENCES categories(c_id)
);

-- Creating junction table products_categories.
CREATE TABLE products_categories (
pc_id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT UNIQUE NOT NULL REFERENCES products(product_id),
category_id INT UNIQUE NOT NULL REFERENCES categories(c_id)
);

-- Creating table shipping.
CREATE TABLE shipping_address (
address_id INT PRIMARY KEY AUTO_INCREMENT,
shopper_id INT NOT NULL UNIQUE REFERENCES shopper(email_id),
country VARCHAR(30) NOT NULL,
state VARCHAR(30) NOT NULL,
city VARCHAR(30) NOT NULL,
area VARCHAR(30) NOT NULL,
house_no INT NOT NULL
);

-- Show all tables in database.
SHOW TABLES;

-- To drop table products.
DROP TABLE products;