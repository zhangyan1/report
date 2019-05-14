package com.shinemo.report.client.base.conf.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.QueryBase;

/**
 * 查询类
 * @ClassName: MataReportTemplateQuery
 * @author zhangyan
 * @Date 2019-05-14 10:14:28
 */
@Getter
@Setter
public class MataReportTemplateQuery extends QueryBase {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
    /**
    * 创建者uid
    */
	private Long createUserId;
    /**
    * 创建者姓名
    */
	private String createUserName;
    /**
    * 删除状态 1-正常 0-删除
    */
	private Integer status;
    /**
    * 类型 1-sql配置 2-表名
    */
	private Integer type;
    /**
    * sql文案
    */
	private String sqlText;
    /**
    * 最大条数
    */
	private Long maxCount;
    /**
    * 数据库源id
    */
	private Long sourceId;
    /**
    * 扩展标位 1-需要审核
    */
	private Long flag;
}
