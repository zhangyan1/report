package com.shinemo.report.core.table.facade.impl;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import com.shinemo.report.client.table.facade.TableFacadeService;
import com.shinemo.report.core.db.util.ReportDbUtil;
import com.shinemo.report.core.db.util.SqlQueryService;
import com.shinemo.report.core.db.util.SqlQueryerFactory;
import com.shinemo.report.dal.base.conf.wrapper.MetaReportTemplateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;


@Service
@Slf4j
public class TableFacadeServiceImpl implements TableFacadeService {

    private MetaReportTemplateWrapper mataReportTemplateWrapper;

    @Override
    public Result<List<ReportMetaDataColumn>> getReportMetaDataColumn(String dbName, String sqlText) {

        Assert.hasText(dbName,"dbName is null");
        Assert.hasText(sqlText,"sqlText is null");
        //sql 校验
        DataSource dataSource = ReportDbUtil.getDataSource(dbName);
        if(dataSource == null){
            //
        }
        SqlQueryService sqlQueryService = SqlQueryerFactory.create(dataSource);
        List<ReportMetaDataColumn> list = sqlQueryService.parseMetaDataColumns(sqlText);
        if(CollectionUtils.isEmpty(list)){
            //TODO
        }
        return Result.success(list);
    }

    @Override
    public Result<TableInfoDO> getTableInfo(Long temlateId, List<TableQueryParamDO> params) {
        return null;
    }
}
