package com.shinemo.report.client.db.domain;

import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.meta.domain.MetaHeader;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReportParameter {

    private List<MetaColumnConf> columnConfs;
    private String sqlText;
    private List<MetaParamConf> paramConfs;
    private List<TableQueryParamDO> queryParamDOS;
    private Long limit;
}
