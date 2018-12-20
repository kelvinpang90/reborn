package com.reborn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AspectXML {
    public void before(JoinPoint joinPoint){
    }

    public void afterReturning(JoinPoint joinPoint){
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = proceedingJoinPoint.proceed();
        return obj;
    }

    public void afterThrowing(JoinPoint joinPoint,Throwable e){
    }

    public void after(){

    }
}
