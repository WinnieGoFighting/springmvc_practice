package com.ni.controller;

import com.ni.domain.Account;
import com.ni.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username,String password) {
        System.out.println("执行了。。");
        System.out.println("username: "+username);
        System.out.println("username: "+password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String testParam(Account a) {
        System.out.println(a);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String testParam(User u) {
        System.out.println(u);
        return "success";
    }
}
