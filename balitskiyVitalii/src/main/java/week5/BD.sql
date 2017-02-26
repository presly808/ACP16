CREATE TABLE candidates(
id int NOT NULL PRIMARY KEY,
fullname VARCHAR(20) NOT NULL,
region int NOT NULL,
age int,
FOREIGN KEY (region) REFERENCES regions(id)
);

CREATE TABLE clans(
  id int NOT NULL PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE regions(
  id int NOT NULL PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  population int NOT NULL
);

CREATE TABLE cand_interest(
  cand_id int NOT NULL,
  interest_id int NOT NULL,
  percent FLOAT NOT NULL,
  FOREIGN KEY (cand_id) REFERENCES candidates(id),
  FOREIGN KEY (interest_id) REFERENCES interests(id)
);

CREATE TABLE interests(
  id int PRIMARY KEY,
  interest varchar(20)
);
