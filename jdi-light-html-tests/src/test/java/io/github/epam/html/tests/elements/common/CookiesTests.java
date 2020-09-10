package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.common.Cookies;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static com.epam.jdi.light.elements.common.Keyboard.press;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CookiesTests implements TestsInit {
    @Test
    public void cookiesTest() {
        Set<Cookie> savedCookies = null;
        try {
            savedCookies = Cookies.getCookies();

            Cookies.clearAllCookies();
            Set<Cookie> cookies = Cookies.getCookies();
            assertThat(cookies, empty());

            Cookie cookieIn = new Cookie("name", "Roman");
            Cookies.addCookie(cookieIn);
            Cookie cookieOut = Cookies.getCookie("name");
            assertThat(cookieOut, equalTo(cookieIn));
            cookies = Cookies.getCookies();
            assertThat(cookies, hasSize(1));
            assertThat(cookies, hasItem(cookieIn));

            Cookies.clearAllCookies();
            cookies = Cookies.getCookies();
            assertThat(cookies, empty());
        } finally {
            Cookies.setCookies(savedCookies);
        }
    }

}
