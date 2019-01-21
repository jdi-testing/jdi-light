package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.height;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class NumberSelectorTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        height.setNumber(number);
    }
    String number = "2.1";

    @Test
    public void getLabelTextTest() {
        assertEquals(height.labelText(), "Height (metres):");
    }

    @Test
    public void getNumberTest() {
        assertEquals(height.value(), number);
    }

    @Test
    public void minTest() {
        assertEquals(height.min(), "0.3");
    }
    @Test
    public void maxTest() {
        assertEquals(height.max(), "2.5");
    }
    @Test
    public void stepTest() {
        assertEquals(height.step(), "0.2");
    }
    @Test
    public void placeholderTest() {
        assertEquals(height.placeholder(), "20 cm increments. Range [0.3,2.5]");
    }
    @Test
    public void setNumberTest() {
        height.setNumber("1.4");
        assertEquals(height.value(), "1.4");
    }

    @Test
    public void isValidationTest() {
        height.assertThat().minValue(is(0.3));
        height.assertThat().maxValue(is(2.5));
        height.assertThat().stepValue(is(0.2));
        height.is().placeholder(containsString("20 cm increments"));
        height.is().number(greaterThanOrEqualTo(0.3));
        height.is().number(lessThanOrEqualTo(2.5));
        height.assertThat().number(is(2.1));
        height.is().enabled();
    }

    @Test
    public void labelTest() {
        assertEquals(height.label().getText(), "Height (metres):");
        height.label().is().text(containsString("Height"));
        height.label().is().text(equalToIgnoringCase("height (metres):"));
    }

    @Test
    public void assertValidationTest() {
        height.assertThat().number(greaterThan(0.0));
        height.assertThat().number(lessThan(3.0));
        height.assertThat().number(is(2.1));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(height);
    }
}
