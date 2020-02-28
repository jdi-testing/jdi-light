package io.github.epam.parallel;

import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.EpamGithubSite.homePage;
import static io.github.epam.EpamGithubSite.header;
import static io.github.epam.entities.Users.DEFAULT_USER;

public class LoginTests extends TestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        Preconditions.shouldBeLoggedOut();
    }

    @Test
    public void rootTest() {
        header.userIcon.click();
        header.loginForm.submit(DEFAULT_USER, "enter");
        homePage.checkOpened();
    }
}
