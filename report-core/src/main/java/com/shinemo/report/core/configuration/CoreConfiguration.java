package com.shinemo.report.core.configuration;

import com.shinemo.report.dal.configuration.ShineMoProperties;
import com.shinemo.client.mail.SendMailService;
import com.shinemo.client.mail.SendMailServiceWrapper;
import com.shinemo.client.util.EnvUtil;
import com.shinemo.jce.common.config.CenterConfig;
import com.shinemo.jce.common.config.ConsumerConfig;
import com.shinemo.jce.common.config.ProviderConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * core 配置类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Configuration
@ComponentScan(basePackages = {
        "com.shinemo.report.core"
})
public class CoreConfiguration {

    @Resource
    private ShineMoProperties shineMoProperties;

    /**
     * EnvUtil
     *
     * @param envName
     * @return com.shinemo.client.util.EnvUtil
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Bean
    public EnvUtil envUtil(@Value("${spring.profiles.active}") String envName) {
        ShineMoProperties.Application application = shineMoProperties.getApplication();
        EnvUtil envUtil = new EnvUtil();
        envUtil.setEnv(application.getEnv());
        envUtil.setEnvName(envName);
        return envUtil;
    }

    /**
     * 发邮件类
     *
     * @param applicationName
     * @return com.shinemo.client.mail.SendMailServiceWrapper
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Bean
    public SendMailServiceWrapper sendMailServiceWrapper(@Value("${spring.application.name}") String applicationName) {
        SendMailServiceWrapper sendMailServiceWrapper = new SendMailServiceWrapper();
        sendMailServiceWrapper.setSendMailService(new SendMailService());
        sendMailServiceWrapper.setApplicationName(applicationName);
        sendMailServiceWrapper.setEmails(shineMoProperties.getNotificationEmail());
        return sendMailServiceWrapper;
    }
}
