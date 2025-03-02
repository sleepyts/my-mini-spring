package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


/**
 * CGLib动态生成子类策略
 */
public class CglibBeanInstantiationStrategy implements BeanInstantiationStrategy {
    @Override
    public Object instance(BeanDefinition beanDefinition) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> proxy.invokeSuper(obj, args));
        return enhancer.create();
    }
}
