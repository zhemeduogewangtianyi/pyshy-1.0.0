package com.pyshy.common.responseResult;

import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private Integer code = CommonEnum.INT_200.getCode();

    private String message = BizEnum.SUCCESS.getMessage();

    private Object rows;

    private Integer total;

    public ResponseResult() {

    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message,Object rows) {
        this.code = code;
        this.message = message;
        this.rows = rows;
    }

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

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ResponseResult(Integer code, String message, Object rows, Integer total) {
        this.code = code;
        this.message = message;
        this.rows = rows;
        this.total = total;
    }
}
