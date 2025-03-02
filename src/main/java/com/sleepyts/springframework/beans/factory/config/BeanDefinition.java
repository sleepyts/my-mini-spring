package com.sleepyts.springframework.beans.factory.config;


import com.sleepyts.springframework.beans.factory.PropertyValue;
import com.sleepyts.springframework.beans.factory.PropertyValues;

/**
 * 保存bean的实例信息
 */
public class BeanDefinition {

    // bean对应的Class
    private Class<?> beanClass;
    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass,null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues){
        this.beanClass=beanClass;
        this.propertyValues=propertyValues==null?new PropertyValues():propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
