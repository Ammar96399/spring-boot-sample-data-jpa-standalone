
drop table city;

drop table hotel;

drop table review;

create table city(city_id int primary key not null auto_increment, country varchar(100), name varchar(100), state varchar(100), map varchar(200));

create table hotel(hotel_id int primary key not null auto_increment, city_id int, name varchar(100), address varchar(200), zip varchar(20));

create table review(hotel_id int, review_id int primary key not null auto_increment, idx int, check_in_date varchar(50), rating int, trip_type int, title varchar(50), details varchar(1000));