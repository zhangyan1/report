package com.shinemo.report.core.user.facade.impl;

import com.shinemo.report.client.user.facade.UserInfoFacadeService;
import com.shinemo.report.core.user.service.UserInfoService;
import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息 facade 实现
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Service("userInfoFacadeService")
public class UserInfoFacadeServiceImpl implements UserInfoFacadeService {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 获取用户姓名，根据名称降序排序
     *
     * @param pageSize
     * @param currentPage
     * @return com.shinemo.client.common.Result&lt;com.shinemo.client.common.ListVO&lt;String&gt;&gt;
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Override
    public Result<ListVO<String>> findUserNameByDesc(Integer pageSize, Integer currentPage) {
        return userInfoService.findUserNameByDesc(pageSize, currentPage);
    }
}
