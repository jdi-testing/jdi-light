package io.github.epam.steps;

import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.entities.Users.DEFAULT_USER;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */
public class Preconditions {
    public static void loggedIn() {
        if (!header.piterChailovskii.isDisplayed()) {
            header.userIcon.click();
            header.loginForm.submit(DEFAULT_USER, "enter");
        }
    }
    public static void loggedOut() {
        if (header.piterChailovskii.isDisplayed()) {
            header.userIcon.click();
            header.logout.click();
        }
    }
}
