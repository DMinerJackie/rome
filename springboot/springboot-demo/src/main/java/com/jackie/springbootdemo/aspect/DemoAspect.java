package com.jackie.springbootdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Jackie
 */
@Aspect
@Component
public class DemoAspect {
    private static final Logger LOG = LoggerFactory.getLogger(DemoAspect.class);

    @Pointcut("execution(public * com.jackie.springbootdemo.controller.*.*(..)) && @annotation(com.jackie.springbootdemo.annotation.DemoAnnotation)")
    public void addAdvice(){}


//    @Around("execution(public * com.jackie.springbootdemo.controller.HelloController.test*(..)) && @annotation(com.jackie.springbootdemo.annotation.DemoAnnotation)")
//    public Object aroundInterceptor(ProceedingJoinPoint pjp){
//        Object result = null;
//        Object[] args = pjp.getArgs();
//        if(args != null && args.length >0) {
//            String deviceId = (String) args[0];
//            if(!"03".equals(deviceId)) {
////                return "no anthorization";
//            }
//        }
//        try {
//            result =pjp.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Before("addAdvice()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest requests = (HttpServletRequest) args[0];
        LOG.info("============打印日志开始============");
        LOG.info("URL: " + requests.getRequestURL().toString());
        LOG.info("============打印日志结束============");
//        LOG.info("before....");
    }

    @AfterReturning("addAdvice()")
    public void afterReturning(){
        LOG.info("after returning....");
    }

    @AfterThrowing(value = "addAdvice()", throwing = "ex")
//    @AfterThrowing(value = "execution(public * com.jackie.springbootdemo.controller.HelloController.test*(..))", throwing = "ex")
    public void afterThrowing(Throwable ex){
        LOG.error("throw exception: {}", ex);
    }
}
