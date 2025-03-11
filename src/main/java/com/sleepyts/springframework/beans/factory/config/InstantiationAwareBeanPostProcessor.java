package com.sleepyts.springframework.beans.factory.config;

import com.sleepyts.springframework.beans.factory.PropertyValues;


public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     * Before instantiation of a bean,do some custom processing.
     * @param beanClass
     * @param beanName
     * @return
     */
    default Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName){
        return null;
    }

    /**
     * After instantiation of a bean,do some custom processing.
     * @param bean
     * @param beanName
     * @return
     */
    default Object postProcessAfterInstantiation(Object bean, String beanName){
        return bean;
    }



    default PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName){
        return pvs;
    }
}
