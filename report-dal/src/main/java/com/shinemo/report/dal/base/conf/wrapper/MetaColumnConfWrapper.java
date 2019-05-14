package com.shinemo.report.dal.base.conf.wrapper;

import javax.annotation.Resource;

import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;
import com.shinemo.report.dal.base.conf.mapper.MetaColumnConfMapper;
import org.springframework.stereotype.Service;
import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.client.dal.wrapper.Wrapper;


/**
 * Wrapper
 * @ClassName: MetaColumnConfWrapper
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
@Service
public class MetaColumnConfWrapper extends Wrapper<MetaColumnConfQuery, MetaColumnConf> {

    @Resource
    private MetaColumnConfMapper metaColumnConfMapper;

    @Override
    public Mapper<MetaColumnConfQuery, MetaColumnConf> getMapper() {
        return metaColumnConfMapper;
    }
}