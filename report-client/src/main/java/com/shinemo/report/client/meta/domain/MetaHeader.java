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
     * 关联的主key 对应数据库字段
     */
    private String mainKey;
    /**
     * 数据库字段类型
     */
    private String dataType;
    /**
     * 字段type
     */
    private Integer type;
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
