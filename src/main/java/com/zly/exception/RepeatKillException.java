package com.zly.exception;

/**
 * 重复秒杀异常
 * 用户重复秒杀时抛出
 * Created by zly11 on 2018/6/17.
 */


public class RepeatKillException extends  SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
