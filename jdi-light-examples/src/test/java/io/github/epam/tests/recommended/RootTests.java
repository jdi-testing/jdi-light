package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.homePage;
import static io.github.com.pages.Header.*;
import static io.github.epam.entities.Users.DEFAULT_USER;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedOut;

public class RootTests extends StaticTestsInit {

    //@TestSkipp
    public void rootTest() {
        shouldBeLoggedOut();
        loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
    //@TestSkipp
    public void initDeepTest() {
        Assert.assertNotNull(homePage.testField);
    }
}
