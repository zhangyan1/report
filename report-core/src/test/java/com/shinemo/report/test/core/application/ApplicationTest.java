package com.shinemo.report.test.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 测试启动类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ApplicationTest {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationTest.class, args);
    }
}
