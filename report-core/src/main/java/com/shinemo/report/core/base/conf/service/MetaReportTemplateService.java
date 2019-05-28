package com.shinemo.report.core.base.conf.service;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaReportTemplateQuery;

public interface MetaReportTemplateService {

    /**
     * 存储模板
     * @param domain
     * @return
     */
    Result<MetaReportTemplate> saveReportTemplate(MetaReportTemplate domain);

    /**
     * 更新模板
     * @param domain
     * @return
     */
    Result<MetaReportTemplate> uptReportTemplate(MetaReportTemplate domain);

    /**
     * 查找模板列表
     * @param query
     * @return
     */
    Result<ListVO<MetaReportTemplate>> findMetaReportTemplate(MetaReportTemplateQuery query);

    /**
     * 查找模板
     * @param query
     * @return
     */
    Result<MetaReportTemplate> getMetaReportTemplate(MetaReportTemplateQuery query);



}
