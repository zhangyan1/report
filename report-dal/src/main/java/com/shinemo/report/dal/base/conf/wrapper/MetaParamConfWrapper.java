package com.shinemo.report.dal.base.conf.wrapper;

import javax.annotation.Resource;

import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.query.MetaParamConfQuery;
import com.shinemo.report.dal.base.conf.mapper.MetaParamConfMapper;
import org.springframework.stereotype.Service;
import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.client.dal.wrapper.Wrapper;


/**
 * Wrapper
 * @ClassName: MetaParamConfWrapper
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Service
public class MetaParamConfWrapper extends Wrapper<MetaParamConfQuery, MetaParamConf> {

    @Resource
    private MetaParamConfMapper metaParamConfMapper;

    @Override
    public Mapper<MetaParamConfQuery, MetaParamConf> getMapper() {
        return metaParamConfMapper;
    }
}