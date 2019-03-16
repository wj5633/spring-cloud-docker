DROP DATABASE ms_provider;
CREATE DATABASE ms_provider CHARACTER SET utf8;

USE ms_provider;

CREATE TABLE IF NOT EXISTS ms_user
(
  `id`       bigint(20)     NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(40)    NOT NULL DEFAULT '',
  `name`     varchar(20)    NOT NULL DEFAULT '',
  `age`      int(3)         NOT NULL DEFAULT 0,
  `balance`  decimal(10, 2) NOT NULL DEFAULT 0.00,
  primary key (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';


insert into ms_user (id, username, name, age, balance)
values (1, 'account1', '张三', 20, 100.00),
       (2, 'account2', '李四', 28, 180.00),
       (3, 'account3', '王五', 32, 250.00);