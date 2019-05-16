package com.shinemo.report.dal.base.conf.wrapper;

import javax.annotation.Resource;

import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaReportTemplateQuery;
import com.shinemo.report.dal.base.conf.mapper.MetaReportTemplateMapper;
import org.springframework.stereotype.Service;
import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.client.dal.wrapper.Wrapper;


/**
 * Wrapper
 * @ClassName: MataReportTemplateWrapper
 * @author zhangyan
 * @Date 2019-05-14 10:14:28
 */
@Service
public class MetaReportTemplateWrapper extends Wrapper<MetaReportTemplateQuery, MetaReportTemplate> {

    @Resource
    private MetaReportTemplateMapper mataReportTemplateMapper;

    @Override
    public Mapper<MetaReportTemplateQuery, MetaReportTemplate> getMapper() {
        return mataReportTemplateMapper;
    }
}