package io.github.epam.vuetify.tests.complex;

import io.github.com.custom.windows.SignUpWindow;
import io.github.com.custom.windows.SlideWindow;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.windowsPage;
import static io.github.com.pages.WindowsPage.*;

public class WindowsTests extends TestsInit {

    @BeforeClass
    public void before() {
        windowsPage.open();
        windowsPage.checkOpened();
    }

    @Test
    public void sameSectionTest() {
        reverseWindows.getActive().header().has().text("Slide 1");
        next.click();
        reverseWindows.getActive().header().has().text("Slide 2");
        next.click();
        reverseWindows.getActive().has().text("Slide 3");
        next.click();

        reverseWindows.getActive(SlideWindow.class).has().text("Slide 1");
        next.click();
        reverseWindows.getActive(SlideWindow.class).has().text("Slide 2");
        next.click();
        reverseWindows.getActive(SlideWindow.class).has().text("Slide 3");
    }

    @Test
    public void customizedArrowsWindowsTest() {
        customizedArrowsWindows.getActive();
    }

    @Test
    public void baseTest() {
        accountCreationWindows.getActive(SignUpWindow.class).email().sendKeys("2");
        System.out.println(accountCreationWindows.getActive(SignUpWindow.class).label().getValue());
        accountCreationWindows.getActive(SignUpWindow.class).email().has().text("john@vuetifyjs.com2");
        next2.click();
        next2.click();
    }


}
