package com.my.advanced.concurrent.thread;
import com.my.advanced.concurrent.threadpool.EnumThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author may
 * @date 2020/04/18
 */
public class CallableDemo implements Callable<Integer> {

    public static AtomicInteger counter = new AtomicInteger(0);

    private static final int LOOP_SIZE = 50;

    @Override
    public Integer call(){
        try{
            for (int i=0; i<LOOP_SIZE; i++){
                System.out.println(Thread.currentThread().getName() + "," + counter.addAndGet(1));
                Thread.sleep(10);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = EnumThreadPool.Instance.executor;
        ArrayList<Callable<Integer>> taskList = new ArrayList();
        taskList.add(new CallableDemo());
        taskList.add(new CallableDemo());
        taskList.add(new CallableDemo());
        List<Future<Integer>> futureList =  executor.invokeAll(taskList);
        executor.shutdown();
    }

}
