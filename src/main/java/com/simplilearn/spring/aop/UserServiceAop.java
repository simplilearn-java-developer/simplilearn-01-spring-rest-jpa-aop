package com.simplilearn.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.simplilearn.spring.jpa.User;

@Aspect
@Component
public class UserServiceAop {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    @Before("execution(* com.simplilearn.spring.service.UserService.*(..))")
    public void beforeAdviceAllMethods(JoinPoint joinPoint) {

        logger.debug("Before Method: {}", joinPoint.getSignature());
    }

    @After("execution(* com.simplilearn.spring.service.UserService.*(..))")
    public void afterAdviceAllMethods(JoinPoint joinPoint) {

        logger.debug("After Method: {}", joinPoint.getSignature());
    }
    @Before("execution(* com.simplilearn.spring.service.UserService.findUser(..))")
    public void beforeAdviceOneMethod(JoinPoint joinPoint) {

        logger.debug("Before Method: {}", joinPoint.getSignature());
    }

    @After("execution(* com.simplilearn.spring.service.UserService.findUser(..))")
    public void afterAdviceOneMethod(JoinPoint joinPoint) {

        logger.debug("After Method: {}", joinPoint.getSignature());
    }

    @Before("execution(* com.simplilearn.spring.service.UserService.*(..)) and args(idUser)")
    public void beforeAdviceOneParam(JoinPoint joinPoint, int idUser) {

        logger.debug("Before Method: {}", joinPoint.getSignature());
        logger.debug("User Id: {}", idUser);
    }

    @After("execution(* com.simplilearn.spring.service.UserService.*(..)) and args(idUser)")
    public void afterAdviceOneParam(JoinPoint joinPoint, int idUser) {

        logger.debug("After Method: {}", joinPoint.getSignature());
        logger.debug("User Id: {}", idUser);
    }*/
    @Before("execution(* com.simplilearn.spring.service.UserService.*(..)) and args(user)")
    public void beforeAdviceOneParam(JoinPoint joinPoint, User user) {

        logger.debug("Before Method: {}", joinPoint.getSignature());
        logger.debug("User: {}", user);
    }

    @After("execution(* com.simplilearn.spring.service.UserService.*(..)) and args(user)")
    public void afterAdviceOneParam(JoinPoint joinPoint, User user) {

        logger.debug("After Method: {}", joinPoint.getSignature());
        logger.debug("User: {}", user);
    }
}
