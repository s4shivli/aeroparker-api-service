drop table if exists customers;

create table customers
(
    id             integer      not null,
    address_line_1 varchar(255) not null,
    address_line_2 varchar(255),
    city           varchar(255),
    email_address  varchar(255) not null,
    first_name     varchar(50)  not null,
    last_name      varchar(50)  not null,
    phone_number   varchar(20),
    post_code      varchar(10)  not null,
    registered     timestamp,
    title          varchar(5)   not null,
    primary key (id)
)