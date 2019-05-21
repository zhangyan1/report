package com.shinemo.report.client.db.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.shinemo.client.common.BaseEnum;
import com.shinemo.client.common.Flag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum  JdbcDataTypeEnum implements BaseEnum<JdbcDataTypeEnum> {


    CHAR("CHAR", 1),
    VARCHAR("VARCHAR",2),
    LONGVARCHAR("INT",3);

    private @Getter final String name;
    private @Getter final int id;

    @JsonCreator
    public static JdbcDataTypeEnum getById(int id) {
        JdbcDataTypeEnum[] enums = JdbcDataTypeEnum.values();
        for (JdbcDataTypeEnum e : enums) {
            if (e.id == id) {
                return e;
            }
        }
        throw new IllegalArgumentException("not support");
    }
}
