package com.my.basic.polyms;

public class Dog extends Animal{

    public String name = "dog";

    public Dog(){}

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat(){
        System.out.println(name + " is eating food");
    }

    public static void main(String[] args){
        Animal animal = new Dog("doggy");
        System.out.println(animal.name);
        animal.eat();
    }

}
