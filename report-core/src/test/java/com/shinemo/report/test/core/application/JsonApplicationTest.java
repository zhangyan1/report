package com.shinemo.report.test.core.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

/**
 * 测试启动类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@SpringBootApplication
@MapperScan(basePackages = {
        "com.shinemo.report.dal.user.mapper",
})
@ComponentScan(basePackages = {
        "com.shinemo.report.core",
})
@TestPropertySource(properties = {
        "spring.config.location=classpath:conf/application-dev.properties",
})
public class JsonApplicationTest {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JsonApplicationTest.class, args);
    }
}
