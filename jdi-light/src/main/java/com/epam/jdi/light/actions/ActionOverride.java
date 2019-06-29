package com.epam.jdi.light.actions;

import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.aspectj.lang.ProceedingJoinPoint;

public class ActionOverride {
    private ActionOverride() { }
    static MapArray<JFunc1<ProceedingJoinPoint, Boolean>, JFunc1<JDIBase, Object>> OVERRIDE_ACTIONS_LIST =
        new MapArray<>();
    public static void OverrideFunction(JFunc1<ProceedingJoinPoint, Boolean> condition, JFunc1<JDIBase, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(condition, func);
    }
    public static void OverrideFunction(String actionName, JFunc1<JDIBase, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(jp -> jp.getSignature().getName().equals(actionName), func);
    }
    public static void OverrideFunction(String typeName, String actionName, JFunc1<JDIBase, Object> func) {
        OVERRIDE_ACTIONS_LIST.add(jp -> getJpTypeName(jp).equals(typeName)
                && jp.getSignature().getName().equals(actionName), func);
    }
    private static String getJpTypeName(ProceedingJoinPoint jp) {
        return ((DriverBase)jp.getThis()).typeName;
    }
    public static void OverrideAction(JFunc1<ProceedingJoinPoint, Boolean> condition, JAction1<JDIBase> action) {
        OverrideFunction(condition, jdi -> { action.execute(jdi); return null; });
    }
    public static void OverrideAction(String actionName, JAction1<JDIBase> action) {
        OverrideFunction(actionName, jdi -> { action.execute(jdi); return null; });
    }
    public static void OverrideAction(String className, String actionName, JAction1<JDIBase> action) {
        OverrideFunction(className, actionName, jdi -> { action.execute(jdi); return null; });
    }
    public static JFunc1<JDIBase, Object> GetOverrideAction(ProceedingJoinPoint jp) {
        if (OVERRIDE_ACTIONS_LIST.isEmpty()) return null;
        for (Pair<JFunc1<ProceedingJoinPoint, Boolean>, JFunc1<JDIBase, Object>> override : OVERRIDE_ACTIONS_LIST)
            if (override.key.execute(jp))
                return override.value;
        return null;
    }
}
