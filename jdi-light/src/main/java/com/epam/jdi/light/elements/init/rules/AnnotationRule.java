package com.epam.jdi.light.elements.init.rules;

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.tools.func.JAction2;
import com.epam.jdi.tools.func.JAction3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationRule<A extends Annotation> {
    public Class<?> annotation;
    public JAction3<JDIBase, A, Field> action;
    public AnnotationRule(Class<A> annotation, JAction2<JDIBase, A> action) {
        this.annotation = annotation;
        this.action = (b,a,i) -> action.execute(b,a);
    }
    public AnnotationRule(Class<A> annotation, JAction3<JDIBase, A, Field> action) {
        this.annotation = annotation;
        this.action = action;
    }
    public static <A extends Annotation> AnnotationRule aRule(Class<A> cl, JAction2<JDIBase, A> action) {
        return new AnnotationRule<>(cl, action);
    }
    public static <A extends Annotation> AnnotationRule aRule(Class<A> cl, JAction3<JDIBase, A, Field> action) {
        return new AnnotationRule<>(cl, action);
    }

}
