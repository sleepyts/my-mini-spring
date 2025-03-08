package com.sleepyts.springframework.beans.factory.suppport;


import com.sleepyts.springframework.beans.factory.DestroyBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    private Map<String, DestroyBean> destroyObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void registerDestroyBean(String beanName, DestroyBean destroyBean) {
        destroyObjects.put(beanName, destroyBean);
    }

    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(destroyObjects.keySet());
        for (String beanName : beanNames) {
            DestroyBean disposableBean = destroyObjects.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
            }
        }
    }
}
