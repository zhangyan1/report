package com.shinemo.report.dal.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * ShineMo 配置文件
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "shinemo")
@EnableConfigurationProperties(ShineMoProperties.class)
public class ShineMoProperties {
    /**
     * 应用相关配置
     */
    @Valid
    @NotNull
    private Application application;
    /**
     * 通知邮箱列表
     */
    @NotNull
    private List<String> notificationEmail;

    /**
     * 应用相关配置
     *
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Data
    public static class Application {
        /**
         * 环境
         *
         * @see com.shinemo.client.util.EnvUtil#ENV_DAILY
         * @see com.shinemo.client.util.EnvUtil#ENV_DEV
         * @see com.shinemo.client.util.EnvUtil#ENV_PREF
         * @see com.shinemo.client.util.EnvUtil#ENV_SANDBOX
         * @see com.shinemo.client.util.EnvUtil#ENV_ONLINE
         */
        @NotNull
        private Integer env;
        /**
         * 数据库名称
         */
        @NotNull
        private String databaseName;
        /**
         * 域名
         */
        @NotNull
        private String domain;
    }
}
