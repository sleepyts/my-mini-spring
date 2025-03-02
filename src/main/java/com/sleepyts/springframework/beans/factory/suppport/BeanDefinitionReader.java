package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.core.io.Resource;
import com.sleepyts.springframework.beans.core.io.ResourceLoader;

public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(String location);
}
