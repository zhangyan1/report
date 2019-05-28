package com.shinemo.report.core.table.facade.impl;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.client.exception.BizException;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;
import com.shinemo.report.client.common.domain.ReportErrors;
import com.shinemo.report.core.base.conf.service.MetaColumnConfService;
import com.shinemo.report.core.base.conf.service.MetaDbConfService;
import com.shinemo.report.client.table.domain.TemplateRequest;
import com.shinemo.report.client.table.facade.TemplateFacadeService;
import com.shinemo.report.core.base.conf.service.MetaParamConfService;
import com.shinemo.report.core.base.conf.service.MetaReportTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TemplateFacadeServiceImpl implements TemplateFacadeService{

    @Resource
    private MetaDbConfService metaDbConfService;

    @Resource
    private MetaParamConfService metaParamConfService;

    @Resource
    private MetaReportTemplateService metaReportTemplateService;

    @Resource
    private MetaColumnConfService metaColumnConfService;

    @Override
    public Result<List<MetaDbConf>> getDataSources(){

        MetaDbConfQuery query = new MetaDbConfQuery();
        query.setPageEnable(false);
        Result<ListVO<MetaDbConf>> rs = metaDbConfService.findDbConf(query);
        if(!rs.hasValue() || CollectionUtils.isEmpty(rs.getValue().getRows())){
            return Result.error(ReportErrors.DATASOURCE_ERROR);
        }
        return Result.success(rs.getValue().getRows());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Void> addTemplate(TemplateRequest request){
        Assert.notNull(request,"request is null");
        Assert.notNull(request.getUserInfo(),"userInfo is null");
        Assert.notNull(request.getSourceId(),"sourceId is null");
        Assert.notNull(request.getSqlText(),"sqlText is null");
        MetaReportTemplate template = initTemplate(request);
        Result<MetaReportTemplate> rs = metaReportTemplateService.saveReportTemplate(template);
        if(!rs.hasValue()){
            return Result.error(rs.getError());
        }
        List<MetaColumnConf> confList = initColumnList(request);
        Result<Void> rz = metaColumnConfService.saveMetaColumnConfList(confList);
        if(!rz.isSuccess()){
            throw new BizException(rs.getError());
        }
        List<MetaParamConf> paramList = initParamList(request);
        Result<Void> rt = metaParamConfService.saveMetaParamConfList(paramList);
        if(!rt.isSuccess()){
            throw new BizException(rs.getError());
        }
        return Result.success();
    }

    private List<MetaParamConf> initParamList(TemplateRequest request) {
        return null;
    }

    private List<MetaColumnConf> initColumnList(TemplateRequest request) {
        return null;
    }

    private MetaReportTemplate initTemplate(TemplateRequest request) {
        return null;
    }


    @Override
    public Result<Void> uptTemplate(TemplateRequest request) {
        return null;
    }

    @Override
    public Result<Void> detelteTemplate(Long id) {
        return null;
    }

    @Override
    public Result<List<MetaParamConf>> getTemplateQueryParams(Long id) {
        return null;
    }
}
