package com.my.basic.polyms;

/**
 * @author mayue
 */
public class Animal {

    public String name = "animal";

    public Animal(){}

    public Animal(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println(name + " is eating food...");
    }

}
