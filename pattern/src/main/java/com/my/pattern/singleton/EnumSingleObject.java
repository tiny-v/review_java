package com.my.pattern.singleton;

import java.lang.reflect.Method;

/**
 * 使用单元素枚举(enum)来实现单例模式
 *
 * @author YMa69
 * @date 2019/12/30.
 */



public class EnumSingleObject {

    /** 将构造函数私有化*/
    private EnumSingleObject(){}

    public static void main(String[] args) throws Exception {
        EnumSingleObject enumSingleObject = EnumInstance.INSTANCE.getInstance();
        EnumSingleObject singleObject = reflectEnum();
        System.out.println(enumSingleObject == singleObject);
    }

    enum EnumInstance{
        INSTANCE;

        private EnumSingleObject singleObject = new EnumSingleObject();

        /**
         * @return
         */
        public EnumSingleObject getInstance(){
            return singleObject;
        }
    }


    public static EnumSingleObject reflectEnum() throws Exception{
        Class<?> clazz = Class.forName("com.my.pattern.singleton.EnumSingleObject$EnumInstance");
        //获取所有常量
        Object[] objects = clazz.getEnumConstants();
        Method method = clazz.getMethod("getInstance");
        for(Object obj: objects){
             return (EnumSingleObject)method.invoke(obj);
        }
        return null;
    }

}


