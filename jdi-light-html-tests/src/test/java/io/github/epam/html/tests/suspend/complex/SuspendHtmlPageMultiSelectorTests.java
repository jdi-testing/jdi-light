package io.github.epam.html.tests.suspend.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.ages;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SuspendHtmlPageMultiSelectorTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        ages.check(text);
    }
    String text = "Steam";

    @Test
    public void isValidationTest() {
        ages.is().selected("Steam");
        ages.is().selected(Steam);
        ages.is().values(hasItem("Wood"));
        ages.is().disabled(hasItem("Disabled"));
        ages.is().enabled(not(hasItem("Disabled")));
        ages.is().enabled(hasItems("Electro", "Metalic"));
    }

    @Test
    public void assertValidationTest() {
        ages.assertThat().values(containsInAnyOrder("Disabled", "Electro", "Metalic", "Wood", "Steam"));
        ages.assertThat().selected(Steam);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(ages);
    }
}
