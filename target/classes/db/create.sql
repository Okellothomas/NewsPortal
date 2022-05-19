SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS news (
  id int PRIMARY KEY auto_increment,
  tittle VARCHAR,
  description VARCHAR,
  departmental_title VARCHAR
);

CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  description VARCHAR,
  number_of_employees int
);

CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  role VARCHAR,
  position VARCHAR,
  departmentId int
);