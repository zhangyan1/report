package com.shinemo.report.client.base.conf.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.BaseDO;


/**
 * 实体类
 * @ClassName: MetaParamConf
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Getter
@Setter
public class MetaParamConf extends BaseDO {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
	/**
	* @see ParamTypeEnum
	*/
	private Integer type;
	/**
	*  @see SourceTypeEnum
	*/
	private Integer sourceType;
	/**
	* 查询参数名称
	*/
	private String queryKey;
	/**
	* 默认展示的key(下拉框时有用)
	*/
	private String defaultKeyValue;
	/**
	* 默认值
	*/
	private String defaultRealValue;
	/**
	* 1-下拉框为(3|滴滴,18|同程),select ** as ** from tableName
	*/
	private String contend;
	/**
	* 报表配置主键id
	*/
	private Long reportId;
	/**
	* 动态获取时数据源id
	*/
	private Long dataSourceId;
	/**
	* 标位 1-是否多选
	*/
	private Long flag;
}
