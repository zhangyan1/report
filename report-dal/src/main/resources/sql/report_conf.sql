DROP TABLE IF EXISTS `report_conf`;
CREATE TABLE `report_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `status` int(1)  NOT NULL COMMENT '删除状态 1-正常 0-删除',
  `type` int(1) not null comment '1-完整sql执行 2-配置表名选择字段',
  `sql_text` text not null comment 'sql文案',
  `max_count` text not null comment '查询条数',
  `mete_colums` text not null comment '字段转换设置',
  `source_id` bigint not null comment '数据库源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库配置表';