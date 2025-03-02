package com.sleepyts.springframework.beans.factory.config;

import com.sleepyts.springframework.beans.factory.suppport.HierarchicalBeanFactory;
import com.sleepyts.springframework.beans.factory.suppport.SingletonBeanRegistry;

public interface ConfigurableBeanFactory extends SingletonBeanRegistry, HierarchicalBeanFactory {
}
