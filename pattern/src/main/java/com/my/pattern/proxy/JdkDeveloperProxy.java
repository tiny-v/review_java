package com.my.pattern.proxy;

import java.lang.reflect.*;

/**
 * 代理：创建具有现有对象的对象，以便向外界提供功能接口
 *
 *
 * JDK自带的动态代理, 利用反射来实现
 * 要求： 目标类必须实现统一接口， 否则 JDK 动态代理无法使用；
 *
 *
 * @author YMa69
 * @date 2019/12/25.
 */
public class JdkDeveloperProxy {


    private final String DEBUG = "debug";

    private final String CODE = "code";

    private Developer developer;

    public JdkDeveloperProxy(Developer developer){
        this.developer = developer;
    }

    public Developer getProxy(){
        try{
            return (Developer)Proxy.newProxyInstance(developer.getClass().getClassLoader(), developer.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String methodName = method.getName();
                    if(methodName.equals(DEBUG)){
                        System.out.println(" === 先来打个断点 ===");
                        developer.debug();
                        System.out.println(" === debug 成功 ===");
                        return null;
                    }else if(methodName.equals(CODE)){
                        System.out.println(" === 来新功能喽 ===");
                        developer.code();
                        System.out.println(" === 新功能可真坑啊 ===");
                        return null;
                    }else{
                        return method.invoke(developer, args);
                    }

                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        JdkDeveloperProxy developerProxy = new JdkDeveloperProxy(new JavaDeveloper("MY"));
        Developer developer = developerProxy.getProxy();
        developer.debug();

        developerProxy = new JdkDeveloperProxy(new PythonDeveloper("Smart"));
        developer = developerProxy.getProxy();
        developer.code();

        developerProxy = new JdkDeveloperProxy(new PythonDeveloper("Krian"));
        developer = developerProxy.getProxy();
        developer.document();
    }

}
