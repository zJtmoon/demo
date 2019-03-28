package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication   //@RestController注解:其实就是@Controller和@ResponseBody注解加在一起
//@ServletComponentScan 这个注解是新的filter的用法通过 @WebFilter 注解来配置，不要@bean和@Configuration
@MapperScan("com.example.demo.mapper")//启动类中添加对 mapper 包扫描@MapperScan 或者直接在 Mapper 类上面添加注解@Mapper，建议使用上面那种，不然每个 mapper 加个注解也挺麻烦的

public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

}
