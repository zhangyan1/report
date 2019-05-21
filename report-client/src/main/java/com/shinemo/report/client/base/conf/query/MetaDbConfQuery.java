package com.shinemo.report.client.base.conf.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.QueryBase;

/**
 * 查询类
 * @ClassName: MetaDbConfQuery
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Getter
@Setter
public class MetaDbConfQuery extends QueryBase {
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
    * 数据库名称
    */
	private String dbName;
	/**
	 * 数据库值
	 */
	private String dbValue;
}
