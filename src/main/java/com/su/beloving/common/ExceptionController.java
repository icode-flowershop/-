package com.su.beloving.common;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.common.resp.Response;
import com.su.beloving.common.resp.ResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionController {
    static final int MAX_TRACE = 5;

    //提取异常的部分轨迹 取MAX_TRACE次方法调用
    private String geStackTrackTop(Exception e) {
        StringBuilder str = new StringBuilder();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i = 0; i < stackTrace.length && i < MAX_TRACE; i++) {
            str.append(" |< ").append(stackTrace[i]);
        }
        return "「异常Trace」" + str;
    }

    //提取异常对象的信息
    private String getMsg(Exception e) {
        return ">>" + "「异常信息」" + e.getMessage();
    }

    //默认的异常处理格式
    private Response defaultResponse(Response responseModel, Exception e) {
        log.error(geStackTrackTop(e) + getMsg(e));
        responseModel.setMsg(responseModel.getMsg() + getMsg(e));
        return responseModel;
    }

    //502 >> 请求未获得结果
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler({NoResultsException.class})
    Response noResultException(NoResultsException e) {
        return defaultResponse(ResponseFactory.createNoResult(), e);
    }

    //503 >> 错误的参数输入
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({ArgumentsIllegalException.class})
    Response argumentsIllegalException(ArgumentsIllegalException e) {
        return defaultResponse(ResponseFactory.createArgError(), e);
    }

    //500 >> 为记录的特殊错误
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    @ExceptionHandler({Exception.class})
    Response defaultException(Exception e) {
        return defaultResponse(ResponseFactory.createFailure(), e);
    }
}
