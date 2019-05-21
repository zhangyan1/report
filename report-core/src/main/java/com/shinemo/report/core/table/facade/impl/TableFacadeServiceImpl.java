package com.shinemo.report.core.table.facade.impl;

import com.google.common.collect.Lists;
import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;
import com.shinemo.report.client.base.conf.query.MetaParamConfQuery;
import com.shinemo.report.client.base.conf.query.MetaReportTemplateQuery;
import com.shinemo.report.client.common.domain.ReportErrors;
import com.shinemo.report.client.db.domain.ReportMetaDataColumn;
import com.shinemo.report.client.db.domain.ReportParameter;
import com.shinemo.report.client.meta.domain.MetaHeader;
import com.shinemo.report.client.table.domain.SheetInfoDO;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import com.shinemo.report.client.table.facade.TableFacadeService;
import com.shinemo.report.core.db.util.ReportDbUtil;
import com.shinemo.report.core.db.util.SqlQueryService;
import com.shinemo.report.core.db.util.SqlQueryerFactory;
import com.shinemo.report.dal.base.conf.wrapper.MetaColumnConfWrapper;
import com.shinemo.report.dal.base.conf.wrapper.MetaDbConfWrapper;
import com.shinemo.report.dal.base.conf.wrapper.MetaParamConfWrapper;
import com.shinemo.report.dal.base.conf.wrapper.MetaReportTemplateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class TableFacadeServiceImpl implements TableFacadeService {

    @Resource
    private MetaReportTemplateWrapper mataReportTemplateWrapper;

    @Resource
    private MetaParamConfWrapper metaParamConfWrapper;

    @Resource
    private MetaDbConfWrapper metaDbConfWrapper;

    @Resource
    private MetaColumnConfWrapper metaColumnConfWrapper;

    @Override
    public Result<List<ReportMetaDataColumn>> getReportMetaDataColumn(Long dbId, String sqlText) {

        Assert.notNull(dbId,"dbName is null");
        Assert.hasText(sqlText,"sqlText is null");
        //sql 校验
        MetaDbConfQuery query = new MetaDbConfQuery();
        Result<MetaDbConf> dbRs = metaDbConfWrapper.get(query);
        if(dbRs.hasValue()){
            return Result.error(ReportErrors.DATASOURCE_ERROR);
        }
        DataSource dataSource = ReportDbUtil.getDataSource(dbRs.getValue().getDbValue());
        if(dataSource == null){
            return Result.error(ReportErrors.DATASOURCE_ERROR);
        }
        SqlQueryService sqlQueryService = SqlQueryerFactory.create(dataSource);
        List<ReportMetaDataColumn> list = sqlQueryService.parseMetaDataColumns(sqlText);
        if(CollectionUtils.isEmpty(list)){
            //TODO
        }
        return Result.success(list);
    }

    @Override
    public Result<TableInfoDO> getTableInfo(Long templateId, List<TableQueryParamDO> params) {
        //查找模板相关信息
        MetaReportTemplateQuery query = new MetaReportTemplateQuery();
        query.setId(templateId);
        Result<MetaReportTemplate> rs = mataReportTemplateWrapper.get(query);
        if(!rs.hasValue()){
            log.error("");
            return Result.error(rs.getError());
        }
        //查找列配置
        MetaColumnConfQuery columnQuery = new MetaColumnConfQuery();
        columnQuery.setReportId(templateId);
        Result<ListVO<MetaColumnConf>> columnRs = metaColumnConfWrapper.find(columnQuery);
        if(!columnRs.hasValue()){
            return Result.error(columnRs.getError());
        }
        MetaParamConfQuery paramQuery = new MetaParamConfQuery();
        paramQuery.setReportId(templateId);
        Result<ListVO<MetaParamConf>> paramRs = metaParamConfWrapper.find(paramQuery);
        if(paramRs.hasValue()){
            //TODO 进行sql重封装
        }
        DataSource dataSource = ReportDbUtil.getDataSource("buycenter");
        if(dataSource == null){
            //TODO 返回
        }
        List<MetaHeader> columnLists = Lists.newArrayList();
        columnRs.getValue().getRows().sort(Comparator.comparingInt(val->val.getWeight()));
        Collections.reverse(columnRs.getValue().getRows());
        for(int i=0;i<columnRs.getValue().getRows().size();i++){
            MetaColumnConf conf = columnRs.getValue().getRows().get(i);
            MetaHeader iter = new MetaHeader();
            iter.setIndex(i);
            iter.setKey(conf.getColumnName());
            iter.setMainKey(conf.getMainColumnName());
            iter.setValue(conf.getColumnShowName());
            iter.setOriginDataType(conf.getOrginDataType());
            iter.setDataType(conf.getDataType());
            columnLists.add(iter);
        }
        ReportParameter param = new ReportParameter();
        param.setSqlText(rs.getValue().getSqlText());
        param.setMetaHeaders(columnLists);
        SqlQueryService sqlQueryService = SqlQueryerFactory.create(dataSource,param);
        List<Map<String,Object>> rowsList = sqlQueryService.getMetaDataRows();
        SheetInfoDO sheetInfoDO = new SheetInfoDO();
        sheetInfoDO.setHeaders(columnLists);
        sheetInfoDO.setRows(rowsList);
        TableInfoDO tableInfoDO = new TableInfoDO();
        tableInfoDO.setFileName(rs.getValue().getName());
        tableInfoDO.setSheetInfos(Lists.newArrayList(sheetInfoDO));
        return Result.success(tableInfoDO);
    }
}
