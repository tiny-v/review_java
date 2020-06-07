package com.my.advanced.thread.deadlock;

/**
 * @author may
 * @date 2020/04/18
 */
public class Demo {

    private String name;

    public Demo(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
