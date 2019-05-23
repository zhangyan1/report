package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum SourceTypeEnum implements BaseEnum<SourceTypeEnum>{


    TEXT_CONF("文本配置",1),
    ACTION_SQL("sql动态获取",2);

    private @Getter final String name;
    private @Getter final int id;

    public static SourceTypeEnum getById(int id) {
        SourceTypeEnum[] enums = SourceTypeEnum.values();
        for (SourceTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }
}
