package com.jackie.springbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @Author: Jackie
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DemoAnnotation {

}
