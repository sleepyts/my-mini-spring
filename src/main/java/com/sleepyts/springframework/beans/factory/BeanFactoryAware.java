package com.sleepyts.springframework.beans.factory;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory);
}
