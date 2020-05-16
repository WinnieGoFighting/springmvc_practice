package com.ni.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    //controller 那边出现异常，会使得这个方法执行
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        SysException e = null;
        if (ex instanceof SysException)
            e=(SysException)ex;
        else
            e = new SysException("系统正在维护");
        ModelAndView mav = new ModelAndView();
        mav.addObject("errMsg",e.getMessage());
        mav.setViewName("error");
        return mav;
    }
}
