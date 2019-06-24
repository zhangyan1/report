package com.shinemo.report.core.table.facade.impl;

import com.google.gson.reflect.TypeToken;
import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.client.common.StatusEnum;
import com.shinemo.client.util.GsonUtil;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.domain.MetaReportTemplate;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;
import com.shinemo.report.client.base.conf.query.MetaReportTemplateQuery;
import com.shinemo.report.client.common.domain.DeleteStatusEnum;
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
    public Result<Void> addOrUptTemplate(TemplateRequest request){

        Assert.notNull(request,"request is null");
        Assert.notNull(request.getUserInfo(),"userInfo is null");
        Assert.notNull(request.getSourceId(),"sourceId is null");
        Assert.notNull(request.getSqlText(),"sqlText is null");
        MetaReportTemplate template = initTemplate(request);
        Result<MetaReportTemplate> rs = null;
        if(template.getId()!=null){
            rs = metaReportTemplateService.saveReportTemplate(template);
        }else{
            rs = metaReportTemplateService.uptReportTemplate(template);
        }
        if(!rs.hasValue()){
            return Result.error(rs.getError());
        }
        return Result.success();
    }

    private List<MetaParamConf> initParamList(TemplateRequest request) {
        List<MetaParamConf> list = GsonUtil.fromGson2Obj(request.getParamListInfo(),new TypeToken<List<MetaParamConf>>
                (){}.getType());
        return list;
    }

    private List<MetaColumnConf> initColumnList(TemplateRequest request) {

        List<MetaColumnConf> list = GsonUtil.fromGson2Obj(request.getColumnListInfo(),new TypeToken<List<MetaColumnConf>>
                (){}.getType());
        return list;
    }

    private MetaReportTemplate initTemplate(TemplateRequest request){
        MetaReportTemplate template = new MetaReportTemplate();
        template.setCreateUserId(request.getUserInfo().getUid());
        template.setCreateUserName(request.getUserInfo().getUserName());
        template.setStatus(StatusEnum.NORMAL.getId());
        template.setType(request.getTemplateType());
        template.setFlag(request.getFlagHeper().getValue());
        template.setMaxCount(request.getMaxCount());
        template.setSourceId(request.getSourceId());
        template.setName(request.getTemplateName());
        template.setColumnListInfo(request.getColumnListInfo());
        template.setParamListInfo(request.getParamListInfo());
        template.setId(request.getTemplateId());
        return template;
    }


    @Override
    public Result<Void> detelteTemplate(Long id) {
        Assert.notNull(id,"templateId is null");
        MetaReportTemplateQuery query = new MetaReportTemplateQuery();
        query.setId(id);
        Result<MetaReportTemplate> rs = metaReportTemplateService.getMetaReportTemplate(query);
        if(!rs.hasValue()){
            return Result.error(ReportErrors.TEMPLATE_NOT_EXIST);
        }
        MetaReportTemplate template = rs.getValue();
        template.setStatus(DeleteStatusEnum.DELETE.getId());
        Result<MetaReportTemplate> ret =metaReportTemplateService.uptReportTemplate(template);
        if(!ret.hasValue()){
            return Result.error(ret.getError());
        }
        return Result.success();
    }

    @Override
    public Result<List<MetaParamConf>> getTemplateQueryParams(Long id) {
        return null;
    }
}
