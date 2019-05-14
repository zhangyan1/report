package com.shinemo.report.dal.base.conf.wrapper;

import javax.annotation.Resource;

import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;
import com.shinemo.report.dal.base.conf.mapper.MetaDbConfMapper;
import org.springframework.stereotype.Service;
import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.client.dal.wrapper.Wrapper;


/**
 * Wrapper
 * @ClassName: MetaDbConfWrapper
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Service
public class MetaDbConfWrapper extends Wrapper<MetaDbConfQuery, MetaDbConf> {

    @Resource
    private MetaDbConfMapper metaDbConfMapper;

    @Override
    public Mapper<MetaDbConfQuery, MetaDbConf> getMapper() {
        return metaDbConfMapper;
    }
}