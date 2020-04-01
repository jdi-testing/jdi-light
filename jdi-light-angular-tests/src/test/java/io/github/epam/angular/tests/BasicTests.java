package io.github.epam.angular.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angPage;
import static io.github.com.StaticSite.userName;
import static io.github.com.pages.AngularPage.firstBasicRadioButton;
import static states.States.shouldBeLoggedIn;

public class BasicTests {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angPage.shouldBeOpened();
    }

    @Test
    public void checkUsernameOnAngularPage() {
        userName.is().displayed();
    }
}
