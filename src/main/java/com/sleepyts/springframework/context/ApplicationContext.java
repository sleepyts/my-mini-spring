package com.sleepyts.springframework.context;

import com.sleepyts.springframework.beans.factory.suppport.HierarchicalBeanFactory;
import com.sleepyts.springframework.beans.factory.suppport.ListableBeanFactory;
import com.sleepyts.springframework.core.io.ResourceLoader;

public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {
}
