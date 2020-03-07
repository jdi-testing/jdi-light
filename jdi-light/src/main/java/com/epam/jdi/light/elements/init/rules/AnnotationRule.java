package com.epam.jdi.light.elements.init.rules;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.func.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class AnnotationRule<A extends Annotation> {
    public Class<?> annotation;
    public JAction3<IBaseElement, A, Field> action;
    public AnnotationRule(Class<A> annotation, JAction2<IBaseElement, A> action) {
        this.annotation = annotation;
        this.action = (b,a,i) -> action.execute(b,a);
    }
    public AnnotationRule(Class<A> annotation, JAction3<IBaseElement, A, Field> action) {
        this.annotation = annotation;
        this.action = action;
    }
    public static <A extends Annotation> AnnotationRule aRule(Class<A> cl, JAction2<IBaseElement, A> action) {
        return new AnnotationRule<>(cl, action);
    }
    public static <A extends Annotation> AnnotationRule aRule(Class<A> cl, JAction3<IBaseElement, A, Field> action) {
        return new AnnotationRule<>(cl, action);
    }

}
