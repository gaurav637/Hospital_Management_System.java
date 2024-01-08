USE Hospital;

CREATE TABLE birth_death(
  year INT PRIMARY KEY,
  birth INT,
  death INT
);

INSERT INTO birth_death
(year,birth,death)
VALUES
(2015,30,11),
(2016,26,6),
(2017,31,10),
(2018,12,1),
(2019,24,0),
(2020,28,2),
(2021,11,0),
(2022,27,6),
(2023,32,12);