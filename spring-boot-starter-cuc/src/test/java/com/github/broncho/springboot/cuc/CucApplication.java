package com.github.broncho.springboot.cuc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@SpringBootApplication
public class CucApplication {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CucApplication.class);
    
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CucApplication.class);
        ChineseUnitConversion conversion = context.getBean(ChineseUnitConversion.class);
        long[] value = {
                101,
                10034,
                23452,
                200022244,
                2999991233L,
                9999223333L
        };
        LOGGER.info("---Cuc Start---");
        for (long v : value) {
            LOGGER.info("Original = {}  Dest = {} ", v, conversion.cuc(v));
        }
        LOGGER.info("---Cuc End---");
    }
}
