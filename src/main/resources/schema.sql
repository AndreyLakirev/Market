DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS purchases;

CREATE TABLE products
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    status VARCHAR(40) NOT NULL,
    material VARCHAR(40) NOT NULL,
    weight int NOT NULL,
    cost int NOT NULL
);

CREATE TABLE employees
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    surname VARCHAR(40) NOT NULL,
    status VARCHAR (40) NOT NULL
);

CREATE TABLE customers
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    surname VARCHAR(40) NOT NULL
);

CREATE TABLE purchases
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    datetime TIMESTAMP NOT NULL,
    productID INT NOT NULL,
    customerID INT NOT NULL,
    employeeID INT NOT NULL
);