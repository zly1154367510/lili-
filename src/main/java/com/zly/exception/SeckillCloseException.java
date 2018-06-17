package com.zly.exception;

/**
 * 秒杀关闭异常
 * Created by zly11 on 2018/6/17.
 */
public class SeckillCloseException extends SeckillException{

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
