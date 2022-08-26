package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class BookAspect {
    private static int count = 0;

    @AfterReturning("execution(* com.library.controller.BookController.borrow(..))")
    public void logInfoBorrow(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Method " + methodName + " done!");
    }
    @AfterReturning("execution(* com.library.controller.BookController.returnBook(..))")
    public void logInfoReturn(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Method " + methodName + " done!");
    }

    @Before( "execution(* com.library.controller.BookController.*(..))")
    public void logInfoVisit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        count++;
        System.err.println("Method " + methodName + " done! (logTime=" + count + ")");
    }
}
