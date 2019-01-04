package com.study.example_mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource getDruidDataSource(){
        return new DruidDataSource();
    }

    //配置一个管理后台的servlet，servlet主键注册
    //需要用到anlibaba的数据源，需要注册alibaba的StatViewServlet，拦截/druid/下的所有请求
    //一般用自己的servlet，也需要用这样的方法进行注册，自己的servlet一般继承HttpServlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("loginUsername","admin");
        parameterMap.put("loginPassword","123456");
        parameterMap.put("allow","");//默认允许所有访问
        parameterMap.put("deny","192.168.121.1");
        bean.setInitParameters(parameterMap);
        return bean;
    }

    //配置一个wen监听的filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.jsp,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
