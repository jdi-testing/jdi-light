package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.portalPage;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.hasToString;

public class PortalTests extends TestsInit {
    @Test
    public void portalTest(){
        openSection("Portal");

        portalPage.button.has().text("Mount children");
        portalPage.field1.has().text(hasToString("It looks like I will render here."));
        portalPage.field2.has().text(emptyString());

        portalPage.button.click();
        portalPage.button.has().text("Unmount children");
        portalPage.field1.has().text(hasToString("It looks like I will render here."));
        portalPage.field2.has().text(hasToString("But I actually render here!"));

        portalPage.button.click();
        portalPage.button.has().text("Mount children");
        portalPage.field1.has().text(hasToString("It looks like I will render here."));
        portalPage.field2.has().text(emptyString());
    }
}
