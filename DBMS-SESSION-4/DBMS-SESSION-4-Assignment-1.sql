-- Assignment # 1

-- Query#1 : Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION No_Of_Orders(month INT, YEAR INT)
RETURNS INT
DETERMINISTIC
    BEGIN
        DECLARE number INT;
        SELECT COUNT(order_id) INTO number
        FROM orders 
        WHERE MONTH(order_timestamp) = month
        AND YEAR(order_timestamp) = year;
        RETURN(number);
    END $$
DELIMITER ;

-- Using Function No_Of_Orders.
SELECT  No_Of_Orders(8,2019);

-- Query#2 : Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION Max_Order_Month(year INT)
RETURNS INT
DETERMINISTIC
    BEGIN
        DECLARE month INT;
        SELECT MONTH(order_timestamp) INTO month
        FROM orders
        WHERE YEAR(order_timestamp) = year
        AND total_amount = (SELECT MAX(total_amount) FROM orders WHERE YEAR(order_timestamp) = YEAR);
        RETURN (month);
        END $$
DELIMITER ;

-- Using Function Max_Order_Month.
SELECT Max_Order_Month(2018);