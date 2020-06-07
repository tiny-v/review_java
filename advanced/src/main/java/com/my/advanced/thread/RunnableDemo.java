package com.my.advanced.thread;

import com.my.advanced.concurrent.threadpool.EnumThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author may
 * @date 2019/11/15
 */
public class RunnableDemo implements Runnable{

    public static AtomicInteger counter = new AtomicInteger(0);

    private static final int LOOP_SIZE = 500;

    @Override
    public void run() {
        try{
            for (int i=0; i<LOOP_SIZE; i++){
                System.out.println(Thread.currentThread().getName() + "," + counter.addAndGet(1));
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService executor = EnumThreadPool.Instance.executor;
        executor.execute(new RunnableDemo());
        executor.execute(new RunnableDemo());
        executor.execute(new RunnableDemo());
        executor.shutdown();
    }
}
