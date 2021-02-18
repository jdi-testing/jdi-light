package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.defaultPortalPage;
import static io.github.com.StaticSite.portalFrame;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.hasToString;

public class PortalTests extends TestsInit {
    @Test
    public void portalTest(){
        defaultPortalPage.open();

        portalFrame.button.is().text(hasToString("Mount children"));
        portalFrame.field1.is().text(hasToString("It looks like I will render here."));
        portalFrame.field2.is().text(emptyString());

        portalFrame.button.click();
        portalFrame.button.is().text(hasToString("Unmount children"));
        portalFrame.field1.is().text(hasToString("It looks like I will render here."));
        portalFrame.field2.is().text(hasToString("But I actually render here!"));

        portalFrame.button.click();
        portalFrame.button.is().text(hasToString("Mount children"));
        portalFrame.field1.is().text(hasToString("It looks like I will render here."));
        portalFrame.field2.is().text(emptyString());
    }
}
