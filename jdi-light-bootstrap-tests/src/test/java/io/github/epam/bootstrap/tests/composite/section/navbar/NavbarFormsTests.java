package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.getAlertText;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertEquals;

public class NavbarFormsTests extends TestsInit {

    private final String inputText = "This is input in navbar";
    private final String navbarText = "Navbar";
    private final String buttonText = "Search";
    private final String alertText = "Search Main Button Clicked!";
    private final String alertTextOnClickAtSmallButton = "Search Smaller Button Clicked!";
    private final String placeholderText = "Username";
    private final String inputGroupText = "@";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxesCustom.hover();
    }

    @Test
    public void setValueText() {
        navbarForm.textField.setValue(inputText);
        navbarForm.textField.assertThat().text(is(inputText));
    }

    @Test
    public void clickButtonTest() {
        navbarForm.button.click();
        assertEquals(getAlertText(), alertText);
    }

    @Test
    public void checkFormElements() {
        UIElement input = navbarFormWithText.form.core().find((By.tagName("input")));
        UIElement button = navbarFormWithText.form.core().find((By.tagName("button")));
        input.shouldBe().enabled();
        button.shouldBe().enabled().text(is(buttonText));
        navbarFormWithText.form.click();
    }

    @Test
    public void clickButtonOnFormWithTextTest() {
        navbarFormWithText.button.click();
        assertEquals(getAlertText(), alertTextOnClickAtSmallButton);
    }

    @Test
    public void checkTextOnFormWithTextTest() {
        navbarFormWithText.textLink.assertThat().text(is(navbarText));
    }

    @Test
    public void checkFormWithInputGroupElements() {
        UIElement inputGroup = navbarFormWithInputGroup.form.core().find((By.className("input-group")));
        UIElement input = navbarFormWithInputGroup.form.core().find((By.tagName("input")));
        UIElement text = navbarFormWithInputGroup.form.core().find((By.tagName("span")));
        inputGroup.shouldBe().displayed().enabled();
        input.shouldBe().enabled();
        assertEquals(input.placeholder(), placeholderText);
        text.shouldBe().enabled().text(is(inputGroupText));
    }

    @Test
    public void checkSetValueInputGroup() {
        navbarFormWithInputGroup.inputGroup.input.setValue(inputText);
        navbarFormWithInputGroup.inputGroup.input.assertThat().text(is(inputText));
    }

    @Test
    public void checkPlaceholderInputGroup() {
        assertEquals(navbarFormWithInputGroup.inputGroup.input.placeholder(), placeholderText);
    }

    @Test
    public void checkTextInputGroupTest() {
        navbarFormWithInputGroup.inputGroup.text.assertThat().text(is(inputGroupText));
    }
}
