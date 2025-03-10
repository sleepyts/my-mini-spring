package com.sleepyts.springframework.aop.aspectj;

import com.sleepyts.springframework.aop.AdvisorPointcut;
import com.sleepyts.springframework.aop.PointCut;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements AdvisorPointcut {

    private final AspectJExpressionPointcut pointcut;
    private String expression;
    private Advice advice;

    public AspectJExpressionPointcutAdvisor(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }


    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public PointCut getPointcut() {
        return pointcut;
    }
}

