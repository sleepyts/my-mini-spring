package com.sleepyts.springframework.beans.factory.config;


/**
 * 一个Bean属性如果是另一个bean采用该对象
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
