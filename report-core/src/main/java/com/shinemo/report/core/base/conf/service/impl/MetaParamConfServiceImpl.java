package com.shinemo.report.core.base.conf.service.impl;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.query.MetaParamConfQuery;
import com.shinemo.report.core.base.conf.service.MetaParamConfService;
import com.shinemo.report.dal.base.conf.wrapper.MetaParamConfWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MetaParamConfServiceImpl implements MetaParamConfService {

    @Resource
    private MetaParamConfWrapper metaParamConfWrapper;

    @Override
    public Result<MetaParamConf> getMetaParamConf(MetaParamConfQuery query) {
        return metaParamConfWrapper.get(query);
    }

    @Override
    public Result<ListVO<MetaParamConf>> findMetaParamConf(MetaParamConfQuery query) {
        return metaParamConfWrapper.find(query);
    }

    @Override
    public Result<MetaParamConf> saveMetaParamConf(MetaParamConf domain) {
        return metaParamConfWrapper.insert(domain);
    }

    @Override
    public Result<MetaParamConf> uptMetaParamConf(MetaParamConf domain) {
        return metaParamConfWrapper.update(domain);
    }
}
