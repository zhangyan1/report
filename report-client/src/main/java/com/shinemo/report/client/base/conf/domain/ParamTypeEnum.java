package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  ParamTypeEnum implements BaseEnum<ParamTypeEnum>{

    SELECT("下拉框",1),
    INPUT("输入框",2),
    DATE("日期框",3);

    private @Getter final String name;
    private @Getter final int id;

    public static ParamTypeEnum getById(int id) {
        ParamTypeEnum[] enums = ParamTypeEnum.values();
        for (ParamTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }



}
