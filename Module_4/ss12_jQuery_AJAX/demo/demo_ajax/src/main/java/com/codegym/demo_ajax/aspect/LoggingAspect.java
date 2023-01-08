package com.codegym.demo_ajax.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // cách 1: định nghĩa method point cut sau đó khai báo advice với method đó
    @Pointcut("execution(* com.codegym.demo_ajax.service.StudentServiceImpl.fi*(..))")
    public void allStudentService(){}

    @Before("allStudentService()")
    public void writeLogStudentService(JoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        logger.info("Before: call " + methodName + " |writeLogStudentService");
    }
}
