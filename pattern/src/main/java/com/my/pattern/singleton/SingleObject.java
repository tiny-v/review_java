package com.my.pattern.singleton;

/**
 *
 * 单例模式：Singleton Pattern
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 *
 * 本例使用：
 * 双检锁/双重校验锁(DCL, 即 double-checked locking)
 *
 * @author YMa69
 * @date 2019/12/3
 */
public class SingleObject {

    /**
     * 创建实例
     * 使用 volatile 关键字， 禁止重排序， 使所有的write操作都发生在read操作之前
     * */
    public static volatile  SingleObject instance;

    /** 将构造函数私有化 */
    private SingleObject(){}

    /** 获取实例 */
    public static SingleObject getInstance(){
        if(instance == null){
            synchronized (SingleObject.class){
                // 再次判空， 防止多个线程同时通过第一步判空操作
                if(instance == null){
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

}
