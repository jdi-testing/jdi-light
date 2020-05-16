package io.github.epam.states;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.settings.JDISettings;
import io.qameta.allure.Step;

import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static io.github.com.StaticSite.loginForm;
import static io.github.com.StaticSite.logout;
import static io.github.com.StaticSite.userIcon;
import static io.github.com.StaticSite.userName;
import static io.github.epam.test.data.UsersUtils.DEFAULT_USER;

/**
 * Created by Roman_Iovlev on 3/1/2018.
 */

@SuppressWarnings("PMD.ClassNamingConventions")
public class States {
    private static final JDISettings jdiSettings = getJDISettings();

    @Step
    public static void shouldBeLoggedIn() {
        String url = WebPage.getUrl();
        if (!url.contains(jdiSettings.DRIVER.domain)
                || url.contains("issue"))
            openUrl(jdiSettings.DRIVER.domain);
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
        if (!WebPage.getUrl().contains(jdiSettings.DRIVER.domain))
            openUrl(jdiSettings.DRIVER.domain);
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
