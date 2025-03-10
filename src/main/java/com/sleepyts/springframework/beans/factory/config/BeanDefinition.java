package com.sleepyts.springframework.beans.factory.config;


import com.sleepyts.springframework.beans.factory.PropertyValues;

/**
 * Stores the configuration of a bean definition
 */
public class BeanDefinition {


    private static final String SCOPE_SINGLETON = "singleton";

    private static final String SCOPE_PROTOTYPE = "prototype";

    // The class of the bean to be instantiated
    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    // Default scope is singleton
    private String scope = SCOPE_SINGLETON;

    // Whether to proxy the target class for AOP(CGLib), default is false(JDK dynamic proxy)
    private boolean proxyTargetClass = false;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public boolean getProxyTargetClass() {
        return proxyTargetClass;
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

    public boolean isPROTOTYPE() {
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
