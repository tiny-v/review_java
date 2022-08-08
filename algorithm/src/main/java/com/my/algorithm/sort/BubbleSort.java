package com.my.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 输出结果：数组从小到大排序
     * @param sources
     * @return
     */
    public int[] bubbleSort(int[] sources){
        if(sources==null || sources.length<=1){
            return sources;
        }
        for(int i=sources.length-1; i>=0; i--){
            boolean sorted = true;
            for(int j=0; j<i; j++){
                if(sources[j] > sources[j+1]){
                    int tmp = sources[j];
                    sources[j] = sources[j+1];
                    sources[j+1] = tmp;
                    sorted = false;
                }
            }
            if(sorted){
                break;
            }
        }
        return sources;
    }

    public static void main(String[] args){
        int[] sources = {5, 4, 3, 2, 1};
        Arrays.stream(new BubbleSort().bubbleSort(sources)).forEach(source->
            System.out.println(source)
        );
    }

}
