package com.sleepyts.springframework.interceptor;

import com.sleepyts.springframework.aop.advice.ThrowAdvice;

import java.lang.reflect.Method;

public class TestThrowInterceptor implements ThrowAdvice {
    @Override
    public void afterThrowing(Throwable ex, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("TestThrowInterceptor.afterThrowing called");
        System.out.println(ex.getMessage());
    }
}
