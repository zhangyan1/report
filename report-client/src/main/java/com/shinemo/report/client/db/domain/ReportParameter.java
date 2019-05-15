package com.shinemo.report.client.db.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportParameter {

    private List<ReportMetaDataColumn> metaColumns;
    private String sqlText;
}
