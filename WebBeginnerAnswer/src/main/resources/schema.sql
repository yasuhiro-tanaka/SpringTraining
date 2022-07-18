CREATE TABLE inquiry
(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   contents VARCHAR(500) NOT NULL,
   created DATETIME NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE survey
(
   id INT NOT NULL AUTO_INCREMENT,
   age INT NOT NULL,
   satisfaction INT NOT NULL,
   comment VARCHAR(100),
   created DATETIME NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE user
(
   id INT NOT NULL,
   name VARCHAR(32) NOT NULL,
   password VARCHAR(32) NOT NULL,
   role VARCHAR(10),
   created DATETIME NOT NULL,
   PRIMARY KEY(id)
);
