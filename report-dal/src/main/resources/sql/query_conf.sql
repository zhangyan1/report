DROP TABLE IF EXISTS `report_conf`;
CREATE TABLE `report_conf` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `status` int(1)  NOT NULL COMMENT '状态 1-正常 0-删除',
  `type` int(1) not null comment '1-下拉框 2-文本框 3-日期框',
  `source_type` int(1) not null comment '1-手动配置 2-sql动态获取(下拉框时生效)',
  `query_name` varchar(32) not null comment '查询参数名称',
  `default_key_value`  varchar(128) DEFAULT null comment '默认展示的key(下拉框时有用)',
  `default_real_value` varchar(128) DEFAULT null comment '默认值',
  `contend` text default null comment '1-下拉框为(3|滴滴,18|同程),select ** as ** from tableName',
  `report_id` bigint not null comment '报表配置主键id',
  `data_source_id` bigint DEFAULT  null comment '动态获取时数据源id',
  `flag` bigint not null DEFAULT 0 comment '标位 1-是否多选',
  PRIMARY KEY (`id`),
  key `uk_report_query` (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库配置表';