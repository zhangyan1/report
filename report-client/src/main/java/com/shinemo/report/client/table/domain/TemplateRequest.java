package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import com.shinemo.client.common.FlagHelper;
import com.shinemo.report.client.base.conf.domain.TemplateFlag;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TemplateRequest extends BaseDO{

    /**
     * @see com.shinemo.report.client.base.conf.domain.TemplateTypeEnum
     */
    private Integer templateType;
    /**
     * sql 文案
     */
    private String sqlText;
    /**
     * 最大条数
     */
    private Long maxCount;
    /**
     * 数据库源id
     */
    private Long sourceId;
    /**
     * 模板名称
     */
    private String templateName;

    /**
     * List<ColumnInfo> 参数转换设置
     */
    private String columnListInfo;
    /**
     * List<TableParamInfo> 查询参数设置
     */
    private String paramListInfo;

    private FlagHelper flagHeper = FlagHelper.build();

    public void addTemplateFlag(TemplateFlag flag){
        this.flagHeper.add(flag);
    }

    public void removeTemplateFlag(TemplateFlag flag){
        this.flagHeper.remove(flag);
    }


}
