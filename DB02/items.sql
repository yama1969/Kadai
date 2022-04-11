INSERT INTO items(code, name, price) VALUES('P001', '基礎からのJava', 2600);
INSERT INTO items(code, name, price) VALUES('P002', 'HTML&CSS JavaScriptのきほんのきほん', 2580);
INSERT INTO items(code, name, price) VALUES('P003', '基礎からのサーブレット/JSP', 2800);

SELECT code, name, price FROM items WHERE code='P002';

SELECT code, name, price FROM items WHERE name LIKE '%基礎%' ORDER BY code;
