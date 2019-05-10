package com.shinemo.report.core.configuration;

import com.shinemo.report.dal.configuration.ShineMoProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * consumer 配置类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Configuration
public class ConsumerConfiguration {

    @Resource
    private ShineMoProperties shineMoProperties;

    // /**
    //  * 通过 jce 远程调用 UserInfoFacadeService 的接口
    //  *
    //  * @return com.shinemo.jce.spring.AaceConsumerBean
    //  * @author zhangyan
    //  * @date 2019-05-10
    //  **/
    // @Bean(initMethod="init")
    // public AaceConsumerBean consumerUserInfoFacadeService() {
    //     ShineMoProperties.Proxy proxy = shineMoProperties.getJce().getConsumer().getProxy();
    //     AaceConsumerBean aaceConsumerBean = new AaceConsumerBean();
    //     aaceConsumerBean.setProxy(proxy.getEntpay());
    //     aaceConsumerBean.setInterfaceName(UserInfoFacadeService.class.getName());
    //     // aaceConsumerBean.setRegisterInterfaceName("xxx");
    //     // aaceConsumerBean.setAceType(AceType.HTTP.getName());
    //     // aaceConsumerBean.setRpcType(RpcType.ACE.getName());
    //     // aaceConsumerBean.setTimeout(5000);
    //     return aaceConsumerBean;
    // }
}