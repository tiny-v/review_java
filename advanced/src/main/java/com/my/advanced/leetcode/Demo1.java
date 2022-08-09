package com.my.advanced.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tiny_v
 * @date 2022/2/16.
 */
public class Demo1 {

    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Set<Integer> set = new HashSet();
        for(int i=1; i<nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        return (int)set.toArray()[0];
    }

    public static void main(String[] args){
        System.out.println(0^0);
        System.out.println(4^0);
        System.out.println(1^0);
        System.out.println(1^1);
        System.out.println(4^4);
        System.out.println(1^4);
        System.out.println(5^1);
        System.out.println(1^4^1);



    }

}
