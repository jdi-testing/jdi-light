package io.github.epam.tests;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.Header.*;
import static io.github.epam.entities.Users.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;

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
