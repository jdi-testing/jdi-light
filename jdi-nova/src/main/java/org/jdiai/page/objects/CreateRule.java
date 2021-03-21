package org.jdiai.page.objects;

import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class CreateRule {
    public static CreateRule cRule(JFunc1<Class<?>, Boolean> condition, JFunc1<Class<?>, Object> createAction) {
        return new CreateRule(condition, createAction);
    }
    public static CreateRule cRule(Class<?> interfaceClass, JFunc1<Class<?>, Object> createAction) {
        return cRule(cl -> isInterface(cl, interfaceClass), createAction);
    }

    public JFunc1<Class<?>, Boolean> condition;
    public JFunc1<Class<?>, Object> createAction;

    public CreateRule(JFunc1<Class<?>, Boolean> condition, JFunc1<Class<?>, Object> createAction) {
        this.condition = condition;
        this.createAction = createAction;
    }
}
