package com.icella.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /*@Before("execution( public * com.icella.girl.controller.GirlController.*(..))")
    public void log(){
        System.out.println("11111");
    }

    @After("execution( public * com.icella.girl.controller.GirlController.*(..))")
    public void doAfter(){
        System.out.println("22222");
    }*/

    @Pointcut("execution( public * com.icella.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("111111");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {}", request.getRequestURL());
        logger.info("method = {}", request.getMethod());
        logger.info("ip = {}", request.getRemoteAddr());
        //类方法　
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturing(Object object){
        logger.info("response = {}", object.toString());
    }
}
