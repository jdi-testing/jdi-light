package com.jdiai.page.objects;

import java.util.function.Function;

import static com.jdiai.tools.ReflectionUtils.isInterface;

public class CreateRule {
    public static CreateRule cRule(Function<Class<?>, Boolean> condition, Function<Class<?>, Object> createAction) {
        return new CreateRule(condition, createAction);
    }
    public static CreateRule cRule(Class<?> interfaceClass, Function<Class<?>, Object> createAction) {
        return cRule(cl -> isInterface(cl, interfaceClass), createAction);
    }

    public Function<Class<?>, Boolean> condition;
    public Function<Class<?>, Object> createAction;

    public CreateRule(Function<Class<?>, Boolean> condition, Function<Class<?>, Object> createAction) {
        this.condition = condition;
        this.createAction = createAction;
    }
}
