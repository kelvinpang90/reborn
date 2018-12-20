package com.reborn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAnnotation {

    //切入点
    @Pointcut("execution(* com.reborn.service.*.*(..))")
    private void myPointCut(){}

    @Before(value = "myPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before..."+joinPoint.getTarget()+" "+joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "myPointCut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("afterReturning..."+joinPoint.getTarget()+" "+joinPoint.getSignature().getName());
    }

    @Around(value = "myPointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("around...");
        return obj;
    }

    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("afterThrowing..."+e.getMessage());
    }

    @After(value = "myPointCut()")
    public void after(){
        System.out.println("after...");
    }
}
