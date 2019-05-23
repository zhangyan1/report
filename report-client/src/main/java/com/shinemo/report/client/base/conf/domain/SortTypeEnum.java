package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  SortTypeEnum implements BaseEnum<SortTypeEnum>{

    ASC("升序",1),
    DESC("倒序",2);

    private @Getter final String name;
    private @Getter final int id;

    public static SortTypeEnum getById(int id) {
        SortTypeEnum[] enums = SortTypeEnum.values();
        for (SortTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }


}
