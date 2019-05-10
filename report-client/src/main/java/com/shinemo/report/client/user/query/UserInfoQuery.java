package com.shinemo.report.client.user.query;

import com.shinemo.client.common.QueryBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息查询对象
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoQuery extends QueryBase {
    private Long id;
    private String name;
    private Integer age;
}
