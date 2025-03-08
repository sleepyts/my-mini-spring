package com.sleepyts.springframework.beans.factory.suppport;


import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.sleepyts.springframework.beans.factory.DestroyBean;
import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author derekyi
 * @date 2020/11/29
 */
public class DisposableBeanAdapter implements DestroyBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() {
        if (bean instanceof DestroyBean) {
            ((DestroyBean) bean).destroy();
        }

        //避免同时继承自DisposableBean，且自定义方法与DisposableBean方法同名，销毁方法执行两次的情况
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DestroyBean && "destroy".equals(this.destroyMethodName))) {
            try {
                //执行自定义方法
                Method destroyMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
                if (destroyMethod == null) {
                }
                destroyMethod.invoke(bean);
            } catch (Exception e) {

            }

        }
    }
}
