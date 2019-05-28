package com.shinemo.report.client.base.conf.service.impl;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaReportTemplateQuery;
import com.shinemo.report.client.base.conf.service.MetaReportTemplateService;
import com.shinemo.report.dal.base.conf.wrapper.MetaReportTemplateWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class MetaReportTemplateServiceImpl implements MetaReportTemplateService {

    @Resource
    private MetaReportTemplateWrapper metaReportTemplateWrapper;

    @Override
    public Result<MetaReportTemplate> saveReportTemplate(MetaReportTemplate domain) {
        return metaReportTemplateWrapper.insert(domain);
    }

    @Override
    public Result<MetaReportTemplate> uptReportTemplate(MetaReportTemplate domain) {
        return metaReportTemplateWrapper.update(domain);
    }

    @Override
    public Result<ListVO<MetaReportTemplate>> findMetaReportTemplate(MetaReportTemplateQuery query) {
        return metaReportTemplateWrapper.find(query);
    }

    @Override
    public Result<MetaReportTemplate> getMetaReportTemplate(MetaReportTemplateQuery query) {
        return metaReportTemplateWrapper.get(query);
    }
}
