USE Hospital;

CREATE TABLE operation(
  year INT,
  total_operation INT,
  failed_operation INT,
  success_operation INT
);

INSERT INTO operation
(year,total_operation,failed_operation,success_operation)
VALUES
(2015,20,5,15),
(2016,25,2,23),
(2017,30,4,26),
(2018,15,1,14),
(2019,22,0,22),
(2020,20,1,19),
(2021,28,2,26),
(2022,35,3,32),
(2023,40,0,40);



SELECT * FROM operation;

SELECT year,failed_operation,success_operation,MAX(total_operation) FROM operation
GROUP BY year,failed_operation,success_operation;





