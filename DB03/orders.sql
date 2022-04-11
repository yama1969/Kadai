INSERT INTO orders(no, orderdate, itemCode, quantity, sei, mei, pref, address, tel, mail)
    VALUES(1,'2022/5/18 13:35:22', 'P001', 1, '鈴木', '宏', '宮城県', '仙台市青葉区', '022-222-2222', null);
INSERT INTO orders(no, orderdate, itemCode, quantity, sei, mei, pref, address, tel, mail)
    VALUES(2,'2022/5/19 10:18:43', 'P003', 2, '木田', '幸治', '宮城県', '仙台市太白区', '022-333-3333', 'kida@test.com');
INSERT INTO orders(no, orderdate, itemCode, quantity, sei, mei, pref, address, tel, mail)
    VALUES(3,'2022/5/21 18:26:06', 'P003', 1, '田村', '康', '宮城県', '仙台市若林区', '022-444-4444', null);

SELECT no AS 注文番号,
    orderdate AS 注文日時,
    itemCode AS 商品コード,
    items.name AS 商品名,
    items.price AS 単価,
    quantity AS 数量,
    items.price * quantity AS 金額,
    CONCAT(sei, mei) AS 氏名,
    CONCAT(pref, address) AS 住所,
    tel AS 電話番号,
    mail AS メールアドレス
 FROM orders INNER JOIN items ON orders.itemCode = items.code
 WHERE no = 1;

SELECT no AS 注文番号,
    orderdate AS 注文日時,
    itemCode AS 商品コード,
    items.name AS 商品名,
    items.price AS 単価,
    quantity AS 数量,
    items.price * quantity AS 金額,
    CONCAT(sei, mei) AS 氏名,
    CONCAT(pref, address) AS 住所,
    tel AS 電話番号,
    mail AS メールアドレス
 FROM orders INNER JOIN items ON orders.itemCode = items.code
 WHERE orderdate BETWEEN STR_TO_DATE('2022/5/18 0:0:0','%Y/%m/%d %H:%i:%s') AND STR_TO_DATE('2022/5/20 23:59:59','%Y/%m/%d %H:%i:%s')
 ORDER BY no;

 SELECT no AS 注文番号,
    orderdate AS 注文日時,
    itemCode AS 商品コード,
    items.name AS 商品名,
    items.price AS 単価,
    quantity AS 数量,
    items.price * quantity AS 金額,
    CONCAT(sei, mei) AS 氏名,
    CONCAT(pref, address) AS 住所,
    tel AS 電話番号,
    mail AS メールアドレス
 FROM orders INNER JOIN items ON orders.itemCode = items.code
 WHERE CONCAT(sei, mei) LIKE '%田%'
 ORDER BY no;

SELECT no AS 注文番号,
    orderdate AS 注文日時,
    itemCode AS 商品コード,
    items.name AS 商品名,
    items.price AS 単価,
    quantity AS 数量,
    items.price * quantity AS 金額,
    CONCAT(sei, mei) AS 氏名,
    CONCAT(pref, address) AS 住所,
    tel AS 電話番号,
    mail AS メールアドレス
 FROM orders INNER JOIN items ON orders.itemCode = items.code
 WHERE tel='022-444-4444';
 
