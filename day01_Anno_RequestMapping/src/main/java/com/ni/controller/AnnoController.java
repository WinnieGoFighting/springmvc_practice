package com.ni.controller;

import com.ni.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }


    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name="id") String sid) {
        System.out.println(sid);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name="Accept") String accept) {
        System.out.println(accept);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(name="JSESSIONID") String cookinfo) {
        System.out.println(cookinfo);
        return "success";
    }

    //@ModelAttribute
    //1.当用于修饰方法时
    //2.当用于修饰参数时

    //ModelAttribute 的第二种方法演示
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User u) {
        System.out.println(u);
        return "success";
    }


    @ModelAttribute
    public User getUser(String uname){
        User u = new User();
        u.setUname(uname);
        u.setAge(12);
        u.setDate(new Date());
        return u;
    }

    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("user") User u) {
        System.out.println(u);
        return "success";
    }

    //ModelAttribute 的第二种方法演示
    @ModelAttribute
    public void getUser2(String uname, Map<String,User> map){
        User u = new User();
        u.setUname(uname);
        u.setAge(12);
        u.setDate(new Date());
        map.put("user",u);
    }

    //SessionAttributes用于方法间数据的共享
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        //底层会存储到request域中
        model.addAttribute("msg","美美");
        return "success";
    }

    //从session域中获取值
    @RequestMapping("/testSessionAttributes2")
    public String testSessionAttributes2(ModelMap model) {
        //底层会存储到request域中
        String msg = (String)model.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/testSessionAttributes3")
    public String testSessionAttributes3(SessionStatus status) {
        status.setComplete();
        return "success";
    }

}
