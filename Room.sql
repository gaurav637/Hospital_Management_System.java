USE Hospital;

CREATE TABLE room(
  room_no INT,
  room_type VARCHAR(30),
  room_floor INT
);

INSERT INTO room
(room_no,room_type,room_floor)
VALUES
(21,"ICU",1),
(22,"General",1),
(23,"Pediatric")