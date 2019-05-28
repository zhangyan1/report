package com.shinemo.report.core.base.conf.service;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaParamConf;
import com.shinemo.report.client.base.conf.query.MetaParamConfQuery;

import java.util.List;

public interface MetaParamConfService {

    /**
     * 查找参数
     * @param query
     * @return
     */
    Result<MetaParamConf> getMetaParamConf(MetaParamConfQuery query);

    /**
     * 查找参数
     * @param query
     * @return
     */
    Result<ListVO<MetaParamConf>> findMetaParamConf(MetaParamConfQuery query);

    /**
     * 存储参数
     * @param list
     * @return
     */
    Result<Void> saveMetaParamConfList(List<MetaParamConf> list);


}
