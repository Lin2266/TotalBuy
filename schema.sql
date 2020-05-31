-- 資料流totalbuy資料庫名
 CREATE DATABASE IF NOT EXISTS totalbuy
     DEFAULT CHARACTER SET=utf8;
 COMMIT;

USE totalbuy;
-- foreigen keys刪除有順序，要先從3.order_itmes,2.orders,在1.customers,1.products(重建用)
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;
COMMIT;

CREATE TABLE  customers (
  id char(10) NOT NULL,
  name varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  gender char(1) NOT NULL DEFAULT 'M',
  email varchar(40) NOT NULL,
  birth_date date DEFAULT NULL,
  address varchar(120) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  married tinyint(1) NOT NULL DEFAULT '0',
  blood_Type varchar(2) DEFAULT NULL,
  status int(2) NOT NULL DEFAULT '0',
  discount int(2) NOT NULL DEFAULT '0',
  type varchar(20) NOT NULL DEFAULT 'Customer',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

INSERT INTO customers
(id, name, password, gender, email)VALUES('A123456789', '喬治','123456','M','a123@yahoo.com');

INSERT INTO customers
(id, name, password, gender, email, birth_date, address, phone, married, blood_type, status, discount, type)
VALUES('A246810111','馬莉','654321','F','A1234@yahoo.com', '2000-1-1',
    '台北市復興北路99號', '02225149191',false,'AB',1,15,'VIP');
COMMIT;

SELECT * FROM customers;


CREATE TABLE  products (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  unit_price double NOT NULL DEFAULT '0',
  free tinyint(1) NOT NULL DEFAULT '0',
  stock int(6) unsigned NOT NULL DEFAULT '0',
  description varchar(150) DEFAULT NULL,
  url varchar(100) DEFAULT NULL,
  status int(2) unsigned NOT NULL DEFAULT '1',
  discount int(2) unsigned NOT NULL DEFAULT '0',
  type varchar(15) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;

TRUNCATE TABLE products;

INSERT INTO products (name, unit_price, free, stock,url)
VALUES('App Watch1', 770, false, 50,'watch-Sport.png');
INSERT INTO products (name, unit_price, free, stock, url, description)
VALUES('App Watch2', 770, false, 50,'watch-Pink.png','可拍照,上網');
INSERT INTO products (name, unit_price, free, stock, url, description)
VALUES('App Watch3', 770, false, 50,'watch-Milanese.png','可拍照,上網');
INSERT INTO products (name, unit_price, free, stock, url, description)
VALUES('App Watch4', 770, false, 50,'watch-Green.png','可拍照,上網');
INSERT INTO products (name, unit_price, free, stock, url, description)
VALUES('App Watch5', 770, false, 50,'watch-Blue.png','可拍照,上網');
INSERT INTO products (name, unit_price, free, stock, url, description)
VALUES('App Watch6', 770, false, 50,'watch-Black.png','可拍照,上網');


CREATE TABLE  orders (
  customer_id char(10) NOT NULL,
  order_time datetime NOT NULL,
  id int(2) unsigned NOT NULL AUTO_INCREMENT,
  payment_type int(2) unsigned NOT NULL,
  payment_amount double DEFAULT '0',
  payment_note varchar(40) DEFAULT NULL,
  shipping_type int(2) unsigned NOT NULL,
  shipping_amount double DEFAULT '0',
  shipping_note varchar(40) DEFAULT NULL,
  receiver_name varchar(20) NOT NULL,
  receiver_email varchar(40) NOT NULL,
  receiver_phone varchar(20) NOT NULL,
  shipping_address varchar(120) NOT NULL,
  status int(2) unsigned NOT NULL DEFAULT '0',
  bad_status int(2) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  FOREIGN KEY FK_orders_customers (customer_id)
    REFERENCES customers (id)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
commit;

CREATE TABLE  order_items (
  order_id int(10) unsigned NOT NULL,
  product_id int(10) unsigned NOT NULL,
  quantity int(3) unsigned NOT NULL,
  price double NOT NULL,
  free tinyint(1) DEFAULT '0',
  PRIMARY KEY (order_id,product_id),
  KEY FK_order_items_products (product_id),
  CONSTRAINT FK_order_items_orders FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT FK_order_items_products FOREIGN KEY (product_id) REFERENCES products (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
commit;

