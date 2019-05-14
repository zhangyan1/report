package com.shinemo.report.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@SpringBootApplication(scanBasePackages = {
        "com.shinemo.report.dal.configuration",
        "com.shinemo.report.core.configuration",
        "com.shinemo.report.web.configuration",
})
public class Application extends SpringBootServletInitializer {

    private static final Class<Application> application = Application.class;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.application);
    }

    public static void main(String[] args) throws Exception {
        // app_env 在 10.0.10.42 的 publish.site 表中
        // -Dapp_env=-1 -Dconfig_url=http://10.0.10.62/myconf/conf/dispatch -Dapp_name=report
        // java -Dapp_env=-1 -Dconfig_url=http://10.0.10.62/myconf/conf/dispatch -Dapp_name=report -jar report-web/target/report.jar
        args= new String[]{"--spring.config.location=classpath:conf/application-dev.properties"};
        SpringApplication.run(application, args);
    }

}
