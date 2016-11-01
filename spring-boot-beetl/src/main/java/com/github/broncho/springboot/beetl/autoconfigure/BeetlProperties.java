package com.github.broncho.springboot.beetl.autoconfigure;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.IOException;

/**
 * application.properties
 * beelt.charset=UTF-8
 * beelt.resource-map.resource.root=/template
 * ...
 * <p>
 * Author: ZhangXiao
 * Created: 2016/11/1
 */
@ConfigurationProperties(prefix = "beelt")
@ConditionalOnClass(value = {GroupTemplate.class, Configuration.class})
public class BeetlProperties extends Configuration {
    
    public BeetlProperties() throws IOException {
        super();
    }
}
