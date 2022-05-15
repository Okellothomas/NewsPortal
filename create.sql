CREATE DATABASE news_portal;
\c news_portal


CREATE TABLE news (
  id int PRIMARY KEY auto_increment,
  news_type VARCHAR,
  user_id Int,
  departement_id int,
  title VARCHAR,
  description VARCHAR
);


CREATE TABLE departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  description VARCHAR,
  size int
);

CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  postion VARCHAR,
  role VARCHAR,
  link VARCHAR,
  departement_id int
);



CREATE TABLE news (
id SERIAL PRIMARY KEY,
news_type VARCHAR,
department_id INT,
user_id INT,
title VARCHAR,
description VARCHAR
);

CREATE TABLE staff (
id SERIAL PRIMARY KEY,
name VARCHAR,
position VARCHAR,
staff_role VARCHAR
);

CREATE TABLE users_departments (
id SERIAL PRIMARY KEY,
user_id INT,
department_id INT
);





CREATE DATABASE organisational_news_portal_test WITH TEMPLATE organisational_news_portal;