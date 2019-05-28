package com.shinemo.report.client.base.conf.service.impl;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;
import com.shinemo.report.client.base.conf.service.MetaColumnConfService;
import com.shinemo.report.dal.base.conf.wrapper.MetaColumnConfWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MetaColumnConfServiceImpl implements MetaColumnConfService {

    @Resource
    private MetaColumnConfWrapper metaColumnConfWrapper;

    @Override
    public Result<MetaColumnConf> getMetaColumnConf(MetaColumnConfQuery query) {
        return metaColumnConfWrapper.get(query);
    }

    @Override
    public Result<ListVO<MetaColumnConf>> findMetaColumnConf(MetaColumnConfQuery query) {
        return metaColumnConfWrapper.find(query);
    }

    @Override
    public Result<MetaColumnConf> saveMetaColumnConf(MetaColumnConf domain) {
        return metaColumnConfWrapper.insert(domain);
    }

    @Override
    public Result<MetaColumnConf> uptMetaColumnConf(MetaColumnConf domain) {
        return metaColumnConfWrapper.update(domain);
    }
}
