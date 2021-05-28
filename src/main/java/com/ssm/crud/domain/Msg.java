package com.ssm.crud.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Msg implements Serializable {

    private Integer code;
    private String msg;
    private Map<String, Object> extend = new HashMap<>();

    public static Msg success(){
        return new Msg(100, "处理成功");
    }

    public static Msg fail(){
        return new Msg(200, "处理失败");
    }

    public Msg add(String key, Object value){
        this.extend.put(key, value);
        return this;
    }

    public Msg() {
    }

    public Msg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
