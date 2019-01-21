package io.github.epam.html.tests.elements.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

import static io.github.com.StaticSite.*;
import static io.github.com.enums.Navigation.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class MenuTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void selectTest() {
        leftMenu.select("Contact form");
        contactFormPage.checkOpened();
    }

    @Test
    public void selectEnumTest() {
        leftMenu.select(MetalsColors);
        metalAndColorsPage.checkOpened();
    }
    @Test
    public void selectListTest() {
        leftMenu.select("Service", "Dates");
        datesPage.checkOpened();
    }
    @Test
    public void selectEnumListTest() {
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
    }

    @Test
    public void isValidationTest() {
        leftMenu.is().selected(HTML5);
        leftMenu.is().values(hasItem(ContactForm.value));
    }

    @Test
    public void assertValidationTest() {
        leftMenu.assertThat().allEnabled();
        leftMenu.assertThat().allDisplayed();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(leftMenu);
    }
}
