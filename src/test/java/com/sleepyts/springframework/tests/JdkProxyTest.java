package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.aop.AdvisedSupport;
import com.sleepyts.springframework.aop.MethodMatcher;
import com.sleepyts.springframework.aop.TargetSource;
import com.sleepyts.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.sleepyts.springframework.aop.framework.JdkAopProxy;
import com.sleepyts.springframework.interceptor.TestInterceptor;
import com.sleepyts.springframework.services.HelloService;
import com.sleepyts.springframework.services.HelloServiceImpl;

public class JdkProxyTest {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut(
                "execution(* com.sleepyts.springframework.services.*.*(..))");
        TestInterceptor testInterceptor = new TestInterceptor();

        advisedSupport.setMethodMatcher(methodMatcher);
        advisedSupport.setTargetSource(new TargetSource(helloService));
        advisedSupport.setMethodInterceptor(testInterceptor);

        HelloService proxy = (HelloService) new JdkAopProxy(advisedSupport).getProxy();
        proxy.sayHello("John");

    }
}
