package com.my.advanced.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore，是JDK1.5的java.util.concurrent并发包中提供的一个并发工具类
 * 用途：
 * 1. 我们限制可以访问某些资源的线程数目就可以使用Semaphore了
 * */

//本案例目的是使用Semaphore， 循环打印 n 个 “foobar”

/**
 * @author may
 * @Date 20200412
 * */
public class SemaphoreDemo1 extends Thread{

    final static Semaphore FOO_SEMAPHORE = new Semaphore(1);
    /** 用0来初始化， 使得其必须先release，才能acquire */
    final static Semaphore BAR_SEMAPHORE = new Semaphore(0);
    /** 类型 */
    enum TYPE {FOO, BAR}

    private String type;

    SemaphoreDemo1(String type){
        this.type = type;
    }

    @Override
    public void run(){
        try{
            if(TYPE.FOO.name().equals(type)){
                PrintFoo printFoo = new PrintFoo();
                priFoo(printFoo, 10);
            }
            if(TYPE.BAR.name().equals(type)){
                PrintBar printBar = new PrintBar();
                priBar(printBar, 10);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void priFoo(PrintFoo printFoo, int n) throws InterruptedException{
        for(int i=0; i<n; i++){
            SemaphoreDemo1.FOO_SEMAPHORE.acquire(1);
            printFoo.run();
            SemaphoreDemo1.BAR_SEMAPHORE.release();
        }
    }

    public void priBar(PrintBar printBar, int n) throws InterruptedException{
        for(int i=0; i<n; i++){
            SemaphoreDemo1.BAR_SEMAPHORE.acquire();
            printBar.run();
            SemaphoreDemo1.FOO_SEMAPHORE.release(1);
        }
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new SemaphoreDemo1("foo"));
        thread1.start();
        Thread thread2 = new Thread(new SemaphoreDemo1("bar"));
        thread2.start();
    }

}

class PrintBar extends Thread {

    private void printBar(){
        System.out.print("bar");
    }

    @Override
    public void run(){
        printBar();
    }
}


class PrintFoo extends Thread{

    private void printFoo(){
        System.out.print("foo");
    }

    @Override
    public void run(){
        printFoo();
    }
}
