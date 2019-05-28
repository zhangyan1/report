package com.shinemo.report.client.table.domain;

import com.shinemo.client.common.BaseDO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserInfo extends BaseDO{

    private Long uid;
    private String userName;
}
