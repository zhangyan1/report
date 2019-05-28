package com.shinemo.report.client.base.conf.service;

import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import com.shinemo.report.client.base.conf.domain.MetaDbConf;
import com.shinemo.report.client.base.conf.query.MetaDbConfQuery;

public interface MetaDbConfService {

    /**
     * 查询数据库配置列表
     * @param query
     * @return
     */
    Result<ListVO<MetaDbConf>> findDbConf(MetaDbConfQuery query);
    /**
     * 查询数据库配置
     * @param query
     * @return
     */
    Result<MetaDbConf> getDbConf(MetaDbConfQuery query);


}
