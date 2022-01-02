package com.su.beloving.common.exception;

/**
 * 无结果异常，请求的执行为获取有效结果
 */
public class NoResultsException extends Exception {
    public NoResultsException(String message) {
        super(message);
    }
}
