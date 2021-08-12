package com.my.advanced.concurrent.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor:
 *
 * @author mayue
 * @date 2020/04/18
 *
 */

public enum EnumThreadPool {

    Instance;

    /** 保持活跃的线程数 */
    private static final int CORE_POOL_SIZE = 5;

    /**  默认最大线程数 */
    private static final int MAXIMUM_POOL_SIZE = 20;

    private ThreadPoolExecutor executor;

    public ThreadPoolExecutor getExecutor(){
        return this.executor;
    }

    EnumThreadPool(){

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("MyExecutor-Pool-%d")
                .setUncaughtExceptionHandler( (Thread t, Throwable e)-> System.out.println("MyExecutor-Pool "+ t.getName() +" got exception "+ e.getMessage() ))
                .build();

        executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );

        //executor = new RewriteThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),"MyExecutor-Pool");

    }

}
