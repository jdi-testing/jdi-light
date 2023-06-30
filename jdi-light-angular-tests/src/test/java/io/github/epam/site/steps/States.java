package io.github.epam.site.steps;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.StaticSite;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static io.github.com.StaticSite.*;

public class States {
    @Step
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains("https://jdi-testing.github.io/jdi-light/")) {
            angularPage.open();
        }
        if (userName.isHidden()) {
            login();
        }
    }

    @Step
    public static void login() {
        if (loginForm.isHidden()) {
            userIcon.click();
        }
        loginForm.submit(StaticSite.defaultUser);
    }

    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains(DRIVER.domain)) {
            openUrl(DRIVER.domain);
        }
        if (userName.isDisplayed()) {
            logout();
        }
        if (loginForm.isDisplayed()) {
            userIcon.click();
        }
    }

    @Step
    public static void logout() {
        if (!logout.isDisplayed()) {
            userIcon.click();
        }
        logout.click();
    }
}
