package io.github.isliqian;

import java.lang.annotation.*;


/**
 * Created by LiQian_Nice on 2018/3/18
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AnnNiceConfig {

    String type();

    String username();

    String password();






}
