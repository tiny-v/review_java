package com.my.advanced.concurrent.countdownlatch;
import	java.util.concurrent.CountDownLatch;

/**
 * @author mayue
 * @date 2020/04/20
 */
public class HaveLunch implements Runnable{

    private String client;
    private int lunchTime;
    private CountDownLatch countDownLatch;

    public HaveLunch(String client, int lunchTime, CountDownLatch countDownLatch){
        this.client = client;
        this.lunchTime = lunchTime;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            System.out.println(client+"准备吃午饭了。。。。。");
            System.out.println(client+"正在吃午饭了。。");
            Thread.sleep(lunchTime);
            System.out.println(client+"吃完午饭了。。");
            if(countDownLatch!=null){
                countDownLatch.countDown();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
