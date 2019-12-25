package com.my.basic.serialize;

import java.io.*;

/**
 *
 * 序列化：序列化是指将对象的状态信息转换为可以 存储 或 传输 形式的过程； 在序列化期间，对象将其状态写入临时或持久性存储区；
 *        以后，可以通过从存储区读取或反序列化对象的状态，重新创建该对象.
 *
 * JDK自带序列化：
 *        使用Long型的成员变量 serialVersionUID 来表示类的版本号；
 *        序列化时，JVM 会把 serialVersionUID 变量值写入类的序列化数据中。
 *        反序列化时， JVM 会将序列化数据中的serialVersionUID 与类中的做对比。
 *        若相同，则继续进行反序列化; 若不同，则报InvalidCastException
 *
 * 注：使用对象输入输入流来来对对象做序列化与反序列化， 可以实现对象的深拷贝
 *
 * @author YMa69
 * @date 2019/12/25.
 */
public class SerialEntity implements Serializable{

    /**
     * (1) serialVersionUID 默认值是 1L;
     * (2) 另一种是根据类名、接口名、成员方法及属性等生成的一个64为Hash
     * */
    private static final long serialVersionUID = 1L;

    /** static 修饰的字段， 不会被序列化 */
    private static String nonSerial = "will not be serialization";

    /** transient 修饰的字段， 也不会被序列化 */
    private transient String nonSerial2 = "will not be serialization too";

    private String name;

    private Integer age;

    public SerialEntity(String nonSerial2, String name, Integer age){
        this.nonSerial2 = nonSerial2;
        this.name = name;
        this.age = age;
    }


    /**
     * 使用ObjectOutputStream将 SerialEntity 实例序列化到文件中
     */
    public void doSerialization(SerialEntity serialEntity){
        String filePath = new File("").getAbsolutePath()+"/basic/serialize/serialEntity.serial";
        createFile(filePath);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serialEntity);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 使用ObjectInputStream 从序列化文件serialEntity.serial中读取并生成SerialEntity 实例
     */
    public void doDeSerialization(){
        String filePath = new File("").getAbsolutePath()+"/basic/serialize/serialEntity.serial";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            SerialEntity serialEntity = (SerialEntity) objectInputStream.readObject();
            // null
            System.out.println(serialEntity.nonSerial2);
            // W二狗
            System.out.println(serialEntity.name);
            // 25
            System.out.println(serialEntity.age);
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
        SerialEntity serialEntity = new SerialEntity("nonSerial2", "W二狗", 25);
        SerialEntity.nonSerial = "nonSerial";
        serialEntity.doSerialization(serialEntity);
        serialEntity.doDeSerialization();
    }


}
