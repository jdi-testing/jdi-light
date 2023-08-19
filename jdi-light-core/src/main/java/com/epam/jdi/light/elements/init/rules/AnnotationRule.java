package com.epam.jdi.light.elements.init.rules;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.jdiai.tools.func.JAction2;
import com.jdiai.tools.func.JAction3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class AnnotationRule<A extends Annotation> {
    public Class<? extends Annotation> annotation;
    public JAction3<IBaseElement, A, Field> action;
    public AnnotationRule(Class<A> annotation, JAction2<IBaseElement, A> action) {
        this.annotation = annotation;
        this.action = (b,a,i) -> action.execute(b,a);
    }
    public AnnotationRule(Class<A> annotation, JAction3<IBaseElement, A, Field> action) {
        this.annotation = annotation;
        this.action = action;
    }
    public static <A extends Annotation> AnnotationRule<A> aRule(Class<A> cl, JAction2<IBaseElement, A> action) {
        return new AnnotationRule<>(cl, action);
    }
    public static <A extends Annotation> AnnotationRule<A> aRule(Class<A> cl, JAction3<IBaseElement, A, Field> action) {
        return new AnnotationRule<>(cl, action);
    }

}
