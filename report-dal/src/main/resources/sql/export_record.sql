DROP TABLE IF EXISTS `export_record`;
CREATE TABLE `export_record` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gmt_create`   datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `create_user_id` bigint not null comment '创建者uid',
  `create_user_name` varchar(64) not null comment '创建者姓名',
  `status` int  NOT NULL COMMENT '-1 删除 0-待审核 3-已审核 6-已完成',
  `template_id` bigint not null comment '模板id',
  `query_params` extend default null comment '查询参数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='数据库导出记录表';