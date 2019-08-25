package com.ljl.study.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
    
    @Pointcut(value="execution(* com.ljl..service.*.*(..))")
    public void pointCut(){
        
    }

    @Before(value = "execution(* com.ljl..service.*.*(..))")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + "start, params: " + Arrays.asList(joinPoint.getArgs()));
    }
    
    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " end");

    }
    @AfterReturning(value="pointCut()",returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result){
        System.out.println(joinPoint.getSignature().getName() + " return result: " + result);

    }
    
    @AfterThrowing(value="pointCut()",throwing="e")
    public void logAfterThrow(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName() + " logAfterThrow: " + e.getMessage());

    }
    
    

}
