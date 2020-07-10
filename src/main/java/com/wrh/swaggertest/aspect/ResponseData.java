package com.wrh.swaggertest.aspect;

import java.io.Serializable;

public class ResponseData implements Serializable {
    private static final long serialVersionUID = 1L;

    String code;
    String msg;
    Object data;

    public static ResponseData success() {
        return new ResponseData("200", "ok", null);
    }

    public static ResponseData success(Object data) {
        return new ResponseData("200", "ok", data);
    }

    public static ResponseData error() {
        return new ResponseData("500", "服务器出现错误!", null);
    }

    public static ResponseData error(String msg) {
        return new ResponseData("500", msg, null);
    }

    public static ResponseData unLogin() {
        return new ResponseData("304", "请重新登陆!", null);
    }

    public static ResponseData noInfo() {
        return new ResponseData("305", "请填写信息!", null);
    }

    public static ResponseData unAuth() {
        return new ResponseData("401", "没有权限", null);
    }

    public static ResponseData notFound() {
        return new ResponseData("404", "该资源不存在!", null);
    }


    public static ResponseData repeatSubmit() {
        return new ResponseData("500001", "请勿重复提交!", null);
    }

    public ResponseData(String code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
