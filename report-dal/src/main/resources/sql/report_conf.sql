DROP TABLE IF EXISTS `report_conf`;
CREATE TABLE `report_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `create_user_id` bigint not null comment '创建者uid',
  `create_user_name` varchar(64) not null comment '创建者姓名',
  `status` int(1)  NOT NULL COMMENT '删除状态 1-正常 0-删除',
  `type` int(1) not null comment '类型 1-sql配置 2-表名',
  `sql_text` text not null comment 'sql文案',
  `max_count` BIGINT not null DEFAULT '200' comment '最大条数',
  `source_id` bigint not null comment '数据库源id',
  `flag` bigint not null DEFAULT 0 COMMENT '扩展标位 1-需要审核',
  PRIMARY KEY (`id`),
  key `uk_report_conf` (`source_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='报表模板配置表';