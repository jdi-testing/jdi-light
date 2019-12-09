package io.github.epam.tests.recommended;

import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.common.WindowsManager.newWindowIsOpened;
import static com.epam.jdi.light.elements.common.WindowsManager.originalWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.setWindowName;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.windowsCount;
import static com.epam.jdi.light.settings.WebSettings.ANY_ELEMENT;
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
        iframe.userName.setup(jdiB -> jdiB.setSearchRule(ANY_ELEMENT));
        iframe.userName.assertThat().text("Piter Chailovskii");
    }
}
