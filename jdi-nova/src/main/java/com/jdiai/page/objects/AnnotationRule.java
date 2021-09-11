package com.jdiai.page.objects;

import com.jdiai.interfaces.HasCore;
import com.jdiai.tools.func.JAction3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.function.BiConsumer;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class AnnotationRule<A extends Annotation> {
    public Class<? extends Annotation> annotation;
    public JAction3<HasCore, A, Field> action;
    public AnnotationRule(Class<A> annotation, BiConsumer<HasCore, A> action) {
        this.annotation = annotation;
        this.action = (b,a,f) -> action.accept(b,a);
    }
    public AnnotationRule(Class<A> annotation, JAction3<HasCore, A, Field> action) {
        this.annotation = annotation;
        this.action = action;
    }
    public static <A extends Annotation> AnnotationRule<A> aRule(Class<A> cl, BiConsumer<HasCore, A> action) {
        return new AnnotationRule<>(cl, action);
    }
    public static <A extends Annotation> AnnotationRule<A> aRule(Class<A> cl, JAction3<HasCore, A, Field> action) {
        return new AnnotationRule<>(cl, action);
    }

}
