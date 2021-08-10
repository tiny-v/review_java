package com.my.basic.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author mayue
 * @date 2020/7/9.
 */
@AnnotationTest
public class AnnotationTestMain {

    public static void main(String[] args){
        Annotation[] annotations = AnnotationTestMain.class.getAnnotations();
        Arrays.stream(annotations).forEach(annotation->{
            // fields
            //Field[] fields = annotation.getClass().getFields();
            //Arrays.stream(fields).forEach(System.out::println);
            // methods
            Method[] methods = annotation.getClass().getMethods();
            Arrays.stream(methods).forEach(System.out::println);
        });
    }

}
