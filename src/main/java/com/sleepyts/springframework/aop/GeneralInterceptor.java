package com.sleepyts.springframework.aop;

import com.sleepyts.springframework.aop.advice.AfterAdvice;
import com.sleepyts.springframework.aop.advice.AfterReturningAdvice;
import com.sleepyts.springframework.aop.advice.BeforeAdvice;
import com.sleepyts.springframework.aop.advice.ThrowAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GeneralInterceptor implements MethodInterceptor {

    private BeforeAdvice beforeAdvice;
    private ThrowAdvice throwAdvice;
    private AfterAdvice afterAdvice;
    private AfterReturningAdvice afterReturningAdvice;

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }

    public void setThrowAdvice(ThrowAdvice throwAdvice) {
        this.throwAdvice = throwAdvice;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public void setAfterReturningAdvice(AfterReturningAdvice afterReturningAdvice) {
        this.afterReturningAdvice = afterReturningAdvice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object result = null;
        try {
            if (beforeAdvice != null) {
                beforeAdvice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
            }
            result = invocation.proceed();
        } catch (Exception e) {
            if (throwAdvice != null) {
                throwAdvice.afterThrowing(e, invocation.getMethod(), invocation.getArguments(), invocation.getThis());
            } else {
                throw e;
            }
        } finally {
            if (afterAdvice != null) {
                afterAdvice.after(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
            }
        }
        if (afterReturningAdvice != null) {
            afterReturningAdvice.afterReturning(result, invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        }
        return result;
    }
}
