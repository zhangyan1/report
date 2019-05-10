package com.shinemo.report.core.user.service.impl;

import com.shinemo.report.client.user.domain.UserInfoDO;
import com.shinemo.report.core.user.service.UserInfoService;
import com.shinemo.report.dal.user.wrapper.UserInfoWrapper;
import com.shinemo.client.common.ListVO;
import com.shinemo.client.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * 用户信息 service 实现类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Slf4j
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoWrapper userInfoWrapper;

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
        Result<ListVO<UserInfoDO>> result = userInfoWrapper.findUserInfoOrderByName(pageSize, currentPage, false);
        if (!result.hasValue()) {
            log.error("[findUserNameByDesc] userInfoWrapper.findUserInfoOrderByName has error, param:{},{},{},result:{}", pageSize, currentPage, false, result);
            return Result.error(result);
        }
        ListVO<UserInfoDO> value = result.getValue();
        value.getRows().stream().map(val -> val.getName()).collect(Collectors.toList());
        return Result.success(ListVO.list(value.getRows().stream().map(val -> val.getName()).collect(Collectors.toList()), value.getTotalCount(), value.getCurrentPage(), value.getPageSize()));
    }
}
