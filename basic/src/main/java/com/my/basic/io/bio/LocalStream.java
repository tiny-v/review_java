package com.my.basic.io.bio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用来展示 java.io  InputStream & OutputStream 案列
 * @author YMa69
 * @date 2019/12/8
 */
public class LocalStream {

    static String testFile = "/MyJavaBasic/src/main/resources/io/test.txt";

    /** 二进制文件的写入 */
    static void case01() throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsoluteFile()+testFile);
        byte[] a = {11,22,33,44,55};
        // 写入的文件为二进制， 打开会是乱码
        fileOutputStream.write(a);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    /** 二进制文件的读取 */
    static void case02() throws IOException{
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsoluteFile()+testFile);
        // 写入的文件为二进制， 打开会是乱码
        int c;
        while((c = fileInputStream.read())!=-1){
            System.out.println(c);
        }
        fileInputStream.close();
    }

    public static void main(String[] args) throws IOException{
        LocalStream.case01();
        LocalStream.case02();
    }

}
