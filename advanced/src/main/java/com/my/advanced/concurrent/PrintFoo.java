package com.my.advanced.concurrent;

public class PrintFoo extends Thread{

    private void printFoo(){
        System.out.print("foo");
    }

    @Override
    public void run(){
        printFoo();
    }
}
