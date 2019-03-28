package com.example.demo;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/*
项目老的用spring写的，新的升级到了springboot,原代码中有在web.xml中定义过滤器，在boot中，自然没法这样用了，因而看了看boot如何使用自定义过滤器。

在springboot 中，主要是靠FilterRegistrationBean 这个类来提供这样的功能。具体而言：
自定义Filter需要两个步骤：
实现Filter【javax.servlet.Filter】接口，实现Filter方法
添加 @Configuration 注解，将自定义Filter加入过滤链

 */
@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());// 注入过滤器
        //  //过滤应用程序中所有资源,当前应用程序根下的所有文件包括多级子目录下的所有文件，注意这里*前有“/”
        registration.addUrlPatterns("/*");//其中addUrlPatterns是设置过滤的请求路径的
        registration.addInitParameter("paramName", "paramValue"); //每一个 filter 都有一个 init 方法 ，可以再这个 方法中通过 getInitParamter("key"); key 就是 param-name的值，来获取对应的参数值
        //常用的 就是 设置编码过滤器 ， 例如 ： <init-param><param-name>encoding</param-name><parma-value>UTF-8</param-vaue></init-param>

        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
//-----------------------------------------------------------------------------------------
//    那如果有多个过虑器，怎么指定执行的顺序呢？
//    通过 registration.setOrder(1);  来设置，例如：
//    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new TestFilter());
//        registration.addUrlPatterns("/webapi/*"); //
//        registration.addInitParameter("paramName", "paramValue"); //
//        registration.setName("testFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean authFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean(new AuthFilter());
//        registration.addUrlPatterns("/webapi/*"); //
//        registration.addInitParameter("paramName", "paramValue"); //
//        registration.setName("authFilter");
//        registration.setOrder(2);
//        return registration;
//    }
//---------------------------------------------------------------------------------------------


    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
    }
}