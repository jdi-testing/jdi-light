package org.jdiai.page.objects;

import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class SetupRule {
    public static SetupRule sRule(JFunc1<InitInfo, Boolean> condition, JAction1<InitInfo> action) {
        return new SetupRule(condition, action);
    }
    public static SetupRule sRule(Class<?> interfaceClass, JAction1<InitInfo> action) {
        return sRule(i -> isInterface(i.instanceClass(), interfaceClass), action);
    }

    public JFunc1<InitInfo, Boolean> condition;
    public JAction1<InitInfo> action;

    public SetupRule(JFunc1<InitInfo, Boolean> condition, JAction1<InitInfo> action) {
        this.condition = condition;
        this.action = action;
    }
}
