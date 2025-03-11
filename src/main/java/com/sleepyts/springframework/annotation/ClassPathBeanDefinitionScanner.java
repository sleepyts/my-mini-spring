package com.sleepyts.springframework.annotation;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.suppport.BeanDefinitionRegistry;

import java.util.Set;

public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String[] basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition candidate : candidates) {
                Class<?> beanClass = candidate.getBeanClass();
                // todo 解析scope;
                if (beanClass.isAnnotationPresent(Scope.class)) {
                    String scope = beanClass.getAnnotation(Scope.class).value();
                    if (!scope.equals(Scope.PROTOTYPE) && !scope.equals(Scope.SINGLETON))
                        throw new IllegalArgumentException("scope must be singleton or prototype");
                    candidate.setScope(scope);
                }
                registry.registerBeanDefinition(determineBeanName(candidate), candidate);
            }
        }
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        if (beanClass.isAnnotationPresent(Component.class)) {
            String name = beanClass.getAnnotation(Component.class).value();
            if (!name.isEmpty()) {
                return name;
            }
        }
        return beanClass.getSimpleName();
    }
}
