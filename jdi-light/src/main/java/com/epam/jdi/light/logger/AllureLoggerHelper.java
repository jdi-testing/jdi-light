package com.epam.jdi.light.logger;

import io.qameta.allure.model.StepResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.epam.jdi.light.common.Exceptions.exception;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.PASSED;
import static io.qameta.allure.model.Status.FAILED;

public class AllureLoggerHelper {
    public static boolean writeToAllure = true;

    public static void startStep(String uuid, String message){
        if (!writeToAllure) return;

        StepResult step = new StepResult().withName(message).withStatus(PASSED);
        getLifecycle().startStep(uuid, step);
    }

    public static void passStep(String uuid) {
        if (!writeToAllure) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }

    public static void failStep(String uuid, String screenName) {
        if (!writeToAllure) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(FAILED));
        if (screenName != null) {
            try {
                attachScreenshot(screenName);
            } catch (IOException ex) {
                throw exception(ex, ex.getMessage());
            }
        }

        getLifecycle().stopStep(uuid);
    }

    private static void attachScreenshot(String screenName) throws IOException {
        if (!writeToAllure) return;
        getLifecycle().addAttachment("Page screenshot", "image", "jpg", Files.readAllBytes(Paths.get(screenName)));
    }

}
