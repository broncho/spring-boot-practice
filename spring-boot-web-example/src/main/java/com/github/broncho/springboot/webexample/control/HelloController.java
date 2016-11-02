package com.github.broncho.springboot.webexample.control;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ZhangXiao
 * Created: 2016/11/2
 */
@Api(description = "Hello")
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    
    @Autowired
    private GroupTemplate groupTemplate;
    
    @ApiOperation(value = "问候接口")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable("name") String name) {
        Template template = groupTemplate.getTemplate("/hello.beetl");
        template.binding("name", name);
        return template.render();
    }
}

