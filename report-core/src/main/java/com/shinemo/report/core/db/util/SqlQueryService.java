package com.shinemo.report.core.db.util;

import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.db.domain.ReportQueryParamItem;
import com.shinemo.report.client.meta.domain.MetaHeader;

import java.util.List;
import java.util.Map;

public interface SqlQueryService {

    /**
     * 获取列集合 设置列信息时用到
     * @param sqlText
     * @return
     */
    List<ReportMetaDataColumn> parseMetaDataColumns(String sqlText);

    /**
     * 从sql语句中解析出报表查询参数(如下拉列表参数）的列表项集合
     *
     * @param sqlText sql语句
     * @return List[ReportQueryParamItem]
     */
    List<ReportQueryParamItem> parseQueryParamItems(String sqlText);

    /**
     * 获取报表原始数据行集合
     *
     * @return List[ReportMetaDataRow]
     */
    List<Map<String,Object>> getMetaDataRows();

    /**
     * 获取报表原始数据列集合
     *
     * @return List[ReportMetaDataColumn]
     */
    List<MetaHeader> getMetaHeaders();
}
