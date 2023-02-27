create schema user_db;
create schema product_db;
create schema order_db;

create table order_db.order_table
(
  id             bigint       not null
    primary key,
  beverage_id    bigint       null,
  created_at     bigint       not null,
  created_by     bigint       not null,
  employee_name  varchar(255) null,
  entry_id       bigint       null,
  main_course_id bigint       null,
  total_calories bigint       null,
  updated_at     bigint       not null
);

create table product_db.food
(
  product_type varchar(31)  not null,
  id           bigint       not null
    primary key,
  calories     bigint       null,
  name         varchar(255) null
);

create table user_db.user
(
  id         bigint       not null
    primary key,
  created_at bigint       not null,
  password   varchar(255) null,
  username   varchar(255) null
);
