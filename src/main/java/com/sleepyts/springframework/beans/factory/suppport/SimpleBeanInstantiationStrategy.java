package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 简单的bean实例化策略，调用无参构造函数
 */
public class SimpleBeanInstantiationStrategy implements BeanInstantiationStrategy {
    @Override
    public Object instance(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            Constructor<?> declaredConstructor = beanClass.getDeclaredConstructor();
            return declaredConstructor.newInstance();
        } catch (Exception e) {
        }
        return null;
    }
}
