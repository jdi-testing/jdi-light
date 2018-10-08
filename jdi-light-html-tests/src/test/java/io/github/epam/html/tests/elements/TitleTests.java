package io.github.epam.html.tests.elements;

import com.epam.jdi.light.elements.base.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.*;
import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class TitleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
    }
    String text = "JDI TESTING PLATFORM";

    @Test
    public void getTextTest() {
        assertEquals(jdiTitle.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(jdiTitle.getValue(), text);
    }

    @Test
    public void clickTest() {
        jdiTitle.click();
        assertEquals(alert().getText(), "JDI Title");
        alert().accept();
    }

    @Test
    public void isValidationTest() {
        jdiTitle.is().text(is(text));
        jdiTitle.is().text(equalToIgnoringCase("jdi TESTING platform"));
    }

    @Test
    public void assertValidationTest() {
        jdiTitle.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(jdiTitle);
    }
}
