package com.sleepyts.springframework.aop.framework.autoproxy;

import com.sleepyts.springframework.aop.AdvisedSupport;
import com.sleepyts.springframework.aop.Advisor;
import com.sleepyts.springframework.aop.PointCut;
import com.sleepyts.springframework.aop.TargetSource;
import com.sleepyts.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import com.sleepyts.springframework.aop.framework.ProxyFactory;
import com.sleepyts.springframework.beans.factory.BeanFactory;
import com.sleepyts.springframework.beans.factory.BeanFactoryAware;
import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.suppport.DefaultListableBeanFactory;
import com.sleepyts.springframework.context.annotation.Component;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

@Component
public class DefaultAdvisorAutoProxyCreator implements BeanFactoryAware, AutoProxyBeanProcessor {

    private DefaultListableBeanFactory beanFactory;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object autoProxyProcess(Class<?> beanClass, String beanName) {
        // Ignore Advice, PointCut, and Advisor classes
        if (Advice.class.isAssignableFrom(beanClass) ||
                PointCut.class.isAssignableFrom(beanClass) ||
                Advisor.class.isAssignableFrom(beanClass)
        ) {
            return null;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisorBeans = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisorBean : advisorBeans) {
            if (advisorBean.getPointcut().getClassFilter().matches(beanClass)) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinitionByName(beanName);

                Object target = beanFactory.getBeanInstantiationStrategy().instance(beanDefinition);

                AdvisedSupport advisedSupport = new AdvisedSupport();
                advisedSupport.setTargetSource(new TargetSource(target));
                advisedSupport.setMethodMatcher(advisorBean.getPointcut().getMethodMatcher());
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisorBean.getAdvice());
                advisedSupport.setProxyTargetClass(beanDefinition.getProxyTargetClass());
                return new ProxyFactory(advisedSupport).getProxy();
            }
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}
