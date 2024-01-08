USE Hospital;

CREATE TABLE Nurse(
  id INT PRIMARY KEY,
  Name VARCHAR(50),
  Email VARCHAR(50),
  Qualification VARCHAR(100),
  Salary INT,
  room INT,
  shift VARCHAR(50),
  Experience DOUBLE
);

INSERT INTO Nurse
(id,Name,Email,Qualification,Salary,room,shift,Experience)
VALUES
(1,"Ayesha Gupta","ayesha@gmail.com,","BSN",31000,6,"Day",1),
(2,"Rohan Sharma","rohan@gmail.com","RN","30000",10,"Night",3),
(3,"Ankit patel","ankit@gmail.com","RN","35000",12,"Day",5),
(4,"Nisha Varma","nisha@gmail.com","BSN,MSN","40000",7,"Night",2),
(5,"Diya Joshi","diya@gmail.com","RN","25000",11,"Evening",2),
(6,"Yuvraj","yuvraj@gmail.com","BSN",29000,18,"Day",1);

SELECT * FROM Nurse;