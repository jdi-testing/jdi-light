package io.github.epam.tests.recommended;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.GithubPage.*;
import static io.github.com.pages.HomePage.*;
import static io.github.epam.tests.recommended.steps.Preconditions.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class WindowsAndFramesTests extends StaticTestsInit {

    @BeforeMethod
    public void before() {
        getWindows();
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
    }

    @Test
    public void windowsTest() {
        homePage.shouldBeOpened();
        githubLink.click();
        System.out.println("New window is opened: " + newWindowIsOpened());
        System.out.println("Windows count: " + windowsCount());
        originalWindow(); // open original (first) window
        switchToWindow(2); // open second window
        assertEquals(repoDescription.getText(),
        "Try JDI Light https://github.com/jdi-testing/jdi-light");
        setWindowName("Github");
        switchToWindow(1); // open first (original) window

        jdiText.is().text(
            containsString("QUIS NOSTRUD EXERCITATION"));
        switchToWindow("Github");
        assertEquals(repoDescription.getText(),
                "Try JDI Light https://github.com/jdi-testing/jdi-light");
        closeWindow();
    }

    @Test
    public void frameTest() {
        iframe.userIcon.click();
    }
    @Test
    public void wolverinFrameTest() {
        wolverinFrame.has().attr("src", containsString("wolverin"));
    }
    @Test
    public void spidermanTest() {
        WebPage.reload();
        spidermanElement.has().attr("src", containsString("spider-man"));
    }
    @Test
    public void spidermanFrameTest() {
        WebPage.reload();
        frameSpiderman.spiderMan.has().attr("src", containsString("spider-man"));
    }
}
