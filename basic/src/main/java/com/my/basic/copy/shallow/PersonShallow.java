package com.my.basic.copy.shallow;

/**
 * 浅拷贝
 *
 * @author YMa69
 * @date 2019/12/4
 */
public class PersonShallow implements Cloneable{

    /** int 类型为基本数据类型 */
    private int age;
    /** String 为引用类型，但和其它引用类型有别 */
    private String name;
    /** 类 为引用类型 */
    private AddressShallow address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressShallow getAddress() {
        return address;
    }

    public void setAddress(AddressShallow address) {
        this.address = address;
    }

    @Override
    protected Object clone() {
        PersonShallow personShallow = null;
        try{
            personShallow = (PersonShallow)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return personShallow;
    }

    public void print(){
        System.out.println("age:"+this.age+", name:"+this.name +", province:"+this.address.getProvince()+", city:"+this.address.getCity());
    }
}
