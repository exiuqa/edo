create table if not exists sys_user
(
    id           varchar(32) not null comment '主键',
    sys_name     varchar(32) null comment '用户名',
    sys_password varchar(32) null comment '密码',
    create_time  varchar(19) null comment '创建时间',
    update_time  varchar(19) null comment '更新时间',
    primary key (id)
);

create index index_sys_user_name
    on sys_user (sys_name);


INSERT INTO spike.sys_user (id, sys_name, sys_password, create_time, update_time)
VALUES ('1', 'exiu1', '1', '2020-01-22 18:30:30', '2020-01-22 18:30:30');
INSERT INTO spike.sys_user (id, sys_name, sys_password, create_time, update_time)
VALUES ('2', 'exiu', '1', '2020-01-22 18:30:30', '2020-01-22 18:30:30');
INSERT INTO spike.sys_user (id, sys_name, sys_password, create_time, update_time)
VALUES ('3', 'exiu', '1', '2020-01-22 18:30:30', '2020-01-22 18:30:30');
INSERT INTO spike.sys_user (id, sys_name, sys_password, create_time, update_time)
VALUES ('4', 'exiu', '1', '2020-01-22 18:30:30', '2020-01-22 18:30:30');
INSERT INTO spike.sys_user (id, sys_name, sys_password, create_time, update_time)
VALUES ('5', 'exiu', '1', '2020-01-22 18:30:30', '2020-01-22 18:30:30');