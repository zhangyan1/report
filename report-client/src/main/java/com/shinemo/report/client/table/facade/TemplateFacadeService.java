package com.shinemo.report.client.table.facade;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.table.domain.TemplateRequest;

import java.util.List;

public interface TemplateFacadeService {
    /**
     * 获取所有数据源
     * @return
     */
    Result<List<MetaDbConf>> getDataSources();
    /**
     * 新增模板
     * @param request
     * @return
     */
    Result<Void> addTemplate(TemplateRequest request);
    /**
     * 更新模板
     * @param request
     * @return
     */
    Result<Void> uptTemplate(TemplateRequest request);
    /**
     * 删除模板
     * @param id
     * @return
     */
    Result<Void> detelteTemplate(Long id);
    /**
     * 获取模板所有的查询条件
     * @param id
     * @return
     */
    Result<List<MetaParamConf>> getTemplateQueryParams(Long id);


}
