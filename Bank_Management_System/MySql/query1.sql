create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(50), city varchar(20), pin varchar(20), state varchar(20));

show tables;


select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(30), pan varchar(20), aadhar varchar(50), eniorcitizen varchar(20), existingaccount varchar(20));


select * from signuptwo;

create table signupthree(formno varchar(20), accountType varchar(20), cardnumber varchar(20), pin varchar(20), facility varchar(100));
create table login(formno varchar(20), cardnumber varchar(20), pin varchar(20));

select * from signupthree;
select * from signuplogin;

select * from login;

drop table bank;

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));

select * from bank;