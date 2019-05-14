DROP TABLE IF EXISTS `meta_db_conf`;
CREATE TABLE `meta_db_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `create_user_id` bigint not null comment '创建者uid',
  `create_user_name` varchar(64) not null comment '创建者姓名',
  `app_type`  int(11) NOT NULL,
  `status` int  NOT NULL COMMENT '删除状态 1-正常 0-删除',
  `user` varchar(128) not null comment '账号',
  `passwd` varchar(256) not null comment '密码',
  `db_name` varchar(128) not null comment '数据库名称',
  `jdbc_url` varchar(256) not null comment '数据库url',
  `jdbc_driver` varchar(64) not null comment '数据库驱动',
  `type` int(4) not null comment '1-mysql',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库配置表';