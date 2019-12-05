package com.kamjin.cryptdemo.base;

import lombok.Data;

/**
 * 返回基类
 *
 * @author kamjin1996
 */
@Data
public class BaseResult<T> {

    private int code;
    private String msg;
    private T data;

    private static final int RESPONSE_SUCCESS_CODE = 200;
    private static final String RESPONSE_SUCCESS_MSG = "SUCCESS";
    private static final int RESPONSE_FAILED_CODE = 501;

    public BaseResult() {
        code = RESPONSE_SUCCESS_CODE;
        msg = RESPONSE_SUCCESS_MSG;
    }

    public BaseResult(T data) {
        this();
        this.data = data;
    }

    public BaseResult(String msg) {
        this.code = RESPONSE_FAILED_CODE;
        this.msg = msg;
    }
}
