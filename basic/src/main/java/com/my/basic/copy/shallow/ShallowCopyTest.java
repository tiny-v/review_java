package com.my.basic.copy.shallow;

/**
 * 使用native 的 clone()实现浅拷贝
 * 1. 基本类型的成员变量会不同
 * 2. 除String类型以外的引用类型， 指向的还是同一个地址
 * @author YMa69
 * @date 2019/12/4
 */
public class ShallowCopyTest {

    public static void main(String[] args){
        PersonShallow p1 = new PersonShallow();
        p1.setAge(25);
        p1.setName("MY");
        AddressShallow address = new AddressShallow();
        address.setProvince("JS");
        address.setCity("XZ");
        p1.setAddress(address);

        PersonShallow p2 = (PersonShallow)p1.clone();

        // p1:com.my.learn.others.shallow.PersonDeep@4554617c
        System.out.println("p1:"+ p1);
        // p2:com.my.learn.others.shallow.PersonDeep@74a14482
        System.out.println("p2:"+ p2);
        // age:25, name:MY, province:JS, city:XZ
        p1.print();
        // age:25, name:MY, province:JS, city:XZ
        p2.print();

        p2.setAge(26);
        p2.setName("RZ");
        p2.getAddress().setCity("WX");
        // age:25, name:MY, province:JS, city:WX
        p1.print();
        // age:26, name:RZ, province:JS, city:WX
        p2.print();

    }

}
