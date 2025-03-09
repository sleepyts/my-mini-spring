package com.sleepyts.springframework.services;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("HelloServiceImpl.sayHello() called");
        return "Hello " + name + "!";
    }
}
