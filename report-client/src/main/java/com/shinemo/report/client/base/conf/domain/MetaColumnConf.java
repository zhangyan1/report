package com.shinemo.report.client.base.conf.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.BaseDO;


/**
 * 实体类
 * @ClassName: MetaColumnConf
 * @author zhangyan
 * @Date 2019-05-17 11:19:35
 */
@Getter
@Setter
public class MetaColumnConf extends BaseDO {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	* 报表主键id
	*/
	private Long reportId;
	/**
	* 列名
	*/
	private String mainColumnName;
	/**
	* 列名
	*/
	private String columnName;
	/**
	* 展示列名
	*/
	private String columnShowName;
	/**
	* 1-普通列 2-计算子列 3-计算列
	*/
	private Integer columnType;
	/**
	* 权重
	*/
	private Integer weight;
	/**
	* 排序类型 1-升序 2-降序
	*/
	private Integer sortType;
	/**
	* 数据类型 0-文本 1-数字 2-json对象
	*/
	private Integer dataType;
	/**
	* 扩展字段
	*/
	private String extend;
	/**
	* 模板名称
	*/
	private String name;
	/**
	* 原始数据库字段类型
	*/
	private String orginDataType;
	/**
	* 由多个字段合并的列 （支持 + - * / ||）
	*/
	private String expression;
}
