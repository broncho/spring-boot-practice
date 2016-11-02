package com.github.broncho.springboot.beetl.autoconfigure;

import org.beetl.core.GroupTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@Configuration
@ConditionalOnClass(value = {GroupTemplate.class, org.beetl.core.Configuration.class})
@EnableConfigurationProperties(value = {BeetlProperties.class})
public class BeetlAutoConfiguration {
    
    @Bean
    public GroupTemplate groupTemplate(BeetlProperties beetlProperties) {
        return new GroupTemplate(beetlProperties);
    }
}
