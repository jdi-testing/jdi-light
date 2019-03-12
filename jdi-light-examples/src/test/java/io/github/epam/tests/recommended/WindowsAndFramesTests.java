package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.*;
import static io.github.com.StaticSite.homePage;
import static io.github.com.StaticSite.iframe;
import static io.github.com.pages.GithubPage.repoDescription;
import static io.github.com.pages.HomePage.githubLink;
import static io.github.com.pages.HomePage.jdiText;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class WindowsAndFramesTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        getWindows();
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }

    //@TestSkipp
    public void windowsTest() {
        homePage.shouldBeOpened();
        githubLink.click();
        System.out.println("New window is opened: " + newWindowIsOpened());
        System.out.println("Windows count: " + windowsCount());
        originalWindow(); // open original (first) window
        switchToWindow(2); // open second window
        assertEquals(repoDescription.getText(),
        "JDI is the test Framework for UI test automation");
        setWindowName("Github");
        switchToWindow(1); // open first (original) window

        jdiText.is().text(
            containsString("QUIS NOSTRUD EXERCITATION"));
        switchToWindow("Github");
        assertEquals(repoDescription.getText(),
                "JDI is the test Framework for UI test automation");
        closeWindow();
    }

    //@TestSkipp
    public void frameTest() {
        iframe.userIcon.click();
    }
}
