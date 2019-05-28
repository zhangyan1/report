package com.shinemo.report.core.base.conf.service;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaColumnConf;
import com.shinemo.report.client.base.conf.query.MetaColumnConfQuery;

import java.util.List;

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
    Result<ListVO<MetaColumnConf>> findMetaColumnConf(MetaColumnConfQuery query);

    /**
     * 存储列设置
     * @param
     * @return
     */
    Result<Void> saveMetaColumnConfList(List<MetaColumnConf> lists);
}
