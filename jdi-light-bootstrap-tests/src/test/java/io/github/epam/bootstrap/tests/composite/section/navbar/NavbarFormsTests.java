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

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxesCustom.hover();
    }

    String inputText = "This is input in navbar";
    String navbarText = "Navbar";
    String buttonText = "Search";
    String alertText = "Search Main Button Clicked!";

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
        navbarForm.form.click();
    }

    @Test
    public void checkFormWithInputGroupElements() {
        UIElement inputGroup = navbarFormWithInputGroup.form.core().find((By.className("input-group")));
        UIElement input = navbarFormWithInputGroup.form.core().find((By.tagName("input")));
        UIElement text = navbarFormWithInputGroup.form.core().find((By.tagName("span")));
        inputGroup.shouldBe().displayed().enabled();
        input.shouldBe().enabled();
        assertEquals(input.placeholder(), "Username");
        text.shouldBe().enabled().text(is("@"));
    }

    @Test
    public void checkSetValueInputGroup() {
        navbarForm.textField.assertThat().text(is(inputText));
    }

    @Test
    public void checkTextTest() {
        navbarFormWithText.text.assertThat().text(is(navbarText));
    }

}
