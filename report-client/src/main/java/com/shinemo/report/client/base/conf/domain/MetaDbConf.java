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
	private Integer appType;
	/**
	* 删除状态 1-正常 0-删除
	*/
	private Integer status;
	/**
	* 账号
	*/
	private String user;
	/**
	* 密码
	*/
	private String passwd;
	/**
	* 数据库名称
	*/
	private String dbName;
	/**
	* 数据库url
	*/
	private String jdbcUrl;
	/**
	* 数据库驱动
	*/
	private String jdbcDriver;
	/**
	* 1-mysql
	*/
	private Integer type;
}
