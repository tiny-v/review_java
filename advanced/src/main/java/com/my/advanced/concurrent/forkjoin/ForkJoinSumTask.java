package com.my.advanced.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YMa69
 * @date 2019/12/15.
 */
public class ForkJoinSumTask extends RecursiveTask<Integer> {

    private final int THRESHOlD = 100;
    private AtomicInteger task_split_count = new AtomicInteger(0);


    private Integer start;
    private Integer end;

    public ForkJoinSumTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        if(end-start < THRESHOlD){
            int sum = 0;
            for(int i=start; i<end; i++){
                sum+=i;
            }
            return sum;
        }else{
            System.out.println("== 工作切分 ==");
            // 无符号，右移一位. 即除以二
            int middle = (end+start) >>> 1;
            ForkJoinSumTask leftTask = new ForkJoinSumTask(start, middle);
            ForkJoinSumTask rightTask = new ForkJoinSumTask(middle, end);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }

    public static void main(String[] args) throws  Exception{

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinSumTask ForkJoinSumTask = new ForkJoinSumTask(1, 999999);
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(ForkJoinSumTask);
        int result = forkJoinTask.get();
        forkJoinPool.shutdown();
        System.out.print("result:" + result);
    }
}
