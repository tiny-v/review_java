package com.my.advanced.concurrent.deadlock;

/**
 *
 * @author YMa69
 * @date 2019/11/18
 */
public class InnerThreadDemo implements Runnable{

    private Demo objA;
    private Demo objB;

    public InnerThreadDemo(Demo objA, Demo objB){
        this.objA = objA;
        this.objB = objB;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" 需要获得 " + objA.getName() + " 的锁");
        synchronized (objA){
            System.out.println(Thread.currentThread().getName() +" 成功获得 " + objA.getName() + " 的锁");
            work();
            System.out.println(Thread.currentThread().getName() +" 需要获得 " + objB.getName() + " 的锁");
            synchronized (objB){
                System.out.println(Thread.currentThread().getName() +" 成功获得 " + objB.getName() + " 的锁");
                work();
            }
            System.out.println(Thread.currentThread().getName() + " 释放 " + objB.getName() + " 的锁");
        }
        System.out.println(Thread.currentThread().getName() + " 释放 " + objA.getName() + " 的锁");
    }

    public void work(){
        try {
            Thread.sleep(10*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
