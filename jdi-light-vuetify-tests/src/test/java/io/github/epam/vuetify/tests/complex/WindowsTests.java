package io.github.epam.vuetify.tests.complex;

import io.github.com.custom.windows.MySection;
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
        reverseWindows.getActive().header.has().text("Slide 1");
        next.click();
        reverseWindows.getActive().header.has().text("Slide 2");
        next.click();
        reverseWindows.getActive().header.has().text("Slide 3");
    }

    @Test
    public void baseTest() {
        System.out.println(accountCreationWindows.getActive(MySection.class).getClass().getName());
        accountCreationWindows.getActive(MySection.class);
    }

}
