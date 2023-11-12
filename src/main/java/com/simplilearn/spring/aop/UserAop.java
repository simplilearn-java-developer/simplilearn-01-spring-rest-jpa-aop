package com.simplilearn.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(com.simplilearn.spring.aop.annotation.Loggable)")
    void myAdvice(JoinPoint joinPoint) {
        logger.debug("Executing myAdvice!, {}", joinPoint.getSignature());
    }
}
