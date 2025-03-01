package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        try {
            bean = beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {

        }
        registerSingleton(beanName,bean);
        return bean;
    }
}
