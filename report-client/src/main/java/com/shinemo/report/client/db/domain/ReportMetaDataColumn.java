package com.shinemo.report.client.db.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 * 报表数据列
 */
@Getter
@Setter
public class ReportMetaDataColumn extends BaseDO{

    private String key;
    private Integer width;
    private String dataType;

}