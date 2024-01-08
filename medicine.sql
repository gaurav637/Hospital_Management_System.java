USE Hospital;

CREATE TABLE medicine(
  medicine_id INT,
  medicine_name VARCHAR(50),
  manufacture TIMESTAMP,
  expire TIMESTAMP,
  quantity INT,
  price INT
);


INSERT INTO medicine
(medicine_id,medicine_name,manufacture,expire,quantity,price)
VALUES
(102,"paracetamol",'2022-12-20 12:30:00','2023-11-10 11:30:00',10,20),
(103,"Aspirin",'2022-09-10 10:30:00','2023-3-10 09:30:00',5,50),
(104,"penicillin",'2021-1-20 08:00:00','2022-11-10 11:30:00',15,15),
(105,"prozac",'2022-12-20 12:30:00','2023-11-10 11:30:00',10,60),
(106,"Lipitor",'2022-11-08 07:30:00','2023-11-10 01:30:00',10,120),
(107,"Insulin",'2021-12-20 12:30:00','2022-11-10 10:30:00',10,150),
(108,"Metoprolol",'2022-02-20 12:30:00','2023-08-10 11:30:00',10,80);

SELECT * FROM medicine;