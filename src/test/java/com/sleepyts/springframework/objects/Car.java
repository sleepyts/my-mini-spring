package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.annotation.*;

/**
 * @author derekyi
 * @date 2020/11/24
 */

@Component("car")
public class Car {

    @Autowired
    private Person person;

    @Value("true")
    private boolean brand;

    public boolean getBrand() {
        return brand;
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
