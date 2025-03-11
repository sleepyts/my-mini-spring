package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.annotation.Component;
import com.sleepyts.springframework.beans.factory.DestroyBean;
import com.sleepyts.springframework.beans.factory.InitializingBean;

/**
 * @author derekyi
 * @date 2020/11/24
 */
@Component
public class Person implements DestroyBean, InitializingBean {

    private String name;

    private int age;

    private Car car;

    public void sayHello() {
        name = "Derek";
        age = 25;
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        System.out.println("init...");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    @Override
    public void destroy() {
        System.out.println("Person bean destroy...");
    }

    @Override
    public void afterPropertiesSet() {
         System.out.println("Person bean init...");
    }
}
