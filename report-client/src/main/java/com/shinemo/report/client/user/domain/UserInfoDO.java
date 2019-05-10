package com.shinemo.report.client.user.domain;

import com.shinemo.client.common.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息实体类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDO extends BaseDO {
    private Long id;
    private String name;
    private Integer age;
}
