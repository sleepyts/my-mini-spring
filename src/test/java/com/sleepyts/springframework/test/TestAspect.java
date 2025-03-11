package com.sleepyts.springframework.test;

import com.sleepyts.springframework.annotation.Component;
import com.sleepyts.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;

@Component
public class TestAspect extends AspectJExpressionPointcutAdvisor {

    private String expression = "@annotation(com.sleepyts.springframework.test.TestAnnotation)";

    public TestAspect() {
        setExpression(expression);
    }
}
