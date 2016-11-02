package com.github.broncho.springboot.webexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Author: ZhangXiao
 * Created: 2016/11/2
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = {"com.github.broncho.springboot"})
public class WebExampleApplication {
    
    
    @Bean
    public Docket vdtApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .groupName("web-example")
                .pathMapping("/")
                .apiInfo(
                        new ApiInfo(
                                "Spring Boot Web Example",
                                "Spring Boot Web Example接口在线调试器",
                                "1.0.0",
                                "NO",
                                new Contact("", "http://netposa.com/", ""),
                                "Netposa",
                                "Netposa"
                        )
                );
    }
    
    public static void main(String[] args) {
        SpringApplication.run(WebExampleApplication.class);
    }
}
