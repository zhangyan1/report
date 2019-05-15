package com.shinemo.report.client.table.facade;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;

import java.util.List;

public interface TableFacadeService {

    Result<List<ReportMetaDataColumn>> getReportMetaDataColumn(String dbName, String sql);

}
