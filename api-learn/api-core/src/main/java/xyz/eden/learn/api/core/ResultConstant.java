package xyz.eden.learn.api.core;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/4 17:32
 */
public interface ResultConstant {

    /**
     * 未知错误 Code
     */
    Integer UNKNOWN_ERROR_CODE = 999;
    /**
     * 未知错误 Msg
     */
    String UNKNOWN_ERROR_MSG = "未知错误";

    /**
     * Success Code
     */
    Integer SUCCESS_CODE = 200;
    /**
     * Success Msg
     */
    String SUCCESS_MSG = "success";
    /**
     * 服务错误 Code
     */
    Integer SERVICE_ERROR_CODE = 500;
    /**
     * 服务错误 Msg
     */
    String SERVICE_ERROR_MSG = "系统出现异常";
    /**
     * 服务器错误友好 MSG
     */
    String SERVICE_ERROR_AMITY_MSG = "服务器忙请稍后再试";
}
