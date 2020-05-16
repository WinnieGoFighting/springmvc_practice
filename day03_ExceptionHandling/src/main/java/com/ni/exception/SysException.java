package com.ni.exception;

/**
 * 自定义异常类
 */
public class SysException extends Exception {

    public SysException() {
        super();
    }

    public SysException(String msg) {
        super(msg);
    }
}
