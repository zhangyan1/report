package com.shinemo.report.client.base.conf.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.BaseDO;


/**
 * 实体类
 * @ClassName: MetaDbConf
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Getter
@Setter
public class MetaDbConf extends BaseDO {

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
	* 数据库名称展示用
	*/
	private String dbName;
	/**
	 * 数据库值 myconf获取数据源时用
	 */
	private String dbValue;



}
