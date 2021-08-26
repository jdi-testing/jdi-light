package com.jdiai.page.objects;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.jdiai.tools.ReflectionUtils.isInterface;

public class SetupRule {
    public static SetupRule sRule(Function<InitInfo, Boolean> condition, Consumer<InitInfo> action) {
        return new SetupRule(condition, action);
    }
    public static SetupRule sRule(Class<?> interfaceClass, Consumer<InitInfo> action) {
        return sRule(i -> isInterface(i.instanceClass(), interfaceClass), action);
    }

    public Function<InitInfo, Boolean> condition;
    public Consumer<InitInfo> action;

    public SetupRule(Function<InitInfo, Boolean> condition, Consumer<InitInfo> action) {
        this.condition = condition;
        this.action = action;
    }
}
