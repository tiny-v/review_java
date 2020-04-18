package com.my.advanced.concurrent.thread;

/**
 * @author mayue
 * @date 2020/04/16
 */
public class ThreadDemo extends Thread {

    private static Integer counter = 0;

    private final int LOOP_SIZE = 500;

    @Override
    public void run(){
        try{
            for (int i=0; i<LOOP_SIZE; i++){
                add();
                System.out.println(Thread.currentThread().getName()+ ":" +counter);
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static synchronized void add(){
        ThreadDemo.counter++;
    }

    public static void main(String[] args){
        Thread thread1 = new Thread(new ThreadDemo(), "thread1");
        Thread thread2 = new Thread(new ThreadDemo(), "thread2");
        Thread thread3 = new Thread(new ThreadDemo(), "thread3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
