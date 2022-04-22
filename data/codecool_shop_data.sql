---
--- drop tables
---

-- DROP TABLE IF EXISTS product CASCADE;
-- DROP TABLE IF EXISTS product_category CASCADE;
-- DROP TABLE IF EXISTS product_supplier CASCADE;
-- DROP TABLE IF EXISTS supplier CASCADE;

---
--- create tables
---

-- CREATE TABLE supplier (
--     supplier_id SERIAL PRIMARY KEY,
--     description VARCHAR (255) NOT NULL,
--     supplier_name VARCHAR (255) UNIQUE NOT NULL
-- );
--
-- CREATE TABLE product_category (
--     product_category_id SERIAL PRIMARY KEY,
--     product_category_name VARCHAR (50) UNIQUE NOT NULL,
--     department VARCHAR (50) NOT NULL,
--     description VARCHAR (500) NOT NULL
-- );
--
-- CREATE TABLE product (
--     product_id SERIAL PRIMARY KEY,
--     product_name VARCHAR (50) UNIQUE NOT NULL,
--     default_price VARCHAR (50) NOT NULL,
--     currency VARCHAR (3) NOT NULL,
--     description VARCHAR (500) NOT NULL,
--     supplier_name VARCHAR (50) UNIQUE NOT NULL,
--     product_category_name VARCHAR (50) UNIQUE NOT NULL,
--     FOREIGN KEY (supplier_name) REFERENCES supplier(supplier_name),
--     FOREIGN KEY (product_category_name) REFERENCES product_category(product_category_name)
-- );
--
-- CREATE TABLE shop_user (
--     shop_user_id SERIAL PRIMARY KEY,
--     shop_user_name VARCHAR (50) NOT NULL,
--     shop_user_email VARCHAR (50) UNIQUE NOT NULL,
--     shop_user_password VARCHAR (50) NOT NULL
-- );
--
-- CREATE TABLE basket (
--     basket_id SERIAL PRIMARY KEY,
--     product_id INTEGER,
--     shop_user_id INTEGER,
--     FOREIGN KEY (product_id) REFERENCES product(product_id),
--     FOREIGN KEY (shop_user_id) REFERENCES shop_user(shop_user_id)
-- );
--
-- ---
-- --- insert data
-- ---

INSERT INTO supplier(description, supplier_name) VALUES ('Designs, manufactures and markets smartphones', 'Apple');
INSERT INTO supplier(description, supplier_name) VALUES ('Leading personal technology companies, producing tablets', 'Lenovo');
INSERT INTO supplier(description, supplier_name) VALUES ('One of the largest tech companies in the world', 'Dell');
INSERT INTO supplier(description, supplier_name) VALUES ('The company''s products are GPS receivers and wearables', 'Garmin');

INSERT INTO product_category(name) VALUES ('Phone');
INSERT INTO product_category(name) VALUES ('Tablet');
INSERT INTO product_category(name) VALUES ('Laptop');
INSERT INTO product_category(name) VALUES ('Watch');

INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 549.9, 'Advanced 12MP dual camera system with ultra wide angle and wide angle lens', 'iPhone 13', 1, 1);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 319.9, 'The A15 Bionic iPhone does almost everything better. Apps work like a dream', 'iPhone SE', 1, 1);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 299.2, 'Watch HDR movies and shows on Super Retina XDR, the brightest iPhone  ever', 'iPhone 11 Pro', 1, 1);

INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 322.9, 'Faster, more responsive 6.1-inch Super Retina XDR with ProMotion technology', 'Redmi Note 11', 2, 2);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 302.1, 'Support for efficient 30 W chargers allows you to quickly accumulate energy', 'Lenovo Yoga Tab 13', 2, 2);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 122.9, 'Lenovo TAB P11 is a tablet with an 11-inch matrix with the best 2K resolution', 'Lenovo Tab P11', 2, 2);

INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 1224.8, 'The display has a resolution of 3K, a contrast ratio of 1000: 1, sRGB color', 'Dell XPS', 3, 3);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 1001.3, 'A mobile processor will provide computing power to perform every tasks', 'Dell Vostro 7510', 3, 3);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 2424.8, 'The 16-inch Inspiron 7000 series is a versatile, laptop for every users', 'Dell Inspiron 16', 3, 3);

INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 104.2, 'The watch meets US military standards for temperature, water resistance', 'Garmin Fenix 6X Pro', 4, 4);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 95.2, 'Venu 2 watch is equipped with advanced health monitoring functions', 'Garmin Venu 2', 4, 4);
INSERT INTO product(currency, default_price, description, product_name, product_category_id, supplier_supplier_id) VALUES ('USD', 73.5, 'Supports global navigation satellite systems such as GPS and Galileo', 'Garmin Instinct', 4, 4);

-- INSERT INTO product_supplier(description, supplier_name) VALUES ('Apple', 'Designs, manufactures and markets smartphones');
-- INSERT INTO product_supplier(description, supplier_name) VALUES ('Lenovo', 'Leading personal technology companies, producing tablets');
-- INSERT INTO product_supplier(description, supplier_name) VALUES ('Dell', 'One of the largest tech companies in the world');