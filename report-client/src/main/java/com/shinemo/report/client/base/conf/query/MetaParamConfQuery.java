package com.shinemo.report.client.base.conf.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.QueryBase;

/**
 * 查询类
 * @ClassName: MetaParamConfQuery
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Getter
@Setter
public class MetaParamConfQuery extends QueryBase {
	private Long id;
	private Date gmtCreate;
	private Date gmtModified;
    /**
    * 状态 1-正常 0-删除
    */
	private Integer status;
    /**
    * 1-下拉框 2-文本框 3-日期框
    */
	private Integer type;
    /**
    * 1-手动配置 2-sql动态获取(下拉框时生效)
    */
	private Integer sourceType;
    /**
    * 查询参数名称
    */
	private String queryName;
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
