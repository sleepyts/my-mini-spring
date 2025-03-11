package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.annotation.Autowired;
import com.sleepyts.springframework.annotation.Component;
import com.sleepyts.springframework.annotation.Qualifier;
import com.sleepyts.springframework.annotation.Scope;

/**
 * @author derekyi
 * @date 2020/11/24
 */

@Component("car")
@Scope("prototype")
public class Car {

    @Autowired
    private Person person;

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }

    public Person getPerson() {
        return person;
    }
}
