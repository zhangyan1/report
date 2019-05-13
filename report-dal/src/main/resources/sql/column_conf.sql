DROP TABLE IF EXISTS `column_conf`;
CREATE TABLE `column_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `create_user_id` bigint not null comment '创建者uid',
  `create_user_name` varchar(64) not null comment '创建者姓名',
  `status` int(1)  NOT NULL COMMENT '状态 1-正常 0-删除',
  `report_id` bigint not null COMMENT  '报表主键id',
  `column_name` varchar(64) comment '列名',
  `column_show_name` varchar(128) DEFAULT null COMMENT '展示列名',
  `column_type` int(1) not null comment '1-布局列 2-统计列 3-维度列',
  `weight` int(4) not null comment '权重',
  `sort_type` int(1) not null DEFAULT 0 comment '排序类型 1-升序 2-降序',
  `data_type` int(1) not null DEFAULT 0 comment '数据类型 0-文本 1-数字 2-json对象',
  `json_column` text DEFAULT null comment 'json对象里面相关字段',
  PRIMARY KEY (`id`),
  key `uk_report_column` (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库配置表';