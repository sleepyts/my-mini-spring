package com.sleepyts.springframework.beans.factory.config;


import com.sleepyts.springframework.beans.factory.PropertyValue;
import com.sleepyts.springframework.beans.factory.PropertyValues;

/**
 * 保存bean的实例信息
 */
public class BeanDefinition {


    // 单例
    private static final String SCOPE_SINGLETON = "singleton";

    // 多例
    private static final String SCOPE_PROTOTYPE = "prototype";

    // bean对应的Class
    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    // 默认单例
    private String scope = SCOPE_SINGLETON;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    public boolean isSingleton() {
        return scope.equals(SCOPE_SINGLETON);
    }

    public boolean isPROTOTYPE(){
        return scope.equals(SCOPE_PROTOTYPE);
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

    public String getInitMethodName() {
        return initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
