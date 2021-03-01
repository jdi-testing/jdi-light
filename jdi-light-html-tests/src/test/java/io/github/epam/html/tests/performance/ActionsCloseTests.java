package io.github.epam.html.tests.performance;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.yourName;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 01.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ActionsCloseTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        yourName.setText(text);
    }
    String text = "TextField";

    @Test
    public void getValueTest() {
        yourName.core().actionsWithElement(a -> a.
            click().
            keyDown(Keys.CONTROL).
            sendKeys("a").
            keyUp(Keys.CONTROL));
        yourName.sendKeys("Test");
        assertEquals(yourName.getValue(), "Test");
    }

    @Test
    public void sendKeysTest() {
        yourName.core().actionsWithElement(a -> a.
            click().
            keyDown(Keys.CONTROL).
            sendKeys("a").
            keyUp(Keys.CONTROL));
        yourName.sendKeys("Test");
        assertEquals(yourName.getValue(), "Test");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.close();
    }

}
