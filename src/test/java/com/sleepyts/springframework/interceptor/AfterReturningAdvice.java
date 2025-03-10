package com.sleepyts.springframework.interceptor;

import java.lang.reflect.Method;

public class AfterReturningAdvice implements com.sleepyts.springframework.aop.advice.AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) {
        System.out.println("AfterReturningAdvice.afterReturning() called");
        System.out.println("returnValue: " + returnValue);
        System.out.println("method: " + method);
        System.out.println("args: " + args);
        System.out.println("target: " + target);
    }
}
