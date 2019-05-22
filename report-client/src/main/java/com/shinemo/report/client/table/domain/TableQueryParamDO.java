package com.shinemo.report.client.table.domain;


import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableQueryParamDO extends BaseDO{

    private String key;
    private String value;
    private Long flag;
}
