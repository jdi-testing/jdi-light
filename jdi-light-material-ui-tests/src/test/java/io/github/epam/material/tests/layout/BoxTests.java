package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.hasToString;

public class BoxTests extends TestsInit {

    @Test
    public void containedBoxTest() {
        defaultBoxPage.open();

        defaultBoxPage.containedBox.is().enabled();
        defaultBoxPage.containedBox.click();
        defaultBoxPage.containedBox.is().text(hasToString("FIRST BUTTON"));
        defaultBoxPage.lastClickContent.is().text(hasToString("You clicked First button"));
    }

    @Test
    public void outlinedBoxTest() {
        defaultBoxPage.open();

        defaultBoxPage.outlinedBox.is().enabled();
        defaultBoxPage.outlinedBox.click();
        defaultBoxPage.outlinedBox.is().text(hasToString("SECOND BUTTON"));
        defaultBoxPage.lastClickContent.is().text(hasToString("You clicked Second button"));
    }

    @Test
    public void disabledBoxTest() {
        defaultBoxPage.open();

        defaultBoxPage.disabledBox.is().text(hasToString("THIRD BUTTON"));
        defaultBoxPage.disabledBox.is().disabled();
    }
}
