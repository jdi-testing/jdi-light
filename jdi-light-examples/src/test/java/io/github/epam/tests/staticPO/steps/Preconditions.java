package io.github.epam.tests.staticPO.steps;

import ru.yandex.qatools.allure.annotations.Step;

import static io.github.epam.entities.Users.DEFAULT_USER;
import static staticPageObject.pages.Header.*;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    @Step
    public static void shouldBeLoggedIn() {
        if (!piterChailovskii.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
    }
    @Step
    public static void shouldBeLoggedOut() {
        System.out.println("THREAD ID" + Thread.currentThread().getId());
        if (piterChailovskii.isDisplayed())
            logout();
    }
    @Step
    public static void logout() {
        userIcon.click();
        logout.click();
    }
}
