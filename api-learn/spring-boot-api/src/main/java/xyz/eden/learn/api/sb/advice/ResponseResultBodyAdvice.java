package xyz.eden.learn.api.sb.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import xyz.eden.learn.api.core.Result;
import xyz.eden.learn.api.core.ResultUtils;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/13 18:34
 */
@Slf4j
@RestControllerAdvice
public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof Result) {
            return o;
        }

        Result<Object> success = ResultUtils.getSuccess(o);
        if (aClass == StringHttpMessageConverter.class) {
            return "{\"code\":200,\"msg\":\"success\",\"data\":{\"a\":1,\"b\":2,\"c\":3,\"d\":4,\"e\":5}}";
        }

        return success;
    }
}
