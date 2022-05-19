# News Portal APi

This web application allows developers to request data from a an organization using this APi when they can obtain users details, departmental details and news about the departments. 

### By Okello Thomas Olal, 05/19/2022


## Table of contents
* [Description](#description)
* [Setup and Installation Requirements](#setup)
* [Behaviour Driven Development](#BDD)
* [Technologies](#technologies)
* [Licence](#licence)
* [Authors information](#contact)

## Description

Often times developers require APi to collect real time data on major website, this application can be implemented by web developers enabling them to retrieve data or other developers to retrieve their data on real time. 

# Setup and Installation Requirements
To run this program:

```
$ Fork the repository from my git hub.
$ Clone this repository to a location in your file system.
$ Open the Intellij and locate where you have clone the file and open it. 
$ Type gradle run on your intellij command line to open a remote server where you can view the application. 
$ You need to install postgres database managing system to your account, this will be needed for storing your data.
$ alternatively, install the Harouk and using mvn harouk:display to do so in your own harouk free or paid account. 
```

Database Installation:

The following commands will be crucial in aiding you to set up your database and also query them on your commandline 
and is specific to ubuntu unix operating system.  

```
$ You need to install postgres database managing system to your account, this will be needed for storing your data.
$ alternatively, install the Harouk and using mvn harouk:display to do so in your own harouk free or paid account. 
$ sudo apt update - to update your system. 
$ apt install postgresql postgresql-contrib - install the postgres database. 
$ sudo -u postgres psql - navigate to postgres 
$ CREATE DATABASE news_portal;
  
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

  ```
CREATE DATABASE news_portal;
  


## Behaviour Driven Development (BDD)
This web page is documented and designed around the behavior a user expects to experience when interacting with it.

- When a developer install this Api they are able to retrieve real time data on departments, news on the departments and the users' information on the department. 

## Technologies
* HTML - HTML is the standard markup language for Web pages.
* CSS - CSS is the language we use to style an HTML document.
* Java - Java is an OOP language used for both web design and mobile application designs. 
* Sql - allow for data storage in the postgres database management system. 
* Handlebars
* Json

# Licence
MIT Licence 
copyright (c) 2022 Okello Thomas Olal. All Rights Reserved.

The  News Portal APi appliction is sole work of Okello Thomas and it delivered free on the github, for any changes or restrictions
like in the case of update, upgrade or omission of part of the software, permission is here granted for any person to alter the code of this 
for software to fit thier purpose. 

Once the software has been altred, the above permission will be obsolute and you will be required to work under the new guidelines or 
copyright policy provided. 

This application permission does not involve any warrant to its users. 


## Authors information
Contributions are always welcome!  
If you have any questions,comments or correctional advice, feel free to contact me
* Email: thomasolal33@gmail.com
* [LinkedIn](https://www.linkedin.com/in/thomas-okello-533313161/)