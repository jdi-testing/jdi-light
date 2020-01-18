package io.github.epam.states;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;
import static io.github.com.StaticSite.*;
import static io.github.epam.test.data.UsersUtils.DEFAULT_USER;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */

@SuppressWarnings("PMD.ClassNamingConventions")
public class States {
    @Step
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains(DOMAIN)
            || url.contains("issue"))
            openUrl(DOMAIN);
        if (userName.isHidden())
            login();
    }

    @Step
    public static void login() {
        if (loginForm.isHidden())
            userIcon.click();
        loginForm.submit(DEFAULT_USER);
    }

    @Step
    public static void shouldBeLoggedOut() {
        if (!WebPage.getUrl().contains(DOMAIN))
            openUrl(DOMAIN);
        if (userName.isDisplayed())
            logout();
        if (loginForm.isDisplayed())
            userIcon.click();
    }
    @Step
    public static void logout() {
        if (!logout.isDisplayed())
            userIcon.click();
        logout.click();
    }
}
