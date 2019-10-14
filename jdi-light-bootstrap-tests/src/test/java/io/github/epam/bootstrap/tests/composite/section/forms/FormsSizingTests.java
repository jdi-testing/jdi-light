package io.github.epam.bootstrap.tests.composite.section.forms;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formsSizing;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Aleksandr Khmelinin on 14.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class FormsSizingTests extends TestsInit {

    private String text = "TextField";
    private String placeholderLarge = ".form-control-lg";
    private String placeholderDefault = "Default input";
    private String placeholderSmall = ".form-control-sm";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        formsSizing.largeTextField.setText(text);
        formsSizing.defaultTextField.setText(text);
        formsSizing.smallTextField.setText(text);
    }

    @Test
    public void getTextTest() {
        assertEquals(formsSizing.largeTextField.getText(), text);
        assertEquals(formsSizing.defaultTextField.getText(), text);
        assertEquals(formsSizing.smallTextField.getText(), text);
    }

    @Test
    public void sendKeysTest() {
        formsSizing.largeTextField.sendKeys("Test");
        formsSizing.defaultTextField.sendKeys("Test");
        formsSizing.smallTextField.sendKeys("Test");
        assertEquals(formsSizing.largeTextField.getText(), text+"Test");
        assertEquals(formsSizing.defaultTextField.getText(), text+"Test");
        assertEquals(formsSizing.smallTextField.getText(), text+"Test");
    }

    @Test
    public void placeholderTest() {
        assertEquals(formsSizing.largeTextField.placeholder(), placeholderLarge);
        assertEquals(formsSizing.defaultTextField.placeholder(), placeholderDefault);
        assertEquals(formsSizing.smallTextField.placeholder(), placeholderSmall);
    }

    @Test
    public void selectOptionTest() {
        formsSizing.largeSelect.select("Large select");
        assertEquals(formsSizing.largeSelect.getValue(), "Large select");
        formsSizing.defaultSelect.select("Default select");
        assertEquals(formsSizing.defaultSelect.getValue(), "Default select");
        formsSizing.smallSelect.select("Small select");
        assertEquals(formsSizing.smallSelect.getValue(), "Small select");
    }

    @Test
    public void isValidationTest() {
        formsSizing.largeTextField.is().enabled().text(is(text));
        formsSizing.defaultTextField.is().enabled().text(is(text));
        formsSizing.smallTextField.is().enabled().text(is(text));
        formsSizing.largeSelect.is().displayed().selected("Large select");
        formsSizing.defaultSelect.is().displayed().selected("Default select");
        formsSizing.smallSelect.is().displayed().selected("Small select");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(formsSizing.largeTextField);
        baseValidation(formsSizing.defaultTextField);
        baseValidation(formsSizing.smallTextField);
        baseValidation(formsSizing.largeSelect);
        baseValidation(formsSizing.defaultSelect);
        baseValidation(formsSizing.smallSelect);
    }
}
