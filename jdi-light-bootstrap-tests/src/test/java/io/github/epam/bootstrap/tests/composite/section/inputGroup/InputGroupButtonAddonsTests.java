package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupButtonAddons1;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class InputGroupButtonAddonsTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView(true);";
    private static final String HEADER_RIGHT_PART = "//h4[contains(., 'Input group - Button addons')]";
    private String text = "XA-XA",
       placeholder_text = "Recipient's username";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        ((JavascriptExecutor) getDriver()).executeScript(JS_SCROLL_TO_ELEMENT, getDriver().findElement(By.xpath(HEADER_RIGHT_PART)));
    }

    @Test
    public void checkButtonAddon1Test() {
        inputGroupButtonAddons1.input1.input(text);
        inputGroupButtonAddons1.button1.click();
        inputGroupButtonAddons1.input1.assertThat().text(text);
    }
}
