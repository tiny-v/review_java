package com.my.advanced.concurrent.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.my.advanced.concurrent.ConConsts;

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

    public ThreadPoolExecutor executor;

    EnumThreadPool(){

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("MyExecutor-Pool-%d").build();

        executor = new ThreadPoolExecutor(ConConsts.CORE_POOL_SIZE, ConConsts.MAXIMUM_POOL_SIZE,
                60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    }

}
