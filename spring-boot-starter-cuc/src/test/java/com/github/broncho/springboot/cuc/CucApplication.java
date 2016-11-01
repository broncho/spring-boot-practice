package com.github.broncho.springboot.cuc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@SpringBootApplication
public class CucApplication {
    
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
        for (long v : value) {
            System.out.println("Original=" + v + " Dest=" + conversion.cuc(v));
        }
    }
}
