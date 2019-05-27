package com.shinemo.report.core.table.facade.impl;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.table.domain.TemplateRequest;
import com.shinemo.report.client.table.facade.TemplateFacadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TemplateFacadeServiceImpl implements TemplateFacadeService{


    @Override
    public Result<List<MetaDbConf>> getDataSources() {
        return null;
    }

    @Override
    public Result<Void> addTemplate(TemplateRequest request) {
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
}
