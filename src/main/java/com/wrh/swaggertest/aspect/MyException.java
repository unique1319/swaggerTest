package com.wrh.swaggertest.aspect;

public class MyException extends Exception {

    private static final long serialVersionUID = -7091852160789001861L;
    private String code = "500";
    private String msg;

    public static MyException error(String msg) {
        return new MyException("500", msg);
    }

    public static MyException unLogin() {
        return new MyException("304", "请重新登陆!");
    }

    public static MyException unAuth() {
        return new MyException("401", "没有权限");
    }

    public static MyException notFound() {
        return new MyException("404", "该资源不存在!");
    }

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
