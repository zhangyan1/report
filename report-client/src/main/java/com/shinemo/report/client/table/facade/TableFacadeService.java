package com.shinemo.report.client.table.facade;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;

import java.util.List;

public interface TableFacadeService {

    /**
     * 获取列信息
     * @param dbName
     * @param sql
     * @return
     */
    Result<List<ReportMetaDataColumn>> getReportMetaDataColumn(String dbName, String sql);

    Result<TableInfoDO> getTableInfo(Long temlateId, List<TableQueryParamDO> params);

}
