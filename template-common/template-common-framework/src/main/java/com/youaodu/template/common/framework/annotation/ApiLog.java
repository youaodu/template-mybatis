package com.youaodu.template.common.framework.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 描述信息
     * @return
     */
    String desc() default "";
}
