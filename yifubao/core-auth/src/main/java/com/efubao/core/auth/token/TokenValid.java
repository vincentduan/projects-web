package com.efubao.core.auth.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * token annotation
 * 来源于V
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenValid {

    /** 保存token */
    boolean saveToken() default false;

    /** 删除token */
    boolean removeToken() default false;

}
