package com.sleepyts.springframework.aop.aspectj;

import com.sleepyts.springframework.annotation.Autowired;
import com.sleepyts.springframework.aop.AdvisorPointcut;
import com.sleepyts.springframework.aop.GeneralInterceptor;
import com.sleepyts.springframework.aop.PointCut;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements AdvisorPointcut {

    private AspectJExpressionPointcut pointcut;
    private String expression;
    private Advice advice;

    public void setExpression(String expression) {
        this.expression = expression;
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
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}

