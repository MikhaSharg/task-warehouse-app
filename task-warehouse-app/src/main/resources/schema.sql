CREATE TABLE IF NOT EXISTS products
(	
	id SERIAL PRIMARY KEY,
	name varchar(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS pricies
(
	id SERIAL PRIMARY KEY, 
	price real NOT NULL,
	date_time date NOT NULL,
	product_id bigint NOT NULL,
	CONSTRAINT FK_pricies_products FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE OR REPLACE VIEW frequency_by_product AS
SELECT pro.id, pro.name, COUNT(*) AS frequency
FROM pricies pri  JOIN products pro ON pri.product_id = pro.id 
GROUP BY pro.id 
ORDER BY pro.id;

CREATE OR REPLACE VIEW frequency_by_date AS
SELECT date_time, COUNT(*) AS frequency 
FROM pricies   
GROUP BY date_time  
ORDER BY  date_time;