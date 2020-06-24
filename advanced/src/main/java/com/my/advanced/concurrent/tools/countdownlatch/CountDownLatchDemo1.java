package com.my.advanced.concurrent.tools.countdownlatch;
import com.my.advanced.concurrent.threadpool.EnumThreadPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * CountDownLatch  主要用到两个方法:
 * 一、await()方法，调用这个方法的线程会被阻塞，
 * 二、countDown()方法，调用这个方法会使计数器减一，当计数器的值为0时，因调用await()方法被阻塞的线程会被唤醒，继续执行
 * 模拟场景：
 *          食堂工作人员，需要等两位客人先吃完午饭后， 自己才能开始吃饭
 *
 * @author mayue
 * @date 2020/04/20
 */
public class CountDownLatchDemo1 {

    public void showDemo() throws InterruptedException{
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        HaveLunch haveLunch1 = new HaveLunch("客人1", 3000, countDownLatch);
        HaveLunch haveLunch2 = new HaveLunch("客人2", 5000, countDownLatch);
        HaveLunch haveLunch3 = new HaveLunch("食堂工作人员", 4000, countDownLatch);
        ThreadPoolExecutor executor = EnumThreadPool.Instance.getExecutor();
        executor.execute(haveLunch1);
        executor.execute(haveLunch2);
        countDownLatch.await();
        executor.execute(haveLunch3);
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo1().showDemo();
    }

}
