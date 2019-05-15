package com.shinemo.report.test.core.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

/**
 * 测试启动类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.shinemo.report.dal.configuration", "com.shinemo.report.core.configuration"})
@PropertySource("classpath:conf/application-dev.properties")
public class TableApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TableApplication.class, args);
    }
}
