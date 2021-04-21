package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.materialIconPage;
import static io.github.com.pages.displaydata.MaterialIconPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * https://material-ui.com/components/material-icons
 */

public class MaterialIconTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Material Icons");
        materialIconPage.isOpened();
    }

    private void lastClickTextIs(String text) {
        lastClick.is().text(String.format("Last click:%s", text));
    }

    private void lastHoverTextIs(String text) {
        lastHover.is().text(String.format("Last hover:%s", text));
    }

    @Test
    public void sizeAndColorTest() {
        defaultAlarm.isDisplayed();
        largeAlarm.isDisplayed();
        secondaryAlarm.isDisplayed();
        jdiAssert(largeAlarm.hasClass("MuiSvgIcon-fontSizeLarge"), Matchers.is(true));
        jdiAssert(secondaryAlarm.hasClass("MuiSvgIcon-colorSecondary"), Matchers.is(true));
    }

    @Test
    public void defaultMaterialIconTest() {
        lastClickTextIs("");
        lastHoverTextIs("");

        defaultAlarm.hover();
        lastClickTextIs("");
        lastHoverTextIs(" default");

        defaultAlarm.click();
        lastClickTextIs(" default");
        lastHoverTextIs(" default");

        largeAlarm.hover();
        lastClickTextIs(" default");
        lastHoverTextIs(" large");

        largeAlarm.click();
        lastClickTextIs(" large");
        lastHoverTextIs(" large");

        secondaryAlarm.hover();
        lastClickTextIs(" large");
        lastHoverTextIs(" secondary");

        secondaryAlarm.click();
        lastClickTextIs(" secondary");
        lastHoverTextIs(" secondary");
    }
}
