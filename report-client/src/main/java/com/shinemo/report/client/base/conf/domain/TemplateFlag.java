package com.shinemo.report.client.base.conf.domain;

import com.shinemo.client.common.Flag;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum TemplateFlag implements Flag.BaseEnum<TemplateFlag>{

    NEED_VERIFY(1, Flag.FLAG_MASK_1, "需要审核");

    private @Getter final int index;
    private @Getter final long mask;
    private @Getter final String desc;

    public static TemplateFlag getByIndex(final int index) {
        for (TemplateFlag type : TemplateFlag.values()) {
            if (type.index == index) {
                return type;
            }
        }
        return null;
    }
}
