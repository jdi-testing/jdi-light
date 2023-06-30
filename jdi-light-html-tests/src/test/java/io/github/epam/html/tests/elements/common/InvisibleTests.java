package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.SearchTypes.Single;
import static com.epam.jdi.light.common.SearchTypes.Smart;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.displayNoneButton;
import static io.github.com.pages.HtmlElementsPage.hiddenButton;
import static io.github.com.pages.HtmlElementsPage.hiddenParentButton;
import static io.github.com.pages.HtmlElementsPage.visibilityHiddenButton;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

/**
 * Created by Aleksandr Vorobev
 * Email: spbqaru@gmail.com; Skype: spbqa
 */

public class InvisibleTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    String visibilityHiddenButtonId = "visibility-hidden-button";
    String hiddenButtonValue = "hidden-button";
    String displayNoneButtonId = "display-none-button";
    String hiddenParentButtonValue = "hidden-parent";
    String zeroWidthButtonValue = "zero-width";
    String zeroHeightButtonValue = "zero-height";
    String zeroOpacityButtonValue = "zero-opacity";
    String overlappedButtonValue = "bottom-layer";

    @Test
    public void displayNoneCssPropertyTest() {
        assertFalse(displayNoneButton.isDisplayed());
        assertEquals(displayNoneButton.getAttribute("value"), displayNoneButtonId);
    }

    @Test
    public void visibilityHiddenCssPropertyTest() {
        assertFalse(visibilityHiddenButton.isDisplayed());
        assertEquals(visibilityHiddenButton.getAttribute("value"), visibilityHiddenButtonId);
    }

    @Test
    public void hiddenHtmlAttributeTest() {
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("value"), hiddenButtonValue);
    }

    @Test
    public void hiddenHtmlAttributeSingleStrategyTest() {
        hiddenButton.searchType = Single;
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("value"), hiddenButtonValue);
    }

    @Test
    public void hiddenHtmlAttributeSmartStrategyTest() {
        hiddenButton.searchType = Smart;
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("value"), hiddenButtonValue);
    }


    @Test
    public void hiddenParentHtmlAttributeTest() {
        assertFalse(hiddenParentButton.isDisplayed());
        assertEquals(hiddenParentButton.getAttribute("value"), hiddenParentButtonValue);
    }
}
