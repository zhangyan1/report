package com.shinemo.report.client.db.domain;

import com.shinemo.report.client.meta.domain.MetaHeader;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportParameter {

    private List<MetaHeader> metaHeaders;
    private String sqlText;
}
