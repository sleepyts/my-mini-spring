package com.sleepyts.springframework.interceptor;

import com.sleepyts.springframework.aop.advice.AfterAdvice;

import java.lang.reflect.Method;

public class TestAfterAdvice implements AfterAdvice {
    @Override
    public void after(Method method, Object[] args, Object target) {
        System.out.println("AfterAdvice: " + method.getName());
    }
}
