package com.pyshy.entity;

import java.io.Serializable;

public class Message implements Serializable{

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
