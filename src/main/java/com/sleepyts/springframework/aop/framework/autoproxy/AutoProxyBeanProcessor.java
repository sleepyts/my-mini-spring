package com.sleepyts.springframework.aop.framework.autoproxy;

public interface AutoProxyBeanProcessor {

    Object autoProxyProcess(Class<?> beanClass, String beanName);
}
