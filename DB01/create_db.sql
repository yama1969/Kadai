CREATE DATABASE GoodsOrder
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE items(
    code CHAR(4) PRIMARY KEY,
    name VARCHAR(50),
    price INT
) DEFAULT CHARSET='utf8mb4';

CREATE TABLE orders(
    no INT PRIMARY KEY,
    orderdate DATETIME,
    itemCode CHAR(4) REFERENCES items(code),
    quantity INT,
    sei VARCHAR(50),
    mei VARCHAR(50),
    pref VARCHAR(4),
    address VARCHAR(200),
    tel VARCHAR(25),
    mail VARCHAR(250)
) DEFAULT CHARSET='utf8mb4';
