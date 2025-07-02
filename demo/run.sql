create table user
(
    `userid` VARCHAR(128) NOT NULL  primary key COMMENT '用户ID，Usr+UUID',
    `username` VARCHAR(32) NOT NULL COMMENT '用户名',
    `password` VARCHAR(128) NOT NULL COMMENT '密码哈希值'
);
create table article
(
    `id`           VARCHAR(143) NOT NULL COMMENT '公告ID，格式为：ann_+UUID',
    `publisher_id` VARCHAR(143) NOT NULL COMMENT '发布者ID，格式为：usr_+UUID',
    `title`        VARCHAR(128) NOT NULL COMMENT '文章标题',
    `content`      TEXT         NOT NULL COMMENT '文章内容',
    `status`       TINYINT UNSIGNED      DEFAULT 1 COMMENT '文章状态：0-已删除，1-正常',
    `pin`          TINYINT UNSIGNED      DEFAULT 0 COMMENT '是否置顶：0-不置顶，1-置顶',
    `created_at`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)
