package io.github.epam.steps;

import ru.yandex.qatools.allure.annotations.Step;

import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.entities.Users.DEFAULT_USER;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    @Step
    public static void shouldBeLoggedIn() {
        if (!header.piterChailovskii.isDisplayed())
            login();
    }
    @Step
    public static void login() {
        header.userIcon.click();
        header.loginForm.submit(DEFAULT_USER, "enter");
    }
    @Step
    public static void shouldBeLoggedOut() {
        System.out.println("THREAD ID" + Thread.currentThread().getId());
        if (header.piterChailovskii.isDisplayed())
            logout();
    }
    @Step
    public static void logout() {
        header.userIcon.click();
        header.logout.click();
    }
}
