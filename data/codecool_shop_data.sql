---
--- drop tables
---

DROP TABLE IF EXISTS supplier CASCADE;
DROP TABLE IF EXISTS product_category CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS shop_user CASCADE;
DROP TABLE IF EXISTS basket CASCADE;

---
--- create tables
---

CREATE TABLE supplier (
    supplier_id SERIAL PRIMARY KEY,
    supplier_name VARCHAR (50) UNIQUE NOT NULL,
    description VARCHAR (500) NOT NULL
);

CREATE TABLE product_category (
    product_category_id SERIAL PRIMARY KEY,
    product_category_name VARCHAR (50) UNIQUE NOT NULL,
    department VARCHAR (50) NOT NULL,
    description VARCHAR (500) NOT NULL
);

CREATE TABLE product (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR (50) UNIQUE NOT NULL,
    default_price VARCHAR (50) NOT NULL,
    currency VARCHAR (3) NOT NULL,
    description VARCHAR (500) NOT NULL,
    supplier_id INTEGER,
    product_category_id INTEGER,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id),
    FOREIGN KEY (product_category_id) REFERENCES product_category(product_category_id)
);

CREATE TABLE shop_user (
    shop_user_id SERIAL PRIMARY KEY,
    shop_user_name VARCHAR (50) NOT NULL,
    shop_user_email VARCHAR (50) UNIQUE NOT NULL,
    shop_user_password VARCHAR (50) NOT NULL
);

CREATE TABLE basket (
    basket_id SERIAL PRIMARY KEY,
    product_id INTEGER,
    shop_user_id INTEGER,
    FOREIGN KEY (product_id) REFERENCES product(product_id),
    FOREIGN KEY (shop_user_id) REFERENCES shop_user(shop_user_id)
);

---
--- insert data
---

INSERT INTO supplier(supplier_name, description) VALUES ('Apple', 'Phone');
INSERT INTO supplier(supplier_name, description) VALUES ('Lenovo', 'Tablet');
INSERT INTO supplier(supplier_name, description) VALUES ('Dell', 'Laptop');

INSERT INTO product_category(product_category_name, department, description) VALUES ('Phone', 'Hardware', 'A connecting device for remotely transmitting voice to one another, yours or more devices');
INSERT INTO product_category(product_category_name, department, description) VALUES ('Tablet', 'Hardware', 'A thin, flat mobile computer with a touchscreen display');
INSERT INTO product_category(product_category_name, department, description) VALUES ('Laptop', 'Hardware', 'A kind of portable personal computer');

INSERT INTO product(product_name, default_price, currency, description, supplier_id, product_category_id) VALUES ('iPhone 13', '549.9', 'USD', 'Advanced 12MP dual camera system with ultra wide angle and wide angle lens', 1, 1);
INSERT INTO product(product_name, default_price, currency, description, supplier_id, product_category_id) VALUES ('Redmi Note 11', '322.9', 'USD', 'Faster, more responsive 6.1-inch Super Retina XDR display with ProMotion technology', 2, 2);
INSERT INTO product(product_name, default_price, currency, description, supplier_id, product_category_id) VALUES ('Dell XPS', '1224.8', 'USD', 'The display has a resolution of 3K, a contrast ratio of 1000: 1 and 100% sRGB color coverage', 3, 3);

INSERT INTO shop_user(shop_user_name, shop_user_email, shop_user_password) VALUES ('John', 'john_paul@wp.pl', '2137');
INSERT INTO shop_user(shop_user_name, shop_user_email, shop_user_password) VALUES ('Drake', 'drake@onet.pl', '1111');
INSERT INTO shop_user(shop_user_name, shop_user_email, shop_user_password) VALUES ('James', 'james_bond@gmail.pl', '007');