package com.my.advanced.concurrent.deadlock;

/**
 *
 * @author YMa69
 * @date 2019/11/18
 */
public class DeadLockDemo {

    public static void main(String[] args){

        Demo obj1 = new Demo("A");
        Demo obj2 = new Demo("B");
        Demo obj3 = new Demo("C");

        Thread t1 = new Thread(new InnerThreadDemo(obj1, obj2), "t1");
        Thread t2 = new Thread(new InnerThreadDemo(obj2, obj3), "t2");
        Thread t3 = new Thread(new InnerThreadDemo(obj3, obj1), "t3");
        t1.start();
        t2.start();
        t3.start();
    }

}
