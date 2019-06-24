package com.shinemo.report.web.table.controller;


import com.google.gson.reflect.TypeToken;
import com.shinemo.client.common.Result;
import com.shinemo.client.common.WebResult;
import com.shinemo.client.util.GsonUtil;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import com.shinemo.report.client.table.domain.TemplateRequest;
import com.shinemo.report.client.table.facade.TemplateFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/template")
@Slf4j
public class TemplateController{

    @Resource
    private TemplateFacadeService templateFacadeService;

    @RequestMapping(value = "/getDataSources", method = RequestMethod.GET)
    @ResponseBody
    public WebResult<List<MetaDbConf>> getDataSources(){
        Result<List<MetaDbConf>> rs = templateFacadeService.getDataSources();
        if(!rs.hasValue()){
            return WebResult.error(rs.getError());
        }
        return WebResult.success(rs.getValue());
    }


    @RequestMapping(value = "/addTemplate", method = RequestMethod.GET)
    @ResponseBody
    public WebResult<Void> previewExcel(@RequestParam(name="id",required = false) Long id,
                                        @RequestParam(name="templateType") Integer templateType,
                                        @RequestParam(name="sqlText") String sqlText,
                                        @RequestParam(name="maxCount",required = false) Long maxCount,
                                        @RequestParam(name="sourceId") Long sourceId,
                                        @RequestParam(name="templateName") String templateName,
                                        @RequestParam(name="columnListInfo") String columnListInfo,
                                        @RequestParam(name="paramListInfo") String paramListInfo){

        TemplateRequest request = new TemplateRequest();
        request.setTemplateId(id);
        request.setTemplateType(templateType);
        request.setSqlText(sqlText);
        request.setSourceId(sourceId);
        request.setTemplateName(templateName);
        request.setColumnListInfo(columnListInfo);
        request.setParamListInfo(paramListInfo);
        Result<Void> rs = null;
        if(request.getTemplateId() == null){
            rs = templateFacadeService.addTemplate(request);
        }else{
            rs =templateFacadeService.uptTemplate(request);
        }
        if(!rs.isSuccess()){
            return WebResult.error(rs.getError());
        }
        return WebResult.success();
    }



}
