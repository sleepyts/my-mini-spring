package com.sleepyts.springframework.aop.framework.autoproxy;

import com.sleepyts.springframework.beans.factory.config.BeanPostProcessor;

public interface AutoProxyBeanProcessor extends BeanPostProcessor {

    Object autoProxyProcess(Class<?> beanClass, String beanName);
}
