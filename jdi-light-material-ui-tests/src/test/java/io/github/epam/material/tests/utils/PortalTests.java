package io.github.epam.material.tests.utils;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.utils.PortalPage.*;

public class PortalTests extends TestsInit {

    @BeforeMethod
    public void openSectionToTest() {
        openSection("Portal");
        insureInitialState();
    }

    @Test
    public void checkStateAfterBtnClick() {
        button.click();
        button.has().text("Unmount children");
        field1.has().text("It looks like I will render here.");
        field2.has().text("But I actually render here!");
    }

    @Test
    public void checkStateAfterDoubleClick() {
        button.doubleClick();
        insureInitialState();
    }

    public void insureInitialState() {
        button.has().text("Mount children");
        field1.has().text("It looks like I will render here.");
        field2.has().text("");
    }
}
