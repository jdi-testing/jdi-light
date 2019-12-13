package io.github.epam.exapmle.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.acceptConditions;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class CheckboxExampleTests implements TestsInit {

    String labelText = "Accept terms and conditions";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        acceptConditions.check();
    }

    @Test
    public void getLabelTextTest() {
        acceptConditions.label().is().text(labelText);
    }

    @Test
    public void checkTest() {
        acceptConditions.check();
        acceptConditions.is().selected();
    }

    @Test
    public void uncheckTest() {
        acceptConditions.uncheck();
        acceptConditions.is().deselected();
    }

    @Test
    public void clickTest() {
        acceptConditions.isSelected();
        acceptConditions.click();
        acceptConditions.isSelected();
    }

    @Test
    public void assertValidationTest() {
        acceptConditions.assertThat().selected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(acceptConditions);
    }
}
