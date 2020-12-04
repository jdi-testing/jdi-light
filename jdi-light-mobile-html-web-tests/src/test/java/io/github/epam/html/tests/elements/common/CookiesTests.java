package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.common.Cookies;
import io.github.epam.TestsInit;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
