package com.simplilearn.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAop {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.simplilearn.spring.controller.UserController.*(..))")
    Object aroundAdviceAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.debug("Controller Executing: {}", joinPoint.getSignature());
        logger.debug("Controller Arguments: {}", Arrays.toString(joinPoint.getArgs()));

        Object value;
        try {
            value = joinPoint.proceed();
        } finally {
            // Do something useful, if you have to.
        }

        logger.debug("Controller Ended Execution: {}", joinPoint.getSignature());

        return value;
    }

}
