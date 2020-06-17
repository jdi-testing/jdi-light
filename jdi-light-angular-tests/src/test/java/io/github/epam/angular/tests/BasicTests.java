package io.github.epam.angular.tests;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.StaticSite.userName;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void checkUsernameOnAngularPage() {
        userName.is().displayed();
    }
}
