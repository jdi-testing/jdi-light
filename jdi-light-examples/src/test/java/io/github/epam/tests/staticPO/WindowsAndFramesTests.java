package io.github.epam.tests.staticPO;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.*;
import static io.github.epam.tests.staticPO.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static staticPageObject.StaticSite.homePage;
import static staticPageObject.StaticSite.iframe;
import static staticPageObject.pages.GithubPage.repoDescription;
import static staticPageObject.pages.HomePage.githubLink;
import static staticPageObject.pages.HomePage.jdiText;

public class WindowsAndFramesTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
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
