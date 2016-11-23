package com.github.broncho.springboot.fiveminute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: ZhangXiao
 * Created: 2016/11/22
 */
@SpringBootApplication
public class FiveMinuteApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FiveMinuteApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(FiveMinuteApplication.class);
        LOGGER.info("----FiveMinuteApplication Started----");
    }
}
