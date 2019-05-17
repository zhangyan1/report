DROP TABLE IF EXISTS `meta_column_conf`;
CREATE TABLE `meta_column_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `report_id` bigint not null COMMENT  '报表主键id',
  `main_column_name` varchar(64) comment '列名',
  `column_name` varchar(64) comment '列名',
  `column_show_name` varchar(128) DEFAULT null COMMENT '展示列名',
  `column_type` int(1) not null comment '1-普通列 2-计算子列 3-计算列',
  `weight` int(4) not null comment '权重',
  `sort_type` int(1) not null DEFAULT 0 comment '排序类型 1-升序 2-降序',
  `data_type` int(1) not null DEFAULT 0 comment '数据类型 0-文本 1-数字 2-json对象',
  `extend` text DEFAULT null comment '扩展字段',
  `orgin_data_type` varchar(16) not null comment '原始数据库字段类型',
  `expression` varchar(1024) DEFAULT null comment '由多个字段合并的列 （支持 + - * / ||）',
  PRIMARY KEY (`id`),
  key `uk_report_column` (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='报表模板字段映射配置表';