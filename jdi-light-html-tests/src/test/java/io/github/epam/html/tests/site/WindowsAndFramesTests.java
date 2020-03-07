package io.github.epam.html.tests.site;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.GithubPage.*;
import static io.github.com.pages.HomePage.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class WindowsAndFramesTests implements TestsInit {

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
        "Try JDI Light https://github.com/jdi-testing/jdi-light");
        setWindowName("Github 2");
        switchToWindow(1); // open first (original) window

        jdiText.is().text(
            containsString("QUIS NOSTRUD EXERCITATION"));
        switchToWindow("Github 2");
        assertEquals(repoDescription.getText(),
                "Try JDI Light https://github.com/jdi-testing/jdi-light");
        closeWindow();
    }

    @Test
    public void frameTest() {
        iframe.epamLogo.click();
    }
}
