CREATE TABLE sys_user
(
    id           BIGINT COMMENT '主键',
    sys_name     VARCHAR(32) COMMENT '用户名',
    sys_password VARCHAR(32) COMMENT '密码',
    create_time  VARCHAR(19) COMMENT '创建时间',
    update_time  VARCHAR(19) COMMENT '更新时间',
    PRIMARY KEY (id)
);