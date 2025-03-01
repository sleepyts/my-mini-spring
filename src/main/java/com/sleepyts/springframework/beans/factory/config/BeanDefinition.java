package com.sleepyts.springframework.beans.factory.config;


/**
 * 保存bean的实例信息
 */
public class BeanDefinition {

    // bean对应的Class
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
