package io.github.com.custom;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FirstTokenCapitalisation {
}
