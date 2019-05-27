package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import com.shinemo.client.common.FlagHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableParamInfo extends BaseDO{

    private Integer sourceType;
    private String queryName;
    private String defaultKeyValue;
    private String defaultRealValue;
    private String contend;
    private Long reportId;
    private Long dataSourceId;
    private Long flag;

}
