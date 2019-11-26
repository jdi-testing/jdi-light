package io.github.epam.tests.allurereport;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static org.hamcrest.Matchers.containsString;

public class AllureScreenshotTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        homePage.shouldBeOpened();
    }

    @Test
    public void passedTest() {
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }

    @Test
    public void failedTest() {
        jdiText.is().text(containsString("QUIS NOSTRUD EXERCITATION"));
        jdiText.is().text(containsString("FAIL STRING"));
    }
}
