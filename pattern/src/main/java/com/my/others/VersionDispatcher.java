package com.my.others;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mayue
 * @date 2021/2/3.
 */
public class VersionDispatcher {

    public static void main(String[] args){
        Version requiredVersion = Version.VERSION_2;

        List<Class> classes = new VersionDispatcher().scanFile();
        classes.stream().forEach(clazz->{
            VersionTag versionTag = (VersionTag) clazz.getAnnotation(VersionTag.class);
            if(requiredVersion.equals(versionTag.value())){
                try {
                    //实例化并执行指定方法
                    VersionInterface versionInterface = (VersionInterface) clazz.newInstance();
                    System.out.println(versionInterface.processLogical());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * 查找当前路径下，注解为 VersionTag的类
     */
    private List<Class> scanFile() {
        ArrayList<File> files = scanFiles(VersionDispatcher.class.getResource("").getPath());
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        List<Class> classes = files.stream().map(file->{
                    try {
                        Class clazz =  classLoader.loadClass(VersionDispatcher.class.getPackage().getName()+"."+file.getName().replace(".class", ""));
                        Annotation[] annotations = clazz.getAnnotations();
                        if(annotations.length>0){
                            long count = Stream.of(annotations).filter(annotation -> annotation instanceof VersionTag).count();
                            return count>0 ? clazz :null;
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
        ).filter(clazz -> clazz!=null).collect(Collectors.toList());
        return classes;
    }


    /**
     * 查找某一路径下的所有文件
     * @param path
     */
    private ArrayList<File> scanFiles(String path) {
        ArrayList<File> result = new ArrayList<>();
        File file = new File(path);
        //遍历该目录所有文件和文件夹对象
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                //递归操作，逐一遍历各文件夹内的文件
                result.addAll(scanFiles(files[i].toString()));
            } else {
                if (!files[i].isDirectory()){
                    result.add(files[i]);
                }
            }
        }
        return result;
    }
}
