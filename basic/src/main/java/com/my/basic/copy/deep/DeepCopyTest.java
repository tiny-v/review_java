package com.my.basic.copy.deep;

/**
 *
 * @author YMa69
 * @date 2019/12/4
 */
public class DeepCopyTest {

    public static void main(String[] args){
        PersonDeep p1 = new PersonDeep();
        p1.setAge(25);
        p1.setName("MY");
        AddressDeep address = new AddressDeep();
        address.setProvince("JS");
        address.setCity("XZ");
        p1.setAddress(address);

        PersonDeep p2 = (PersonDeep)p1.deepCopy(p1);

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
        // age:25, name:MY, province:JS, city:XZ
        p1.print();
        // age:26, name:RZ, province:JS, city:WX
        p2.print();
    }


}
