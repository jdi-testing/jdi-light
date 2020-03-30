package io.github.epam.mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.epam.StaticSite.homePage;
import static io.github.epam.StaticSite.searchPage;
import static io.github.epam.sections.Header.loginForm;
import static io.github.epam.sections.Header.userIcon;
import static io.github.epam.steps.Preconditions.shouldBeLoggedOut;
import static io.github.epam.entities.Users.DEFAULT_USER;


public class RootTests extends StaticTestsInit {
    @Test
    public void rootTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
    @Test
    public void initDeepTest() {
        Assert.assertNotNull(homePage.testField);
        Assert.assertNotNull(searchPage.testField);
    }
}
