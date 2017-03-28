CREATE DATABASE Election;

CREATE TABLE Clan (
id INT AUTO_INCREMENT,
name VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE Region(
id INT AUTO_INCREMENT,
name VARCHAR(20),
population INT,
PRIMARY KEY(id)
);

CREATE TABLE Candidates (
id INT AUTO_INCREMENT,
name VARCHAR(20) UNIQUE ,
clan_id int NOT NULL,
region_id int NOT NULL ,
age int,
PRIMARY KEY (id),
FOREIGN KEY (clan_id) REFERENCES Clan(id),
FOREIGN KEY (region_id) REFERENCES Region(id)
);

CREATE TABLE Interests(
id INT AUTO_INCREMENT,
name VARCHAR(20),
PRIMARY KEY (id)
);

CREATE TABLE CandidatesInterests(
cand_id INT NOT NULL,
inter_id INT NOT NULL,
FOREIGN KEY (cand_id) REFERENCES Candidates(id),
FOREIGN KEY (inter_id) REFERENCES Interests(id)
);

INSERT INTO Clan (name) VALUES('Green');
INSERT INTO Clan (name) VALUES('Hit');
INSERT INTO Clan (name) VALUES('Blue');


INSERT INTO Region (name, population) VALUES('Kiev', 100000);
INSERT INTO Region (name, population) VALUES('Poltava', 50000);
INSERT INTO Region (name, population) VALUES('Odessa', 75000);


INSERT INTO Candidates (name, clan_id, region_id, age) VALUES('Dopkin', 1, 2, 45);
INSERT INTO Candidates (name, clan_id, region_id, age) VALUES('Ynik', 3, 1, 48);
INSERT INTO Candidates (name, clan_id, region_id, age) VALUES('Ynik1', 3, 3, 78);
INSERT INTO Candidates (name, clan_id, region_id, age) VALUES('Ynik2', 2, 2, 44);


INSERT INTO Interests (name) VALUES('Freedom');
INSERT INTO Interests (name) VALUES('Clear');
INSERT INTO Interests (name) VALUES('Salary');


INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(1,2);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(1,3);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(2,1);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(2,3);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(2,2);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(3,2);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(3,1);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(4,3);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(5,3);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(5,1);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(6,1);
INSERT INTO CandidatesInterests (cand_id, inter_id) VALUES(6,2);


SELECT * FROM Candidates WHERE age BETWEEN 40 AND 45;
SELECT * FROM Candidates c INNER JOIN Region r ON c.region_id=r.id;
SELECT * FROM Candidates c INNER JOIN Region r INNER JOIN Clan cl ON c.region_id=r.id AND c.clan_id=cl.id;
SELECT * FROM Candidates c INNER JOIN Region r ON c.region_id=r.id LIMIT 5;

SELECT * FROM Candidates c INNER JOIN Region r ON c.region_id=r.id WHERE r.name='Poltava' ;
SELECT * FROM Candidates c INNER JOIN Region r ON c.region_id=r.id WHERE r.name='Poltava' ORDER BY c.name ASC LIMIT 5;

SELECT MAX(population) AS 'Max people' FROM Region;

SELECT COUNT(c.name) FROM Candidates c INNER JOIN Clan cl ON c.clan_id = cl.id WHERE cl.name='Hit';





