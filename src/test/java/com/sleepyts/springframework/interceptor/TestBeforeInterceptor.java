package com.sleepyts.springframework.interceptor;

import com.sleepyts.springframework.aop.advice.BeforeAdvice;

import java.lang.reflect.Method;

public class TestBeforeInterceptor implements BeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice is executed!");
    }
}
