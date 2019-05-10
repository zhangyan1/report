package com.shinemo.report.core.configuration;

import com.shinemo.report.client.user.facade.UserInfoFacadeService;
import com.shinemo.jce.spring.AaceProviderBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * provider 配置类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Configuration
public class ProviderConfiguration {

    /**
     * UserInfoFacadeService 提供 jce 方式调用
     *
     * @param userInfoFacadeService
     * @return com.shinemo.jce.spring.AaceProviderBean
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Bean(initMethod="init")
    @DependsOn("userInfoFacadeService")
    public AaceProviderBean providerUserInfoFacadeService(@Qualifier("userInfoFacadeService") UserInfoFacadeService userInfoFacadeService) {
        AaceProviderBean aaceProviderBean = new AaceProviderBean();
        aaceProviderBean.setInterfaceName(UserInfoFacadeService.class.getName());
        aaceProviderBean.setTarget(userInfoFacadeService);
        // aaceProviderBean.setRpcType(RpcType.ACE.getName());
        return aaceProviderBean;
    }
}