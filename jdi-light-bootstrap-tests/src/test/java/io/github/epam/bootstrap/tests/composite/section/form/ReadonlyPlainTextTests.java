package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.readonlyPlainText1;
import static io.github.com.pages.BootstrapPage.readonlyPlainText2;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;

public class ReadonlyPlainTextTests extends TestsInit {

    private static final String plainTextValue = "email@example.com";
    private static final String labelTextValue = "Email";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(readonlyPlainText1);
        readonlyPlainText1.unhighlight();
        baseValidation(readonlyPlainText2);
        readonlyPlainText2.unhighlight();
    }

    @Test
    public void isValidationTest() {
        readonlyPlainText1.hasClass("form-control-plaintext");
        readonlyPlainText1.hasAttribute("readonly");
        assertEquals(readonlyPlainText1.attr("type"), "text");

        readonlyPlainText2.hasClass("form-control-plaintext");
        readonlyPlainText2.hasAttribute("readonly");
        assertEquals(readonlyPlainText2.attr("type"), "text");
    }

    @Test
    public void textValidationTest() {
        readonlyPlainText1.assertThat().text(plainTextValue);
        readonlyPlainText2.assertThat().text(plainTextValue);
    }

    @Test
    public void valueValidationTest() {
        assertEquals(readonlyPlainText1.getValue(), plainTextValue);
        assertEquals(readonlyPlainText2.getValue(), plainTextValue);
}

    @Test
    public void labelTest() {
        assertEquals(readonlyPlainText1.labelText(), labelTextValue);
        readonlyPlainText1.label().is().text(containsString(labelTextValue));
        assertEquals(readonlyPlainText2.labelText(), labelTextValue);
        readonlyPlainText2.label().is().text(containsString(labelTextValue));
    }
}
