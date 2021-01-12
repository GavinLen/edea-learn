package xyz.eden.learn.springboot.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2021/1/11 17:25
 */
@Slf4j
@Aspect
@Component
public class LogPrintByAop {

    @Pointcut(value = "execution(* xyz.eden.learn.springboot.web.service.impl.*.*(..))")
    public void pointcutMethod() {

    }

    @Around(value = "pointcutMethod()")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            log.info("print");
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

}
