create table user(
id int not null auto_increment,
phone varchar(40),
password varchar(60),
worryLogin int,
loginTime datetime,
jifen int default 500,
primary key(id));


create table message(
 id int not null auto_increment,
 title varchar(40),
 information varchar(5000),
primary key(id))

create table userTime(
id int not null auto_increment,
phone varchar(40),
codeTime datetime,
primary key(id));
