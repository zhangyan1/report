package com.shinemo.report.core.base.conf.service.impl;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;
import com.shinemo.report.core.base.conf.service.MetaDbConfService;
import com.shinemo.report.dal.base.conf.wrapper.MetaDbConfWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MetaDbConfServiceImpl implements MetaDbConfService{

    @Resource
    private MetaDbConfWrapper metaDbConfWrapper;

    @Override
    public Result<ListVO<MetaDbConf>> findDbConf(MetaDbConfQuery query) {
        return metaDbConfWrapper.find(query);
    }

    @Override
    public Result<MetaDbConf> getDbConf(MetaDbConfQuery query) {
        return metaDbConfWrapper.get(query);
    }
}
