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
        displayNoneButton.core().searchType = Single;
        displayNoneButton.is()
                .hidden();
        displayNoneButton.has()
                .attr("id", displayNoneButtonId);
    }

    @Test
    public void displayNoneCssPropertyNegativeTest() {
        displayedButton.core().searchType = Single;
        try {
            displayedButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityHiddenCssPropertyTest() {
        visibilityHiddenButton.core().searchType = Single;
        visibilityHiddenButton.is()
                .hidden();
        visibilityHiddenButton.has()
                .attr("id", visibilityHiddenButtonId);
    }

    @Test
    public void visibilityHiddenCssPropertyNegativeTest() {
        visibilityNonHiddenButton.core().searchType = Single;
        try {
            visibilityNonHiddenButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void visibilityCollapseCssPropertyTest() {
        visibilityCollapseButton.core().searchType = Single;
        visibilityCollapseButton.is()
                .hidden();
        visibilityCollapseButton.has()
                .attr("id", visibilityCollapseButtonId);
    }

    @Test
    public void visibilityCollapseCssPropertyNegativeTest() {
        visibilityNonHiddenButton.core().searchType = Single;
        try {
            visibilityNonHiddenButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeTest() {
        hiddenButton.core().searchType = Single;
        hiddenButton.is()
                .hidden();
        hiddenButton.has()
                .attr("id", hiddenButtonValue);
    }

    @Test
    public void hiddenHtmlAttributeNegativeTest() {
        visibleButton.core().searchType = Single;
        try {
            visibleButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenParentHtmlAttributeTest() {
        hiddenParentButton.core().searchType = Single;
        hiddenParentButton.is()
                .hidden();
        hiddenParentButton.has()
                .attr("id", hiddenParentButtonValue);
    }

    @Test
    public void hiddenParentHtmlAttributeNegativeTest() {
        visibleParentButton.core().searchType = Single;
        try {
            visibleParentButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSingleStrategyTest() {
        hiddenButton.core().searchType = Single;
        try {
            visibleButton.hasAttribute("id");
        } catch (RuntimeException ex) {
            assertThat(safeException(ex), containsString(EXCEPTION_MESSAGE));
        }
    }

    @Test
    public void hiddenHtmlAttributeSmartStrategyTest() {
        hiddenButton.core().searchType = Smart;
        hiddenButton.is()
                .hidden();
        hiddenButton.has()
                .attr("id", hiddenButtonValue);
    }
}
