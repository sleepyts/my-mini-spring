package com.sleepyts.springframework.aop.framework;

import com.sleepyts.springframework.aop.AdvisedSupport;

public class ProxyFactory {

    private AdvisedSupport adviser;

    public ProxyFactory(AdvisedSupport adviser) {
        this.adviser = adviser;
    }

    public Object getProxy() {
        AopProxy aopProxy = createAopProxy();
        return aopProxy.getProxy();
    }

    private AopProxy createAopProxy() {
        if (adviser.isProxyTargetClass()) {
            return new CglibAopProxy(adviser);
        } else {
            return new JdkAopProxy(adviser);
        }
    }
}
