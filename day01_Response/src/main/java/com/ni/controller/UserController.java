package com.ni.controller;

import com.ni.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    //返回字符串的情况
    @RequestMapping("/testString")
    public String testString(Model model) {
        //模拟从数据库中查询出User对象
        User u = new User();
        u.setUsername("美美");
        u.setAge(15);
        u.setPassword("12345");
        //把对象存在request域中
        model.addAttribute("user",u);
        return "success";
    }

    //返回void
    //默认情况找寻 testVoid.jsp 页面跳转
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发,此时viewResolver不能解析页面，需要自己写路径
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //写return可以不让转发以后的代码执行

        //重定向,不能访问到WEB-INF下的pages
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;

        //直接进行响应
//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().print("你好");
//        return;
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        User u = new User();
        u.setUsername("美美");
        u.setAge(15);
        u.setPassword("12345");
        ModelAndView mav = new ModelAndView();
        mav.addObject("user",u);
        mav.setViewName("success");
        return mav;
    }

    //转发和重定向的 forward和redirect
    //此时也没有办法用试图解析器
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {
        //return "forward:/WEB-INF/pages/success.jsp";
        //redirect:此时不需要写全路径，底层已经封装好
        //用redirect时 request域中的信息可以共享？？
        return "redirect:/index.jsp";
    }

    //模拟异步请求响应
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println(user);
        //模拟查询数据库
        user.setUsername("haha");
        user.setAge(20);
        // 响应
        return user;
    }
}