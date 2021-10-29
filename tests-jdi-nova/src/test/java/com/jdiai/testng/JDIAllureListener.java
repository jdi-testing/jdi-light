package com.jdiai.testng;

import com.jdiai.interfaces.HasCore;
import com.jdiai.listeners.JDIEventsListener;
import com.jdiai.tools.Safe;
import com.jdiai.tools.map.MapArray;

import static com.jdiai.listeners.JDILogListener.CUT_TEXT_LENGTH;
import static com.jdiai.testng.AllureHandler.passAllureStep;
import static com.jdiai.testng.AllureHandler.startAllureStep;
import static com.jdiai.tools.StringUtils.msgFormat;
import static io.qameta.allure.Allure.addAttachment;

public class JDIAllureListener implements JDIEventsListener {
    Safe<Boolean> logToAllure = new Safe<>(() -> true);

    public void beforeAction(String actionName, String step, HasCore element) {
        if (step == null || !logToAllure.get()) {
            return;
        }
        String stepToLog = element != null
            ? msgFormat(step, new MapArray<>("name", element.getName()))
            : step;
        if (CUT_TEXT_LENGTH > 5 && stepToLog.length() > CUT_TEXT_LENGTH) {
            stepToLog = stepToLog.substring(0, CUT_TEXT_LENGTH - 3) + "...";
        }
        startAllureStep(stepToLog);
        if (actionName.equals("shouldBe()")) {
            logToAllure.set(false);
        }
    }

    public void afterAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed) {
        if (logToAllure.get()) {
            passAllureStep();
        }
    }

    public void afterSuccessAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed) {
        if (actionName.equals("shouldBe()")) {
            logToAllure.set(true);
        }
        if (logToAllure.get()) {
            if (result != null) {
                addAttachment("Result", "text/plain", result.toString(), "html");
            }
        }
    }

    public void afterFailAction(String actionName, String step, HasCore element, Object result, long timeout, long timePassed, Throwable failException, String failAssertMessage) {
    }
}
