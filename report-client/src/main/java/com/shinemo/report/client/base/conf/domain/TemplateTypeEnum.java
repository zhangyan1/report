package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.BaseEnum;
import com.shinemo.report.client.common.domain.DeleteStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum  TemplateTypeEnum implements BaseEnum<TemplateTypeEnum>{

    ACTION_SQL("动态sql",1),
    TABLE_NAME("表名",2);

    private @Getter final String name;
    private @Getter final int id;

    public static TemplateTypeEnum getById(int id) {
        TemplateTypeEnum[] enums = TemplateTypeEnum.values();
        for (TemplateTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }
}
