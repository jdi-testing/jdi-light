package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.common.Cookies;
import io.github.com.pages.HomePage;
import io.github.epam.TestsInit;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CookiesTests implements TestsInit {
    @Test
    public void cookiesTest() {
        Set<Cookie> savedCookies = null;
        try {
            HomePage.openSite();
            savedCookies = Cookies.getCookies();

            Cookies.clearAllCookies();
            Set<Cookie> cookies = Cookies.getCookies();
            assertThat(cookies, empty());

            String pageDomain = "jdi-testing.github.io";
            try {
                pageDomain = new URI(HomePage.getUrl()).getHost();
            }
            catch (URISyntaxException e) {
                logger.error("Cann't parse current url", e);
            }

            Cookie cookieIn = new Cookie.Builder("name", "Roman")
                    .domain(pageDomain)
                    .build();
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
