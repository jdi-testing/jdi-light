package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.*;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.iframe;
import static io.github.com.pages.GithubPage.repoDescription;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class WindowsAndFramesTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }
    @Test
    public void windowsTest() {
        githubLink.click();
        System.out.println("New window is opened: " + newWindowIsOpened());
        System.out.println("Windows count: " + windowsCount());
        originalWindow(); // open original (first) window
        switchToWindow(2); // open second window
        assertEquals(repoDescription.getText(),
        "JDI is the test Framework for UI test automation");
        setWindowName("Github 2");
        switchToWindow(1); // open first (original) window

        jdiText.is().text(
            containsString("QUIS NOSTRUD EXERCITATION"));
        switchToWindow("Github 2");
        assertEquals(repoDescription.getText(),
                "JDI is the test Framework for UI test automation");
        closeWindow();
    }

    @Test
    public void frameTest() {
        iframe.userIcon.click();
    }
}
