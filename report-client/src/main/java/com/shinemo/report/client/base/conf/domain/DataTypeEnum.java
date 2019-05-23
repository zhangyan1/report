package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  DataTypeEnum implements BaseEnum<DataTypeEnum>{

    TEXT("文本",1),
    NUMBER("数字",2),
    JSON_OBJECT("json对象",3);

    private @Getter
    final String name;
    private @Getter final int id;

    public static DataTypeEnum getById(int id) {
        DataTypeEnum[] enums = DataTypeEnum.values();
        for (DataTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }


}
