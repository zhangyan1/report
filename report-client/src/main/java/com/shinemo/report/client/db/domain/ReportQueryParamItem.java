package com.shinemo.report.client.db.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 * zhangyan
 */
@Getter
@Setter
public class ReportQueryParamItem extends BaseDO{
    private String name;
    private String text;
    private boolean selected;

    public ReportQueryParamItem() {
    }

    public ReportQueryParamItem(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public ReportQueryParamItem(String name, String text, boolean selected) {
        this(name, text);
        this.selected = selected;
    }
}
