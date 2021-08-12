package com.my.basic.func;

import com.my.basic.copy.shallow.AddressShallow;

/**
 * @author tiny_v
 * @date 2021/8/12.
 *
 * 不管参数类型是啥， 都是值传递， 区别无非是拷贝目标对象，还是拷贝指针
 *
 */
public class functionTest {

    /**
     * 基本数据类型传值，对形参的修改不会影响实参
     * @param a
     */
    public static void testParam1(int a){
        a = a+1;
    }

    /**
     * String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
     * @param str
     */
    public static void testParam2(String str){
        str = "world";
    }

    /**
     * 引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象
     * @param addressShallow
     */
    public static void testParam3(AddressShallow addressShallow){
        addressShallow.setCity("WuXi");
        addressShallow.setProvince("JiangSu");
    }

    public static void main(String[] args){
        //
        int a = 1;
        functionTest.testParam1(a);
        System.out.println(a);
        // String 是final 不可变
        String str = "hello";
        functionTest.testParam2(str);
        System.out.println(str);
        //
        AddressShallow addressShallow = new AddressShallow();
        addressShallow.setCity("ShangQiu");
        addressShallow.setProvince("HeNan");
        testParam3(addressShallow);
        System.out.println(addressShallow.getProvince());
    }

}
