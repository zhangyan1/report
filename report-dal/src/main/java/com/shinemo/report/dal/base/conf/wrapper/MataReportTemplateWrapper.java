package com.shinemo.report.dal.base.conf.wrapper;

import javax.annotation.Resource;

import com.shinemo.report.client.base.conf.domain.MataReportTemplate;
import com.shinemo.report.client.base.conf.query.MataReportTemplateQuery;
import com.shinemo.report.dal.base.conf.mapper.MataReportTemplateMapper;
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
public class MataReportTemplateWrapper extends Wrapper<MataReportTemplateQuery, MataReportTemplate> {

    @Resource
    private MataReportTemplateMapper mataReportTemplateMapper;

    @Override
    public Mapper<MataReportTemplateQuery, MataReportTemplate> getMapper() {
        return mataReportTemplateMapper;
    }
}