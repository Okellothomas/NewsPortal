CREATE DATABASE news_portal;

\c news_portal

CREATE TABLE news (
  id int PRIMARY KEY auto_increment,
  tittle VARCHAR,
  description VARCHAR,
  departmental_title VARCHAR
);


CREATE TABLE departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  description VARCHAR,
  number_of_employees int
);

CREATE TABLE users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  role VARCHAR,
  position VARCHAR,
  departmentId int
);

CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;