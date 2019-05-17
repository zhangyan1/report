package com.shinemo.report.web.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * web 配置类
 *
 * @author zhangyan
 * @date 2019-05-10
 */
@Configuration
@ComponentScan(basePackages = {
        "com.shinemo.report.web.controller",
        "com.shinemo.report.web.table.controller"
})
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Resource(name = "localhostInterceptor")
    private HandlerInterceptor localhostInterceptor;

    @Resource(name = "intranetInterceptor")
    private HandlerInterceptor intranetInterceptor;

    @Resource(name = "loggerFilter")
    private Filter loggerFilter;

    /**
     * 添加拦截器
     *
     * @param registry
     * @return void
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // AntPathMatcher.match(String pattern, String path)
        // 当要匹配所有链接时，urlPattern="/**"是最好的
        registry.addInterceptor(localhostInterceptor).addPathPatterns("/backdoor/**");
        registry.addInterceptor(intranetInterceptor).addPathPatterns("/shutdown");
        super.addInterceptors(registry);
    }

    /**
     * 添加过滤器
     *
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     * @author zhangyan
     * @date 2019-05-10
     **/
    @Bean
    public FilterRegistrationBean registerLoggerFilter() {
        // org.apache.catalina.core.ApplicationFilterFactory.createFilterChain(ServletRequest request, Wrapper wrapper, Servlet servlet)
        // matchDispatcher(FilterMap filterMap, DispatcherType type)
        // matchFiltersURL(FilterMap filterMap, String requestPath) -> matchFiltersURL(String testPath, String requestPath)
        // 当要匹配所有链接时，urlPattern="*"是最好的
        FilterRegistrationBean registration = new FilterRegistrationBean(loggerFilter);
        registration.addUrlPatterns("*");
        registration.addInitParameter("applicationName", "report");
        registration.setName("loggerFilter");
        return registration;
    }
}
