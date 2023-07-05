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
    String hiddenButtonValue = "hidden-button";
    String hiddenParentButtonValue = "hidden-parent";
    String EXCEPTION_MESSAGE = "Expected one element but found 0";

    @Test
    public void displayNoneCssPropertyTest() {
        displayNoneButton.is()
                .hidden();
        assertEquals(displayNoneButton.core()
                             .get()
                             .getAttribute("id"), displayNoneButtonId);
    }

    @Test
    public void displayNoneCssPropertyNegativeTest() {
        displayedButton.core().searchType = Single;
        try {
            displayedButton.core()
                    .get()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityHiddenCssPropertyTest() {
        visibilityHiddenButton.is()
                .hidden();
        assertEquals(visibilityHiddenButton.core()
                             .get()
                             .getAttribute("id"), visibilityHiddenButtonId);
    }

    @Test
    public void visibilityHiddenCssPropertyNegativeTest() {
        visibilityNonHiddenButton.core().searchType = Single;
        try {
            visibilityNonHiddenButton.core()
                    .get()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityCollapseCssPropertyTest() {
        visibilityCollapseButton.is()
                .hidden();
        assertEquals(visibilityCollapseButton.core()
                             .get()
                             .getAttribute("id"), visibilityCollapseButtonId);
    }

    @Test
    public void visibilityCollapseCssPropertyNegativeTest() {
        visibilityNonHiddenButton.core().searchType = Single;
        try {
            visibilityNonHiddenButton.core()
                    .get()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeTest() {
        hiddenButton.is()
                .hidden();
        assertEquals(hiddenButton.core()
                             .get()
                             .getAttribute("id"), hiddenButtonValue);
    }

    @Test
    public void hiddenHtmlAttributeNegativeTest() {
        visibleButton.core().searchType = Single;
        try {
            visibleButton.core()
                    .get()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenParentHtmlAttributeTest() {
        hiddenParentButton.is()
                .hidden();
        assertEquals(hiddenParentButton.core()
                             .get()
                             .getAttribute("id"), hiddenParentButtonValue);
    }

    @Test
    public void hiddenParentHtmlAttributeNegativeTest() {
        visibleParentButton.core().searchType = Single;
        try {
            visibleParentButton.core()
                    .get()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSingleStrategyTest() {
        hiddenButton.core().searchType = Single;
        try {
            visibleButton.core()
                    .getAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSmartStrategyTest() {
        hiddenButton.core().searchType = Smart;
        hiddenButton.is()
                .hidden();
        assertEquals(hiddenButton.core()
                             .get()
                             .getAttribute("id"), hiddenButtonValue);
    }
}
