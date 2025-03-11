package com.sleepyts.springframework.context;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] locations;


    public ClassPathXmlApplicationContext(String location) {
        this(new String[]{location});
    }

    public ClassPathXmlApplicationContext(String[] locations) {
        this.locations = locations;
        refresh();
    }


    @Override
    protected String[] getConfigLocations() {
        return locations;
    }
}
