create database if not exists yangbaobao;
use yangbaobao;

create table if not exists admin_users(id integer auto_increment primary key, name varchar(16), email varchar(40), password varchar(255));
create table if not exists admin_roles(id integer auto_increment primary key, name varchar(16));
create table if not exists admin_user_role(user_id integer, role_id integer, primary key(user_id, role_id), foreign key (user_id) references admin_users(id), foreign key(role_id) references admin_roles(id));


