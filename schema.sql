CREATE TABLE employee(
    empid int auto_increment,
    firstname varchar(100),
    lastname varchar(100),
    email varchar(100),
    address varchar(500),
    stateid int,
    countryid int,
    cityname varchar(100),
    departmentid int,
    managerid int,
    active boolean,
    createddate timestamp default current_timestamp,
    createdby int,
    updateddate timestamp default current_timestamp,
    updatedby int,
    constraint PK_EMPLOYEE primary key (empid),
    constraint fk_manager_join foreign key (managerid) references employee (empid)
) engine=InnoDB;

alter table employee add constraint fk_deprt_join foreign key (departmentid) references department(id);

create table department (
	id int auto_increment primary key,
    name varchar(100) not null,
    active boolean
) engine=InnoDB;

create table city (
	id int,
    name varchar (100) not null,
    active boolean default false,
    stateid int not null,
    countryid int not null,
    constraint pk_city primary key (id),
    constraint fk_city_state_join foreign key (stateid) references state(id),
    constraint fk_city_country_join foreign key (countryid) references country(id)
) engine=InnoDB;

create table state (
	id int,
    name varchar(100) not null,
    active boolean default true,
    countryid int not null,
    constraint pk_state primary key (id),
    constraint fk_country_join foreign key (countryid) references country(id)
) engine=InnoDB;

create table country (
	id int auto_increment,
    name varchar(100) not null,
    active boolean default true,

    constraint pk_country primary key (id)
) engine=InnoDB;