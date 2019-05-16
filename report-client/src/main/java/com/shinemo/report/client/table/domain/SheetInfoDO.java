package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import com.shinemo.report.client.meta.domain.MetaHeader;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SheetInfoDO extends BaseDO{

    private List<MetaHeader> headers;
    private List<Map<String,Object>> rows;

}
