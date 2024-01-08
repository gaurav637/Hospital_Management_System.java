USE Hospital;

CREATE TABLE Patient(
  Id INT PRIMARY KEY,
  Name VARCHAR(100),
  Email VARCHAR(50),
  Address VARCHAR(100),
  Room INT,
  Disease VARCHAR(100),
  Gender VARCHAR(50),
  Age INT
);

INSERT INTO Patient
(Id,Name,Email,Address,Room,Disease,Gender,Age)
VALUES
(1,"ayush","ayush@gmail.com","BSF chowk",10,"cold","male",20),
(2,"deepansh","deepansh@gmail.com","kabir nagar",11,"physiological","mail",22),
(3,"kashish","kashish@gmail.com","rcf",12,"skin infection","femail",21),
(4,"pankaj","pankaj@gmail.com","purola",13,"cancer","male",30),
(5,"Kuli","kuli@gmail.com","hudoli",14,"cold","male",23),
(6,"samya","samya@gmail.com","barkot",15,"malaria","femail",25),
(7,"ravi","ravi@gmail.com","uk",18,"sugar","mail",26);

SELECT * FROM Patient;
