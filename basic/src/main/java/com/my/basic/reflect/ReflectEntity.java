package com.my.basic.reflect;

/**
 * @author YMa69
 * @date 2019/12/11.
 */
public class ReflectEntity {

    private String name;

    private int age;

    private boolean marry;

    /******* 构造方法 *******/

    /** 无参构造函数 */
    public ReflectEntity(){
        System.out.println("无参、公有构造方法");
    }

    /** 一个参数构造函数 */
    public ReflectEntity(String name){
        System.out.println("一个参数、公有构造方法 name:"+name);
    }

    /** 多个参数构造函数 */
    public ReflectEntity(String name, int age, boolean marry){
        System.out.println("多个参数、公有构造方法 name:"+name +", age:"+age+", marry="+marry);
    }

    /** 多个参数构造函数 */
    protected ReflectEntity(String name, int age){
        System.out.println("多个参数、保护构造方法 name:"+name +", age:"+age);
    }

    /** 多个参数构造函数 */
    private ReflectEntity(String name, boolean marry){
        System.out.println("多个参数、公有构造方法 name:"+name +", marry="+marry);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarry() {
        return marry;
    }

    public void setMarry(boolean marry) {
        this.marry = marry;
    }

    private void sayHello(String input){
        System.out.println("hello, "+input);
    }

    public static void main(String[] args){
        for(String s: args){
            System.out.println(s);
        }
    }
}
