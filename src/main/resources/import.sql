INSERT INTO tb_seller(name) VALUES ('Anakin');
INSERT INTO tb_seller(name) VALUES ('Logan');
INSERT INTO tb_seller(name) VALUES ('Loki Odinson');
INSERT INTO tb_seller(name) VALUES ('Padme');
INSERT INTO tb_seller(name) VALUES ('Thor Odinson');

INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (1, 0, 0, 50000.0, '2022-01-10');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (2, 0, 0, 40000.0, '2022-02-12');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (4, 0, 0, 60000.0, '2022-03-15');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (5, 0, 0, 50000.0, '2022-01-20');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (3, 0, 0, 60000.0, '2022-02-05');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (1, 0, 0, 60571.0, '2022-06-17');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (2, 0, 0, 43587.0, '2022-04-08');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (4, 0, 0, 75902.0, '2022-06-30');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (3, 0, 0, 19476.0, '2022-05-22');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (5, 0, 0, 20530.0, '2022-05-18');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (5, 0, 0, 74366.0, '2022-06-01');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (3, 0, 0, 21753.0, '2022-05-06');
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (3, 0, 0, 49368.0, '2022-06-10');

-- Seed dinamico para os cenarios sem parametros (ultimos 12 meses)
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (1, 0, 0, 12000.0, DATEADD('DAY', -15, CURRENT_DATE));
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (3, 0, 0, 18500.0, DATEADD('DAY', -45, CURRENT_DATE));
INSERT INTO tb_sales(seller_id, visited, deals, amount, date) VALUES (5, 0, 0, 9800.0, DATEADD('DAY', -120, CURRENT_DATE));

