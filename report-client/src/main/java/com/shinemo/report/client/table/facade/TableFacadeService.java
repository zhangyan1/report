package com.shinemo.report.client.table.facade;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;

import java.util.List;

public interface TableFacadeService {

    /**
     * 获取列信息
     * @param dbId
     * @param sql
     * @return
     */
    Result<List<ReportMetaDataColumn>> getReportMetaDataColumn(Long dbId, String sql);
    /**
     * 获取表格信息
     * @param templateId
     * @param params
     * @return
     */
    Result<TableInfoDO> getTableInfo(Long templateId, List<TableQueryParamDO> params);

}
