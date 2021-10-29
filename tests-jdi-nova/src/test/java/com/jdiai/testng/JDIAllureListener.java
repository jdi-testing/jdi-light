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


    // registerJDIListener(BEFORE_ACTION_EVENT, args -> {
    //     if (!logToAllure.get()) {
    //         return;
    //     }
    //     if (args.length < 2) {
    //         return;
    //     }
    //     Object stepArg = args[1];
    //     if (stepArg == null || !isClass(stepArg.getClass(), String.class)) {
    //         return;
    //     }
    //     String step = (String) stepArg;
    //     String stepToLog = args.length > 2
    //         ? msgFormat(step, new MapArray<>("name", ((HasName) args[2]).getName()))
    //         : step;
    //     if (stepToLog.length() > 70) {
    //         stepToLog = stepToLog.substring(0, 67) + "...";
    //     }
    //     logger.info(stepToLog);
    //     startAllureStep(stepToLog);
    //     if (args[0].equals("shouldBe()")) {
    //         logToAllure.set(false);
    //     }
    // });
    // registerJDIListener(AFTER_ACTION_EVENT,
    //     args -> {
    //     if (args[0].equals("shouldBe()")) {
    //         logToAllure.set(true);
    //         if (args.length > 2) {
    //             Object result = args[2];
    //             if (result != null) {
    //                 addAttachment("Result", "text/plain", result.toString(), "html");
    //             }
    //         }
    //     }
    //     if (logToAllure.get()) {
    //         passAllureStep();
    //     }
    // });
}
