package io.github.isliqian;

import java.lang.annotation.*;

/**
 * Created by LiQian_Nice on 2018/3/18
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AnnNiceEmail {

    Class inUse();
    String subject();
    String from();
    String to();

    @Deprecated
    String verificationCode() default "no verificationCode";

    @Deprecated
    String text() default "no text";

    @Deprecated
    String html() default "no html";
}
