package io.github.epam.material.tests.utils;

import static io.github.com.StaticSite.portalPage;
import static io.github.com.pages.utils.PortalPage.portal;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PortalTests extends TestsInit {
    private static final String FIRST_FIELD_TEXT = "It looks like I will render here.";

    @BeforeMethod
    public void openSectionToTest() {
        portalPage.open();
    }

    @Test
    public void portalTest() {
        portal.button().has().text("Mount children");
        portal.field(1).has().text(FIRST_FIELD_TEXT);
        portal.field(2).has().text("");

        portal.button().click();
        portal.button().has().text("Unmount children");
        portal.field(1).has().text(FIRST_FIELD_TEXT);
        portal.field(2).has().text("But I actually render here!");

        portal.button().click(0, 1);
        portal.button().has().text("Mount children");
        portal.field(1).has().text(FIRST_FIELD_TEXT);
        portal.field(2).has().text("");
    }
}
