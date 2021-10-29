package com.jdiai.listeners;

import com.jdiai.tools.func.JAction1;
import com.jdiai.tools.map.MultiMap;

import java.util.List;

public class JDIEvents {
    private static final MultiMap<String, JAction1<Object[]>> LISTENERS = new MultiMap<>();

    public static void registerJDIListener(String actionName, JAction1<Object[]> action) {
        LISTENERS.add(actionName, action);
    }

    public static void rewriteJDIListener(String actionName, JAction1<Object[]> action) {
        LISTENERS.removeByKey(actionName);
        LISTENERS.add(actionName, action);
    }

    public static void clearAllListeners() {
        LISTENERS.clear();
    }

    public static void clearListenersForAction(String actionName) {
        LISTENERS.removeByKey(actionName);
    }

    public static void fireEvent(String actionName, Object... args) {
        List<JAction1<Object[]>> actions = LISTENERS.getList(actionName);
        for (JAction1<Object[]> action : actions) {
            action.execute(args);
        }
    }

    public static final String BEFORE_ACTION_EVENT = "beforeAction";
    public static final String AFTER_ACTION_EVENT = "afterAction";
    public static final String AFTER_SUCCESS_ACTION_EVENT = "afterSuccessAction";
    public static final String AFTER_ACTION_FAIL_EVENT = "afterActionFail";
}
