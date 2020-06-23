package com.lin.aop_datasource.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DS {
    String value() default "readTestDb";
}