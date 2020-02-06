package io.github.epam.tests.epam;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.mobile.elements.common.WindowsManager.*;
import static io.github.epam.EpamGithubSite.*;
import static io.github.epam.tests.epam.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class WindowsAndFramesTests extends TestsInit {

    @BeforeMethod
    public void before() {
        getWindows();
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }
    @Test
    public void windowsTest() {
        homePage.shouldBeOpened();
        homePage.githubLink.click();
        System.out.println("New window is opened: " + newWindowIsOpened());
        System.out.println("Windows count: " + windowsCount());
        originalWindow(); // open original (first) window
        switchToWindow(2); // open second window
        assertEquals(githubPage.repoDescription.getText(),
        "Try JDI Light https://github.com/jdi-testing/jdi-light");
        setWindowName("Github");
        switchToWindow(1); // open first (original) window

        homePage.jdiText.is().text(
            containsString("QUIS NOSTRUD EXERCITATION"));
        switchToWindow("Github");
        assertEquals(githubPage.repoDescription.getText(),
                "Try JDI Light https://github.com/jdi-testing/jdi-light");
        closeWindow();
    }

    @Test
    public void frameTest() {
        iframe.userIcon.click();
    }
}
