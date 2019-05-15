package com.shinemo.report.client.meta.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;


/**
 * 单元格
 */
@Getter
@Setter
public class MetaCell extends BaseDO{
    /**
     * 关联key
     */
    private String key;
    /**
     * 值
     */
    private String value;
}
