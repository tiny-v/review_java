package com.my.advanced.thread;

/**
 * @author mayue
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args){
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        TestClient testClient1 = new TestClient(threadLocalDemo);
        TestClient testClient2 = new TestClient(threadLocalDemo);
        TestClient testClient3 = new TestClient(threadLocalDemo);
        testClient1.start();
        testClient2.start();
        testClient3.start();

    }

    private static class TestClient extends Thread
    {
        private ThreadLocalDemo tld;

        public TestClient(ThreadLocalDemo tld) {
            this.tld = tld;
        }

        @Override
        public void run()
        {
            // ④每个线程打出3个序列值
            int cont = 3;
            for (int i = 0; i < cont; i++) {
                System.out.println("thread["+Thread.currentThread().getName()+ "] tld["+tld.getNextNum()+"]");
            }
        }
    }

}
