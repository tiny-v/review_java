package com.my.advanced.concurrent;

public class PrintBar extends Thread {

    private void printBar(){
        System.out.print("bar");
    }

    @Override
    public void run(){
        printBar();
    }
}
