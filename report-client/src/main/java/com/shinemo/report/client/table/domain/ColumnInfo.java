package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnInfo extends BaseDO{

    private String mainColumnName;
    private String columnName;
    private String columnShowName;
    private Integer columnType;
    private Integer weight;
    private Integer sortType;
    private Integer dataType;
    private String originDataType;
    private String expression;

}
