SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS news (
  id int PRIMARY KEY auto_increment,
  news VARCHAR,
  link VARCHAR,
  departement_id int
);


CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name general,
  email deparmental,
  user_id int
);

CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  postion VARCHAR,
  role VARCHAR,
  link VARCHAR,
  departement_id int
);