package com.shinemo.report.client.meta.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * 表头
 */
@Getter
@Setter
public class MetaHeader  extends BaseDO{

    private Integer index;
    /**
     * 关联key
     */
    private String key;
    /**
     * 展示名称
     */
    private String value;
    /**
     * 设置样式
     */
    private CellStyle cellStyle;
}
