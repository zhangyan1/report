package com.shinemo.report.test.core.user.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * UserInfoFacadeService 测试类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@MybatisTest
@RunWith(SpringRunner.class)
@MapperScan(basePackages = {
        "com.shinemo.report.dal.user.mapper",
})
@ComponentScan(basePackages = {
        "com.shinemo.report.dal.user.wrapper",
        "com.shinemo.report.core.user.service",
        "com.shinemo.report.core.user.facade",
})
@TestPropertySource(properties = {
        "spring.config.location=classpath:conf/application.yaml",
})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserInfoFacadeServiceTest {

}
