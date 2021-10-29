package com.jdiai.testng;

import com.jdiai.tools.Safe;
import io.qameta.allure.model.StepResult;

import java.util.Stack;

import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.PASSED;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class AllureHandler {
    private static final Safe<Stack<String>> stepUUIDs = new Safe<>(Stack::new);

    private static String getStepUUID() {
        try {
            return stepUUIDs.get().pop();
        } catch (Throwable ex) {
            return "";
        }
    }

    public static void startAllureStep(String message) {
        try {
            StepResult step = new StepResult().setName(message);
            if (getLifecycle().getCurrentTestCase().isPresent()) {
                String uuid = randomUUID().toString();
                stepUUIDs.get().add(uuid);
                getLifecycle().startStep(uuid, step);
            }
        } catch (Exception ignore) { }
    }

    public static void passAllureStep() {
        String uuid = getStepUUID();
        if (isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.setStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }
}
