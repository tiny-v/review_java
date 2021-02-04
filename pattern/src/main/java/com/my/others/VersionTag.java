package com.my.others;

import java.lang.annotation.*;

/**
 * @author mayue
 * @date 2021/2/3.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VersionTag {

    Version value() default Version.VERSION_1;

}
