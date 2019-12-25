package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.name;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Test examples for TextField with JDI Light asserts
 */
public class TextFieldExampleTests implements TestsInit {

    private static String text = "TextField";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void setTextTest() {
        name.setText(text);
        name.is().text(text);
        name.is().text(is(text));
        name.is().text(containsString("Field"));
    }

    @Test
    public void sendKeysTest() {
        name.setText(text);
        name.sendKeys("Test");
        name.is().text(text + "Test");
    }

    @Test
    public void clearTest() {
        name.clear();
        name.is().text("");
    }

    @Test
    public void inputTest() {
        name.input(text);
        name.is().text(text);
    }

    @Test
    public void labelTest() {
        name.label().is().text("Your name:");
        name.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void isValidationTest() {
        disabledName.is()
                .displayed()
                .and()
                .disabled();
        name.is()
                .enabled()
                .and()
                .displayed();
    }
}
