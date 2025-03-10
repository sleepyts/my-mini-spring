package com.sleepyts.springframework.aop.advice;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

public interface ThrowAdvice extends Advice {
    void afterThrowing(Throwable ex, Method method, Object[] args, Object target) throws Throwable;
}
