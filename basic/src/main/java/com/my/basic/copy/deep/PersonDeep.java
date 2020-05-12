package com.my.basic.copy.deep;


import java.io.*;

/**
 * 浅拷贝
 *
 * @author YMa69
 * @date 2019/12/4
 */
public class PersonDeep implements Serializable{

    /** int 类型为基本数据类型 */
    private int age;
    /** String 为引用类型，但和其它引用类型有别 */
    private String name;
    /** 类 为引用类型 */
    private AddressDeep address;

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

    public AddressDeep getAddress() {
        return address;
    }

    public void setAddress(AddressDeep address) {
        this.address = address;
    }

    public void print(){
        System.out.println("age:"+this.age+", name:"+this.name +", province:"+this.address.getProvince()+", city:"+this.address.getCity());
    }


    public Object deepCopy(Serializable src){
        Object dest = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        try{

            try {
                bos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(bos);
                oos.writeObject(src);
                oos.flush();
            }finally{
                oos.close();
            }


            byte[] bytes = bos.toByteArray();
            ObjectInputStream ois = null;
            try{
                ois =  new ObjectInputStream(new ByteArrayInputStream(bytes));
                dest = ois.readObject();
            }finally{
                ois.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return dest;

    }
}
