package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.get.DriverData.getOs;
import static com.epam.jdi.light.driver.get.OsTypes.WIN;
import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static com.epam.jdi.light.elements.base.Conditions.hidden;
import static com.epam.jdi.light.elements.base.Conditions.not;
import static com.epam.jdi.light.elements.base.Conditions.visible;
import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static com.jdiai.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.blueButton;
import static io.github.com.pages.HtmlElementsPage.dblClickButton;
import static io.github.com.pages.HtmlElementsPage.disabledButton;
import static io.github.com.pages.HtmlElementsPage.disabledButtonInput;
import static io.github.com.pages.HtmlElementsPage.displayNoneButton;
import static io.github.com.pages.HtmlElementsPage.ghostButton;
import static io.github.com.pages.HtmlElementsPage.hiddenButton;
import static io.github.com.pages.HtmlElementsPage.redButton;
import static io.github.com.pages.HtmlElementsPage.rightClickButton;
import static io.github.com.pages.HtmlElementsPage.suspendButton;
import static io.github.com.pages.HtmlElementsPage.visibilityHiddenButton;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.BaseValidations.durationImmediately;
import static io.github.epam.html.tests.elements.BaseValidations.durationMoreThan;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.fail;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class InvisibleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    String text = "Big Red Button-Input";
    String visibilityHiddenButtonId = "visibility-hidden-button";
    String hiddenButtonId = "hidden-button";
    String displayNoneButtonId = "display-none-button";
    @Test
    public void displayNoneCssPropertyTest() {
        assertFalse(displayNoneButton.isDisplayed());
        assertEquals(displayNoneButton.getAttribute("id"), displayNoneButtonId);
    }

    @Test
    public void visibilityHiddenCssPropertyTest() {
        assertFalse(visibilityHiddenButton.isDisplayed());
        assertEquals(visibilityHiddenButton.getAttribute("id"), visibilityHiddenButtonId);
    }

    @Test
    public void hiddenHtmlAttributeTest() {
        assertFalse(hiddenButton.isDisplayed());
        assertEquals(hiddenButton.getAttribute("id"), hiddenButtonId);
    }
}
