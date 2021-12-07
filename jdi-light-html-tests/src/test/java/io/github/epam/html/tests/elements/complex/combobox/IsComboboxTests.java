package io.github.epam.html.tests.elements.complex.combobox;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.iceCreamIs;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Strawberry;
import static io.github.epam.html.tests.elements.complex.enums.IceCreamFlavors.Vanilla;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class IsComboboxTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        iceCreamIs.select(defaultText);
    }
    String defaultText = "Coconut";

    @Test
    public void getValueTest() {
        assertEquals(iceCreamIs.getValue(), defaultText);
    }

    @Test
    public void getTextTest() {
        assertEquals(iceCreamIs.getText(), defaultText);
    }

    @Test
    public void inputTest() {
        iceCreamIs.input("New text");
        assertEquals(iceCreamIs.getText(), "New text");
    }

    @Test
    public void passingNull_ToInput_ThrowsException() {
        String optionName = null;
        iceCreamIs.input(optionName);
        iceCreamIs.has().text(defaultText);
    }

    @Test
    public void clearTest() {
        iceCreamIs.clear();
        assertEquals(iceCreamIs.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(iceCreamIs.placeholder(), "Ice cream");
    }

    @Test
    public void focusTest() {
        iceCreamIs.focus();
    }

    @Test
    public void sendKeysTest() {
        iceCreamIs.sendKeys("Test");
        assertEquals(iceCreamIs.getValue(), defaultText +"Test");
    }

    @Test
    public void passingNull_ToSendKeys_ThrowsException() {
        String optionName = null;
        iceCreamIs.sendKeys(optionName);
        iceCreamIs.has().text(defaultText);
    }

    @Test
    public void selectTest() {
        iceCreamIs.select("Chocolate");
        assertEquals(iceCreamIs.getValue(), "Chocolate");
    }

    @Test
    public void passingNull_ToSelect_ThrowsException() {
        String optionName = null;
        iceCreamIs.select(optionName);
        iceCreamIs.has().text(defaultText);
    }

    @Test
    public void selectEnumTest() {
        iceCreamIs.select(Strawberry);
        assertEquals(iceCreamIs.getValue(), "Strawberry");
    }
    @Test
    public void selectNumTest() {
        iceCreamIs.clear();
        iceCreamIs.select(ELEMENT.startIndex + 4);
        assertEquals(iceCreamIs.getValue(), "Vanilla");
    }
    @Test
    public void selectedTest() {
        assertEquals(iceCreamIs.selected(), defaultText);
    }

    @Test
    public void labelTest() {
        assertEquals(iceCreamIs.label().getText(), "Choose your lovely icecream");
        iceCreamIs.label().is().text(containsString("lovely icecream"));
    }

    @Test
    public void isValidationTest() {
        iceCreamIs.is().enabled();
        iceCreamIs.is().text(is(defaultText));
        iceCreamIs.is().text(defaultText);
        iceCreamIs.is().selected(defaultText);
        iceCreamIs.is().selected(is(defaultText));
        iceCreamIs.select(Vanilla);
        iceCreamIs.is().text(containsString("Van"));
    }

    @Test
    public void assertValidationTest() {
        iceCreamIs.assertThat().text(is(defaultText));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(iceCreamIs);
    }
}
