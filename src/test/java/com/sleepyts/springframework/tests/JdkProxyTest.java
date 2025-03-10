package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.aop.AdvisedSupport;
import com.sleepyts.springframework.aop.GeneralInterceptor;
import com.sleepyts.springframework.aop.MethodMatcher;
import com.sleepyts.springframework.aop.TargetSource;
import com.sleepyts.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.sleepyts.springframework.aop.framework.CglibAopProxy;
import com.sleepyts.springframework.aop.framework.JdkAopProxy;
import com.sleepyts.springframework.aop.framework.ProxyFactory;
import com.sleepyts.springframework.interceptor.*;
import com.sleepyts.springframework.services.HelloService;
import com.sleepyts.springframework.services.HelloServiceImpl;
import org.junit.Test;

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

    @Test
    public void adviceTest() {
        AdvisedSupport advisedSupport;
        //设置BeforeAdvice
        HelloService worldService = new HelloServiceImpl();

        advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        MethodMatcher methodMatcher = new AspectJExpressionPointcut(
                "execution(* com.sleepyts.springframework.services.*.*(..))");
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher(methodMatcher);

        GeneralInterceptor methodInterceptor = getGeneralInterceptor();

        advisedSupport.setMethodInterceptor(methodInterceptor);



        advisedSupport.setProxyTargetClass(true);
        HelloService proxy = (HelloService) new ProxyFactory(advisedSupport).getProxy();
        proxy.sayHello("John");
    }

    private static GeneralInterceptor getGeneralInterceptor() {
        TestBeforeInterceptor beforeAdvice = new TestBeforeInterceptor();
        TestThrowInterceptor testThrowInterceptor = new TestThrowInterceptor();
        TestAfterAdvice testAfterAdvice = new TestAfterAdvice();
        AfterReturningAdvice afterReturningAdvice = new AfterReturningAdvice();

        GeneralInterceptor methodInterceptor = new GeneralInterceptor();
        methodInterceptor.setBeforeAdvice(beforeAdvice);
        methodInterceptor.setThrowAdvice(testThrowInterceptor);
        methodInterceptor.setAfterAdvice(testAfterAdvice);
        methodInterceptor.setAfterReturningAdvice(afterReturningAdvice);
        return methodInterceptor;
    }

}
