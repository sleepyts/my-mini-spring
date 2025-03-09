package com.sleepyts.springframework.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("Before method invocation");
        Object result = methodInvocation.proceed();
        System.out.println("After method invocation");
        return result;
    }
}
