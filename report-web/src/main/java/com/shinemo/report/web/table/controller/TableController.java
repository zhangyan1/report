package com.shinemo.report.web.table.controller;


import com.google.gson.reflect.TypeToken;
import com.shinemo.client.common.Result;
import com.shinemo.client.common.WebResult;
import com.shinemo.client.util.GsonUtil;
import com.shinemo.report.client.excel.util.ReportExcelUtil;
import com.shinemo.report.client.table.domain.TableInfoDO;
import com.shinemo.report.client.table.domain.TableQueryParamDO;
import com.shinemo.report.client.table.facade.TableFacadeService;
import com.shinemo.report.core.db.util.ReportDbUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/report")
@Slf4j
public class TableController {

    @Resource
    private TableFacadeService tableFacadeService;

    @RequestMapping(value = "/downExcel", method = RequestMethod.GET)
    public void downloadExcel(HttpServletResponse response,Long templateId,String paramInfo){
        Assert.notNull(templateId,"templateId is null");
        List<TableQueryParamDO> params = null;
        if(!StringUtils.isBlank(paramInfo)){
            params = GsonUtil.fromGson2Obj(paramInfo,new TypeToken<List<TableQueryParamDO>>(){}.getType());
        }
        Result<TableInfoDO> tableInfoDOResult = tableFacadeService.getTableInfo(templateId,params);
        if(!tableInfoDOResult.hasValue()){
            log.error("[downloadExcel] error:{}",tableInfoDOResult.getError());
            String msg = GsonUtil.toJson(tableInfoDOResult.getError());
            response.setContentType("application/json;charset=UTF-8");
            try {
                ServletOutputStream out = response.getOutputStream();
                out.write(msg.getBytes("utf-8"));
                out.flush();
            } catch (IOException e) {
                log.error("[downloadExcel] Io error",e);
            }
        }
        ReportExcelUtil.writeExcel(tableInfoDOResult.getValue(),response);
    }

    @RequestMapping(value = "/previewExcel", method = RequestMethod.GET)
    @ResponseBody
    public WebResult<TableInfoDO> previewExcel(Long templateId, String paramInfo){
        Assert.notNull(templateId,"templateId is null");
        List<TableQueryParamDO> params = null;
        if(!StringUtils.isBlank(paramInfo)){
            params = GsonUtil.fromGson2Obj(paramInfo,new TypeToken<List<TableQueryParamDO>>(){}.getType());
        }
        Result<TableInfoDO> tableInfoDOResult = tableFacadeService.getTableInfo(templateId,params);
        if(!tableInfoDOResult.hasValue()){
            return WebResult.error(tableInfoDOResult.getError());
        }
        return WebResult.success(tableInfoDOResult.getValue());
    }



}
