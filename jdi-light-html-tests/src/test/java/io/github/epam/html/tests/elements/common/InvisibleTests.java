package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.SearchTypes.Single;
import static com.epam.jdi.light.common.SearchTypes.Smart;
import static com.jdiai.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.displayNoneButton;
import static io.github.com.pages.HtmlElementsPage.displayedButton;
import static io.github.com.pages.HtmlElementsPage.hiddenButton;
import static io.github.com.pages.HtmlElementsPage.hiddenParentButton;
import static io.github.com.pages.HtmlElementsPage.visibleParentButton;
import static io.github.com.pages.HtmlElementsPage.visibilityCollapseButton;
import static io.github.com.pages.HtmlElementsPage.visibilityHiddenButton;
import static io.github.com.pages.HtmlElementsPage.visibilityNonHiddenButton;
import static io.github.com.pages.HtmlElementsPage.visibleButton;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
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

    String displayNoneButtonId = "display-none-button";
    String visibilityHiddenButtonId = "visibility-hidden-button";
    String visibilityCollapseButtonId = "visibility-collapse";
    String hiddenButtonValue = "html-hidden";
    String hiddenParentButtonValue = "hidden-parent";
    String EXCEPTION_MESSAGE = "Expected one element but found 0";

    @Test
    public void displayNoneCssPropertyTest() {
        assertFalse(displayNoneButton.isDisplayed());
        assertEquals(displayNoneButton.getAttribute("id"), displayNoneButtonId);
    }

    @Test
    public void displayNoneCssPropertyNegativeTest() {
        try {
            displayedButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityHiddenCssPropertyTest() {
        assertFalse(visibilityHiddenButton.isDisplayed());
        assertEquals(visibilityHiddenButton.getAttribute("id"), visibilityHiddenButtonId);
    }

    @Test
    public void visibilityHiddenCssPropertyNegativeTest() {
        try {
            visibilityNonHiddenButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityCollapseCssPropertyTest() {
        assertFalse(visibilityCollapseButton.isDisplayed());
        assertEquals(visibilityCollapseButton.getAttribute("id"), visibilityCollapseButtonId);
    }

    @Test
    public void visibilityCollapseCssPropertyNegativeTest() {
        try {
            visibilityNonHiddenButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeTest() {
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("id"), hiddenButtonValue);
    }

    @Test
    public void hiddenHtmlAttributeNegativeTest() {
        try {
            visibleButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenParentHtmlAttributeTest() {
        assertFalse(hiddenParentButton.isDisplayed());
        assertEquals(hiddenParentButton.getAttribute("id"), hiddenParentButtonValue);
    }

    @Test
    public void hiddenParentHtmlAttributeNegativeTest() {
        try {
            visibleParentButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSingleStrategyTest() {
        hiddenButton.searchType = Single;
        try {
            visibleButton.getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSmartStrategyTest() {
        hiddenButton.searchType = Smart;
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("id"), hiddenButtonValue);
    }
}
