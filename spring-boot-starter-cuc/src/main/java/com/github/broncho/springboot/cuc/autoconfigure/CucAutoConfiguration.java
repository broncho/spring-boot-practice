package com.github.broncho.springboot.cuc.autoconfigure;

import com.github.broncho.springboot.cuc.ChineseUnitConversion;
import com.github.broncho.springboot.cuc.core.DefaultChineseUnitConversion;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@Configuration
@EnableConfigurationProperties(CucProperties.class)
public class CucAutoConfiguration {
    
    @Bean
    public ChineseUnitConversion chineseUnitConversion(CucProperties properties) {
        return new DefaultChineseUnitConversion(properties);
    }
}
