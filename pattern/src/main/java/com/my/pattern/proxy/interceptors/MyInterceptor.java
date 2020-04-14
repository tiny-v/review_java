package com.my.pattern.proxy.interceptors;

/**
 * @author mayue
 * @date 2020-04-14
 *
 * 定义拦截器， 写了些在代理方法被执行前后的方法
 */
public class MyInterceptor {

    public void before(){
        System.out.println(" == 先打开电脑， 准备码代码 == ");
    }

    public void after(){
        System.out.println(" == coding结束，关电脑 == ");
    }

    public void afterReturn(){
        System.out.println(" == 结束啦 ==");
    }

    public void afterThrow(){
        System.out.println(" == 抛出异常后.. ==  ");
    }

}
