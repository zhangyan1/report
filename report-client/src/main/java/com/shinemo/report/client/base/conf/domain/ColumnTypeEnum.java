package com.shinemo.report.client.base.conf.domain;


import com.shinemo.client.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ColumnTypeEnum implements BaseEnum<ColumnTypeEnum>{

    NOMOR_COLUMN("普通列",1),
    COUNT_SUB_COLUMN("计算子列",2),
    COUNT_COLUMN("计算列",4);

    private @Getter final String name;
    private @Getter final int id;

    public static ColumnTypeEnum getById(int id) {
        ColumnTypeEnum[] enums = ColumnTypeEnum.values();
        for (ColumnTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }
}
