package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableInfoDO extends BaseDO{


    private String fileName;
    private List<SheetInfoDO> sheetInfos;

}
