package com.su.beloving.common.resp;

import com.su.beloving.common.constant.RESPONSE_CODE;

/**
 * 异常结果枚举类型，枚举所有的异常对象
 */
enum ResponseEnum {
    SUCCESS_RESPONSE(RESPONSE_CODE.SUCCESS, "成功"),
    FAILURE_EXCEPTION_RESPONSE(RESPONSE_CODE.FAILURE, "请求异常"),
    NO_RESULT_EXCEPTION_RESPONSE(RESPONSE_CODE.NO_RESULTS, "无有效数据"),
    ARGS_EXCEPTION_RESPONSE(RESPONSE_CODE.ARGS_ERROR,"入参格式不正确");

    public final Response response;

    ResponseEnum(int code, String msg) {
        response = new Response(code, msg);
    }
}

public class ResponseFactory {
    public static Response createSuccess(){
        return ResponseEnum.SUCCESS_RESPONSE.response.clone();
    }
    public static Response createFailure(){
        return ResponseEnum.FAILURE_EXCEPTION_RESPONSE.response.clone();
    }
    public static Response createNoResult(){
        return ResponseEnum.NO_RESULT_EXCEPTION_RESPONSE.response.clone();
    }
    public static Response createArgError(){
        return ResponseEnum.ARGS_EXCEPTION_RESPONSE.response.clone();
    }
    public static Response getSuccess() {
        return ResponseEnum.SUCCESS_RESPONSE.response;
    }

    public static Response getFailure() {
        return ResponseEnum.FAILURE_EXCEPTION_RESPONSE.response;
    }
    public static Response getNoResult() {
        return ResponseEnum.NO_RESULT_EXCEPTION_RESPONSE.response;
    }
    public static Response getArgError() {
        return ResponseEnum.ARGS_EXCEPTION_RESPONSE.response;
    }

}
