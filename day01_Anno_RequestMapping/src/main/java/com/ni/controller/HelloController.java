package com.ni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path="/user")
@Controller
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello() {
        System.out.println("Hello StringMVC");
        return "success";
    }

    @RequestMapping(path="/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("测试requestMapping注解");
        return "success";
    }
}
