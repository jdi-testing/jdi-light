package io.github.epam.html.tests.suspend.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.multiDropdown;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SuspendHtmlPageMultiDropdownTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        if (!isFireFox())
            multiDropdown.check(text);
    }
    String text = "Steam";

    @Test
    public void isValidationTest() {
        multiDropdown.is().selected("Steam");
        multiDropdown.is().selected(Steam);
        multiDropdown.is().values(hasItem("Wood"));
        multiDropdown.is().disabled(hasItem("Disabled"));
        multiDropdown.is().enabled(not(hasItem("Disabled")));
        multiDropdown.is().enabled(hasItems("Electro", "Metalic"));
    }

    @Test
    public void assertValidationTest() {
        multiDropdown.assertThat().values(containsInAnyOrder("Disabled", "Electro", "Metalic", "Wood", "Steam"));
        multiDropdown.assertThat().selected(Steam);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multiDropdown);
    }
}
