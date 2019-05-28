package com.shinemo.report.client.base.conf.service;

import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;

public interface MetaColumnConfService {

    /**
     * 查询列设置
     * @param query
     * @return
     */
    Result<MetaColumnConf> getMetaColumnConf(MetaColumnConfQuery query);

    /**
     * 查询列设置列表
     * @param query
     * @return
     */
    Result<MetaColumnConf> findMetaColumnConf(MetaColumnConfQuery query);

    /**
     * 存储列设置
     * @param domain
     * @return
     */
    Result<MetaColumnConf> saveMetaColumnConf(MetaColumnConf domain);

    /**
     * 更新列设置
     * @param domain
     * @return
     */
    Result<MetaColumnConf> uptMetaColumnConf(MetaColumnConf domain);

}
