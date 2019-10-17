package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.com.sections.form.ReadonlyPlainText;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.readonlyPlainText1;
import static io.github.com.pages.BootstrapPage.readonlyPlainText2;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertTrue;

public class ReadonlyPlainTextTests extends TestsInit {

    private static final String plainTextValue = "email@example.com";
    private static final String labelTextValue = "Email";

    @DataProvider
    public static Object[] itemsUnderTesting() {
        return new Object[]{readonlyPlainText1, readonlyPlainText2};
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test(dataProvider = "itemsUnderTesting")
    public void baseValidationTest(ReadonlyPlainText item) {
        baseValidation(item);
        item.unhighlight();
    }

    @Test(dataProvider = "itemsUnderTesting")
    public void isValidationTest(ReadonlyPlainText item) {
        item.is().core().hasClass("form-control-plaintext");
        assertTrue(item.hasAttribute("readonly"));
        item.is().core().attr("type", "text");
    }

    @Test(dataProvider = "itemsUnderTesting")
    public void textValidationTest(ReadonlyPlainText item) {
        item.is().text(plainTextValue);
    }

    @Test(dataProvider = "itemsUnderTesting")
    public void valueValidationTest(ReadonlyPlainText item) {
        item.is().value(plainTextValue);
    }

    @Test(dataProvider = "itemsUnderTesting")
    public void labelTest(ReadonlyPlainText item) {
        item.label().is().text(labelTextValue);
    }
}
