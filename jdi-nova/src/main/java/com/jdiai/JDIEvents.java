package com.jdiai;

import com.jdiai.tools.func.JAction1;
import com.jdiai.tools.map.MultiMap;

import java.util.List;

public class JDIEvents {
    private static final MultiMap<String, JAction1<Object[]>> LISTENERS = new MultiMap<>();

    public static void registerActionListener(String actionName, JAction1<Object[]> action) {
        LISTENERS.add(actionName, action);
    }
    public static void rewriteActionListener(String actionName, JAction1<Object[]> action) {
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
    // Args: [actionName, step | null, element]
    public static final String AFTER_ACTION_EVENT = "afterAction";
    // Args: [actionName, step | null, element]
    public static final String AFTER_SUCCESS_ACTION_EVENT = "afterSuccessAction";
    // Args: [actionName, step | null, element, result | null]
    public static final String AFTER_ACTION_FAIL_EVENT = "afterActionFail";
    // Args: [actionName, step | null, element, ex | null]
    public static final String SHOULD_OUT_OF_TIME_EVENT = "shouldOutOfTime";
    // Args: [element, timeout, failAssertName, lastResult]
    public static final String SHOULD_ASSERT_FAILED_EVENT = "shouldAssertFailed";
    // Args: [element, timeout, failAssertName, lastResult]
}
