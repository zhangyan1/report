package com.shinemo.report.client.base.conf.query;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import com.shinemo.client.common.QueryBase;

/**
 * 查询类
 * @ClassName: MetaColumnConfQuery
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Getter
@Setter
public class MetaColumnConfQuery extends QueryBase {
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
    * 1-布局列 2-统计列 3-维度列
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
    * json对象里面相关字段
    */
	private String jsonColumn;
}
