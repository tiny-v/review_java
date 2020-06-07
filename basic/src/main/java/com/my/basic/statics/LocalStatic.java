package com.my.basic.statics;

import java.util.Collections;

/**
 * @author mayue
 */
public class LocalStatic {

    private String str1 = "abc";

    private static String str2 = "def";

    static{
        System.out.println("执行静态代码块");
        System.out.println("str2:" + str2);
    }

    public LocalStatic(String str1){
        System.out.println("执行构造函数");
        this.str1 = str1;
    }

    public static void test01(){
        System.out.println(str2);
    }

    public static void main(String[] args){
        /* it will print:
         * 执行静态代码块
         * 执行构造函数
         * 执行构造函数
         * */
        LocalStatic localStatic1 = new LocalStatic("abc");
        LocalStatic localStatic2 = new LocalStatic("abc");
    }

}
