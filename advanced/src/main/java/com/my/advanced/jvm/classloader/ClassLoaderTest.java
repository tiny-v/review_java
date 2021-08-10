package com.my.advanced.jvm.classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(ClassLoaderTest.class);

    public ClassLoader defineClassLoader(){
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
        return myLoader;
    }

    public static void main(String[] args) throws Exception{
        /* 当前类的类加载器 */
        ClassLoaderTest clt = new ClassLoaderTest();
        ClassLoader cltClassLoader = clt.getClass().getClassLoader();
        logger.info("当前类的类加载器：{}", cltClassLoader.toString());
        /* 自定义的类加载器 */
        ClassLoader classLoader = clt.defineClassLoader();
        logger.info("自定义类加载器：{}", classLoader.toString());
        logger.info("自定义类加载器的父类：{}", classLoader.getParent().toString());
        /* 使用自定义类加载器，加载当前类 */
        Object obj = classLoader.loadClass("com.my.advanced.jvm.classloader.ClassLoaderTest").newInstance();
        logger.info("自定义类加载器加载的类：{}", obj.getClass());
        logger.info("该类是否和系统加载器加载的同一个类，是同一个东西：{}", obj instanceof com.my.advanced.jvm.classloader.ClassLoaderTest);
    }
}
