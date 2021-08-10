package com.my.advanced.concurrent.lock;
import java.util.concurrent.locks.Lock;
import	java.util.concurrent.locks.ReentrantLock;

/**
 * @author mayue
 */
public class LocalReentrantLock {

    public void test01(){
        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}
