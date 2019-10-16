package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputRange;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class InputRangeTests extends TestsInit {

    private final String rangeLabel = "Example Range input";
    private final String rangeClass = "form-control-range";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(inputRange);
        inputRange.unhighlight();
    }

    @Test
    public void itemHasProperClass() {
        inputRange.is().core().hasClass(rangeClass);
    }

    @Test
    public void itemHasProperType() {
        inputRange.is().core().attr("type", "range");
    }

    @Test
    public void labelValidationTest() {
        inputRange.label().is().text(rangeLabel);
    }
}
