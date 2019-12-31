package com.my.basic.serialization;

import java.io.*;

/**
 * @author YMa69
 * @date 2019/12/27.
 */
public class SerialTransientEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /** transient 修饰的成员变量是无法被自动序列化的，这里介绍一种可以实现 transient 字段的手动序列化操作 */
    private transient String transientField;

    private String name;

    private Integer age;

    public SerialTransientEntity(String transientField, String name, Integer age){
        this.transientField = transientField;
        this.name = name;
        this.age = age;
    }

    /** 重写writeObject方法 */
    private void writeObject(ObjectOutputStream s){
        try{
            // 序列化 non-transient 成员变量
            s.defaultWriteObject();
            // 序列化被 transient 修饰的成员变量
            s.writeObject(transientField);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用ObjectOutputStream将 serialTransientEntity 实例序列化到文件中
     */
    public void doSerialization(SerialTransientEntity serialTransientEntity){
        String filePath = new File("").getAbsolutePath()+"/basic/serialize/serialTransientEntity.ser";
        createFile(filePath);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serialTransientEntity);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**重写readObject()方法*/
    private void readObject(ObjectInputStream objectInputStream){
        try{
            // 反序列化 non-transient 成员变量
            objectInputStream.defaultReadObject();
            // 反序列化 transient 修饰的成员变量
            transientField = (String)objectInputStream.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 使用ObjectInputStream 从序列化文件 serialTransientEntity.serial中读取并生成SerialTransientEntity 实例
     */
    public void doDeSerialization(){
        String filePath = new File("").getAbsolutePath()+"/basic/serialize/serialTransientEntity.ser";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            SerialTransientEntity serialTransientEntity = (SerialTransientEntity) objectInputStream.readObject();
            // i'm transient field
            System.out.println(serialTransientEntity.transientField);
            // W二狗
            System.out.println(serialTransientEntity.name);
            // 25
            System.out.println(serialTransientEntity.age);
        }catch (IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void createFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            // 先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdir();
            try {
                // 创建文件
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        SerialTransientEntity serialTransientEntity = new SerialTransientEntity("i'm transient field", "W二狗", 25);
        serialTransientEntity.doSerialization(serialTransientEntity);
        serialTransientEntity.doDeSerialization();
    }
}
