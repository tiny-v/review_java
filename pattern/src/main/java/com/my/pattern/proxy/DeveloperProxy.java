package com.my.pattern.proxy;

import com.my.pattern.proxy.interceptors.MyInterceptor;
import com.my.pattern.proxy.interfaces.Developer;

import java.lang.reflect.*;

/**
 * 代理：创建具有现有对象的对象，以便向外界提供功能接口
 *
 * JDK自带的动态代理, 利用反射来实现
 * 要求： 目标类必须实现统一接口， 否则 JDK 动态代理无法使用；
 *
 * @author YMa69
 * @date 2019/12/25.
 */
public class DeveloperProxy implements InvocationHandler{

    /** 被代理的对象 */
    private Object developer;
    /** 自定义的拦截器 */
    private MyInterceptor myInterceptor;

    public static Object getDeveloperProxy(Object target, MyInterceptor myInterceptor){
        DeveloperProxy developerProxy = new DeveloperProxy();
        developerProxy.developer = target;
        developerProxy.myInterceptor = myInterceptor;
        // 返回生成的代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), developerProxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        // before
        this.myInterceptor.before();
        Object obj = null;
        try{
            obj = method.invoke(this.developer, args);
        }catch (Exception e){
            exceptionFlag = true;
        }
        this.myInterceptor.after();

        if(exceptionFlag){
            this.myInterceptor.afterThrow();
        }else{
            this.myInterceptor.afterReturn();
            return obj;
        }
        return null;
    }

    public static void main(String[] args){
        MyInterceptor myInterceptor = new MyInterceptor();
        JavaDeveloper javaDeveloper = new JavaDeveloper("May");
        Developer developer = (Developer)DeveloperProxy.getDeveloperProxy(javaDeveloper, myInterceptor);
        developer.debug();
        developer.code();
    }


}
