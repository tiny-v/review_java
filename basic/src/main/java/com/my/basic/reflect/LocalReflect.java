package com.my.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @author YMa69
 * @date 2019/12/11.
 */
public class LocalReflect {

    static Class getBasicClass(){
        Class clazz = null;
        try{
            // method 1 -- 常用
            clazz = Class.forName("com.my.learn.reflect.ReflectEntity");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 获取Class对象的三种方法
     * */
    static void case01(){
        Class clazz1 = null;
        try{
            // method 1 -- 常用
            clazz1 = Class.forName("com.my.learn.reflect.ReflectEntity");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        // method 2 -- 既然已经创建了Dog对象， 在调用getClass()，有些多次一举
        Class clazz2 = new Dog().getClass();
        // method 3 -- 该方法要求import对象
        Class clazz3 = Dog.class;
        // true
        System.out.println(clazz1==clazz2);
        // true
        System.out.println(clazz3==clazz2);
    }

    /**
     * 通过反射获取构造函数
     * */
    static void case02() throws Exception{
        // 获取Class对象
        Class clazz = getBasicClass();

        /****** 获取所有构造函数 ******/
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c: constructors){
            System.out.println(c);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        constructors = clazz.getDeclaredConstructors();
        for(Constructor c: constructors){
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor c = clazz.getConstructor(null);
        Object obj = c.newInstance();
        System.out.println(obj);

        System.out.println("******************获取私有构造方法，并调用*******************************");
        c = clazz.getDeclaredConstructor(String.class, boolean.class);
        // 暴力访问
        c.setAccessible(true);
        ReflectEntity reflectPOJO = (ReflectEntity) c.newInstance("MY", false);
        System.out.println(reflectPOJO.getName());
    }

    /**
     * 获取成员变量并调用
     * */
    static void case03() throws Exception{
        Class clazz = getBasicClass();

        System.out.println("************获取所有公有的字段********************");
        Field[] fields = clazz.getFields();
        for(Field field: fields){
            System.out.println(field.getName());
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fields = clazz.getDeclaredFields();
        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("************获取字段并调用********************");
        Field field = clazz.getDeclaredField("name");
        ReflectEntity reflectPOJO = (ReflectEntity) clazz.getConstructor(null).newInstance();
        field.setAccessible(true);
        field.set(reflectPOJO, "MY");
        System.out.println(reflectPOJO.getName());
    }

    /**
     * 获取成员方法并调用
     * */
    static void case04() throws Exception{
        Class clazz = getBasicClass();
        ReflectEntity reflectPOJO = (ReflectEntity) clazz.getConstructor(null).newInstance();
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methods = clazz.getMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methods = clazz.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }

        System.out.println("************获取方法并调用********************");
        Method method = clazz.getDeclaredMethod("sayHello", String.class);
        method.setAccessible(true);
        method.invoke(reflectPOJO, "MY");
    }

    /**
     * 利用反射，调用main
     * */
    static void case05() throws Exception{
        Class clazz = getBasicClass();
        Method main = clazz.getMethod("main", String[].class);
        //1. 因为main方法是static, 所以可以用null
        //2. 这个String[]会被拆成三个对象， 所以需要强转成一个Object
        main.invoke(null, (Object) new String[]{"a", "b", "c"});

    }

    public static void main(String[] args) throws Exception{
        LocalReflect.case05();
    }

}


class Dog {

    private String name;

    private String property;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
