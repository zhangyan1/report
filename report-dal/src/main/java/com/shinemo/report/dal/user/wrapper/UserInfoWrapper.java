package com.shinemo.report.dal.user.wrapper;

import com.shinemo.report.client.user.domain.UserInfoDO;
import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;

/**
 * 用户信息 wrapper
 *
 * @author zhangyan
 * @date 2019-05-10
 */
public interface UserInfoWrapper {

    /**
     * 获取用户姓名，根据名称排序
     *
     * @param pageSize
     * @param currentPage
     * @param asc
     * @return com.shinemo.client.common.Result&lt;com.shinemo.client.common.ListVO&lt;String&gt;&gt;
     * @author zhangyan
     * @date 2019-05-10
     **/
    Result<ListVO<UserInfoDO>> findUserInfoOrderByName(Integer pageSize, Integer currentPage, Boolean asc);

    /**
     * 随机更新用户，当更新用户之后抛出异常，事物回滚
     *
     * @param pageSize
     * @param currentPage
     * @param asc
     * @return com.shinemo.client.common.Result&lt;Integer&gt;
     * @author zhangyan
     * @date 2019-05-10
     **/
    Result<Integer> randomUpdateUsers(Integer pageSize, Integer currentPage, Boolean asc);
}
