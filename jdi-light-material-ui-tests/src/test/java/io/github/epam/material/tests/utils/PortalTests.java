package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.portalPage;
import static io.github.com.pages.utils.PortalPage.*;

/**
 * To see an example of Portal web element please visit
 * https://material-ui.com/components/portal/.
 */


public class PortalTests extends TestsInit {

    @BeforeMethod
    public void openSectionToTest() {
        portalPage.open();
    }

    @Test
    public void portalTest() {
        button.has().text("Mount children");
        field1.has().text("It looks like I will render here.");
        field2.has().text("");

        button.click();
        button.has().text("Unmount children");
        field1.has().text("It looks like I will render here.");
        field2.has().text("But I actually render here!");

        button.click();
        button.has().text("Mount children");
        field1.has().text("It looks like I will render here.");
        field2.has().text("");
    }
}
