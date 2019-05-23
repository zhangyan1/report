package com.shinemo.report.client.base.conf.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.BaseDO;


/**
 * 实体类
 * @ClassName: MataReportTemplate
 * @author zhangyan
 * @Date 2019-05-14 10:14:28
 */
@Getter
@Setter
public class MetaReportTemplate extends BaseDO {
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
	* @see TemplateTypeEnum 类型 1-sql配置 2-表名
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
	 * 模板名称
	 */
	private String name;
	/**
	*  @see TemplateFlag 扩展标位
	*/
	private Long flag;
}
