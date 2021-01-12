package xyz.eden.learn.api.core;


import java.util.Objects;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/4 16:17
 */
public class ResultUtils {

    /**
     * 获取 Result
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> getResult(Integer code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> getResult(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

    /**
     * 获取 Success
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> getSuccess(T data) {
        return new Result<>(ResultConstant.SUCCESS_CODE, ResultConstant.SUCCESS_MSG, data);
    }

    /**
     * 获取服务错误
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> getServiceError() {
        return new Result<>(ResultConstant.SERVICE_ERROR_CODE, ResultConstant.SERVICE_ERROR_MSG);
    }

    /**
     * 失败
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Boolean isFail(Result<T> result) {
        return !isSuccess(result);
    }

    /**
     * success
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Boolean isSuccess(Result<T> result) {
        return (result != null) && Objects.equals(result.getCode(), ResultConstant.SUCCESS_CODE);
    }

}
