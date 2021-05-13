package com.epam.jdi.light.actions;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.aspectj.lang.JoinPoint;

import static com.epam.jdi.light.actions.ActionHelper.getJpClass;
import static com.epam.jdi.light.actions.ActionHelper.getJpInstance;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ActionOverride {
    private ActionOverride() { }
    static MapArray<JFunc1<JoinPoint, Boolean>, JFunc1<Object, Object>> OVERRIDE_ACTIONS_LIST =
        new MapArray<>();
    public static void overrideFunction(JFunc1<JoinPoint, Boolean> condition, JFunc1<Object, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(condition, func);
    }
    public static void overrideFunction(String actionName, JFunc1<Object, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(jp -> jp.getSignature().getName().equalsIgnoreCase(actionName), func);
    }
    public static void overrideFunction(String typeName, String actionName, JFunc1<Object, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(jp -> getJpTypeName(jp).equalsIgnoreCase(typeName)
                && jp.getSignature().getName().equalsIgnoreCase(actionName), func);
    }
    private static String getJpTypeName(JoinPoint jp) {
        Object obj = getJpInstance(jp);
        if (obj == null) {
            return getJpClass(jp).getSimpleName();
        }
        String typeName = ((DriverBase) getJpInstance(jp)).typeName;
        return isNotBlank(typeName)
            ? typeName
            : getJpInstance(jp).getClass().getSimpleName();
    }
    public static void overrideAction(JFunc1<JoinPoint, Boolean> condition, JAction1<Object> action) {
        overrideFunction(condition, jdi -> {
            action.execute(jdi);
            return null;
        });
    }
    public static void overrideAction(String actionName, JAction1<Object> action) {
        overrideFunction(actionName, jdi -> {
            action.execute(jdi);
            return null;
        });
    }
    public static void overrideAction(String className, String actionName, JAction1<Object> action) {
        overrideFunction(className, actionName, jdi -> {
            action.execute(jdi);
            return null;
        });
    }
    public static JFunc1<Object, Object> getOverrideAction(JoinPoint jp) {
        if (OVERRIDE_ACTIONS_LIST.isEmpty()) return null;
        for (Pair<JFunc1<JoinPoint, Boolean>, JFunc1<Object, Object>> override : OVERRIDE_ACTIONS_LIST)
            if (override.key.execute(jp))
                return override.value;
        return null;
    }
}
