package com.shinemo.report.dal.base.conf.mapper;

import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.query.MetaParamConfQuery;

import java.util.List;


/**
 * Mapper
 * @ClassName: MetaParamConfMapper
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
public interface MetaParamConfMapper extends Mapper<MetaParamConfQuery, MetaParamConf> {

    void batchInsert(List<MetaParamConf> list);
}