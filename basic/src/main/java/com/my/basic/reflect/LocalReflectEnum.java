package com.my.basic.reflect;

import java.lang.reflect.Method;

/**
 * @author YMa69
 * @date 2019/12/31.
 */
public class LocalReflectEnum {

    public void reflectLocalEnum() throws Exception{
        Class clazz = Class.forName("com.my.basic.enums.LocalEnum");
        Object[] objects = clazz.getEnumConstants();
        Method toString = clazz.getMethod("toString");
        for(Object object: objects){
           System.out.println((String)toString.invoke(object));
        }
    }

    public void reflectSingleObject() throws Exception{
        Class clazz = Class.forName("com.my.basic.enums.SingleObject$EnumSingleObject");
        Object[] objects = clazz.getEnumConstants();
        Method getInstance = clazz.getMethod("getInstance");
        getInstance.setAccessible(true);
        for(Object object: objects){
            System.out.println(getInstance.invoke(object).toString());
        }
    }

    public static void main(String[] args) throws Exception{
        LocalReflectEnum localReflectEnum = new LocalReflectEnum();
        localReflectEnum.reflectSingleObject();
        Thread.sleep(1000);

        localReflectEnum.reflectLocalEnum();
    }

}
