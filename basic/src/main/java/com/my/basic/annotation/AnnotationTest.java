package com.my.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mayue
 * @date 2020/7/9.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AnnotationTest("abc")
public @interface AnnotationTest {

    String value() default "default value";

}
