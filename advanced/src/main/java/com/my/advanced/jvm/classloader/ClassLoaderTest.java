package com.my.advanced.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与 instance of 关键字演示
 * 不同的类加载器对 instance of 关键字运算的结果的影响
 *
 * @author YMa69
 * @date 2019/12/2
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
                try(InputStream is = getClass().getResourceAsStream(fileName)){
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.my.advanced.jvm.classloader.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.my.advanced.jvm.classloader.ClassLoaderTest);
    }
}
