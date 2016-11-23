package com.github.broncho.springboot.fiveminute.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ZhangXiao
 * Created: 2016/11/22
 */
@RestController
public class IndexController {
    
    @Autowired
    private ServerProperties properties;
    
    @RequestMapping("/index")
    public ServerProperties index() {
        return properties;
    }
}
