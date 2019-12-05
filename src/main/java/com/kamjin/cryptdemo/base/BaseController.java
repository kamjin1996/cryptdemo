package com.kamjin.cryptdemo.base;

/**
 * 控制器基类
 *
 * @author kamjin1996
 */
public abstract class BaseController<T> {

    protected BaseResult response() {
        return new BaseResult();
    }

    protected BaseResult<T> response(T data) {
        return new BaseResult(data);
    }

    protected BaseResult responseMsg(String msg) {
        return new BaseResult(msg);
    }
}
