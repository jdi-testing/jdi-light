package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.jdiai.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.ages;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Steam;
import static io.github.epam.html.tests.elements.complex.enums.Ages.Wood;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class MultiSelectorTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        ages.check(defaultText);
    }
    String defaultText = "Steam";

    @Test
    public void getValueTest() {
        assertEquals(ages.getValue(), defaultText);
    }

    @Test
    public void selectTest() {
        ages.check("Electro", "Metalic");
        assertEquals(ages.checked(), asList("Electro", "Metalic"));
    }

    @Test
    public void setNullValueTest() {
        String optionName = null;
        ages.check("Electro", optionName);
        ages.has().text("Electro");
    }

    @Test
    public void selectEnumTest() {
        ages.check(Wood, Steam);
        assertEquals(ages.checked(), asList("Steam", "Wood"));
    }
    @Test
    public void selectNumTest() {
        ages.check(ELEMENT.startIndex, ELEMENT.startIndex + 4);
        assertEquals(ages.checked(), asList("Electro", "Wood"));
    }
    @Test
    public void selectedTest() {
        assertEquals(ages.checked(), Collections.singletonList(defaultText));
    }

    @Test
    public void labelTest() {
        assertEquals(ages.label().getText(), "Age status:");
        ages.label().is().text(containsString("Age"));
    }

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
