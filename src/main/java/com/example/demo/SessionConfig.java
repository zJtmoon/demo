package com.example.demo;

import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)//maxInactiveIntervalInSeconds: 设置 Session 失效时间，使用 Redis Session 之后
// ，原 Spring Boot 的 server.session.timeout 属性不再生效。

public class SessionConfig { //共享 Session
//    分布式系统中，Session 共享有很多的解决方案，其中托管到缓存中应该是最常用的方案之一，


}