package com.shinemo.report.dal.base.conf.mapper;

import com.shinemo.client.dal.mapper.Mapper;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;

import java.util.List;


/**
 * Mapper
 * @ClassName: MetaColumnConfMapper
 * @author zhangyan
 * @Date 2019-05-14 10:13:20
 */
public interface MetaColumnConfMapper extends Mapper<MetaColumnConfQuery, MetaColumnConf> {

    void batchInsert(List<MetaColumnConf> list);

}