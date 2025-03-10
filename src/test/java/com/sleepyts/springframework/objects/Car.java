package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.context.annotation.Component;
import com.sleepyts.springframework.context.annotation.Scope;

/**
 * @author derekyi
 * @date 2020/11/24
 */

@Component("car")
@Scope("prototype")
public class Car {

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
}
