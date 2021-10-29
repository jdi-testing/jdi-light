package com.jdiai.listeners;

import com.jdiai.interfaces.HasCore;
import com.jdiai.tools.Safe;
import com.jdiai.tools.map.MapArray;

import static com.jdiai.JDI.logger;
import static com.jdiai.tools.StringUtils.msgFormat;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class JDILogListener implements JDIEventsListener {
    Safe<Boolean> logAction = new Safe<>(() -> true);
    public static int CUT_TEXT_LENGTH = 70;

    public void beforeAction(String actionName, String step, HasCore element) {
        if (step == null) {
            logger().debug(actionName);
            return;
        }
        if (!logAction.get()) {
            return;
        }
        String stepToLog = element != null
            ? msgFormat(step, new MapArray<>("name", element.getName()))
            : step;
        if (CUT_TEXT_LENGTH > 5 && stepToLog.length() > CUT_TEXT_LENGTH) {
            stepToLog = stepToLog.substring(0, CUT_TEXT_LENGTH - 3) + "...";
        }
        logger().info(stepToLog);
        if (actionName.equals("shouldBe()")) {
            logAction.set(false);
        }
    }

    public void afterAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed) {
    }

    public void afterSuccessAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed) {
        if (actionName.equals("shouldBe()")) {
            logAction.set(true);
        }
        if (result != null) {
            String logMessage = ">>> " + result;
            if (isNotBlank(step)) {
                logger().info(logMessage);
            } else {
                logger().debug(logMessage);
            }
        }
    }

    public void afterFailAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed, Throwable failException, String failAssertMessage) {
    }
}
