create table "user" (
                        id varchar(255) not null,
                        name varchar(50) not null,
                        primary key (id)
);

create table client (
                        id bigserial not null,
                        firstName varchar(100) not null,
                        lastName varchar(100) not null,
                        email varchar(100) not null,
                        phone varchar(20) not null,
                        occupation varchar(100) not null,
                        gender varchar(100) not null,
                        maritalStatus varchar(20) not null,
                        age int not null,
                        birthDate timestamp without time zone not null,
                        primary key (id)
);