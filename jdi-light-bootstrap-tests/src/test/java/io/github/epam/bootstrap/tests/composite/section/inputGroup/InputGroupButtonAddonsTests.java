package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class InputGroupButtonAddonsTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView(true);";
    private static final String HEADER_RIGHT_PART = "//h4[.='Input group - Button addons']";
    private String text = "XA-XA",
       placeholder_text = "Recipient's username";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        ((JavascriptExecutor) getDriver()).executeScript(JS_SCROLL_TO_ELEMENT, getDriver().findElement(By.xpath(HEADER_RIGHT_PART)));
    }

// Button addons tests
    @Test
    public void checkButtonAddon1Test() {
        inputGroupButtonAddons1.input.input(text);
        inputGroupButtonAddons1.button.click();
        inputGroupButtonAddons1.input.assertThat().text(text);
    }

    @Test
    public void checkButtonAddon2Test() {
        inputGroupButtonAddons2.input.input(text);
        inputGroupButtonAddons2.button.click();
        inputGroupButtonAddons2.input.input(placeholder_text);
        inputGroupButtonAddons2.input.assertThat().text(placeholder_text);
    }

    @Test
    public void checkButtonAddon3Test() {
        inputGroupButtonAddons3.inputField.input(text);
        inputGroupButtonAddons3.listButtons.get(1).click();
        inputGroupButtonAddons3.listButtons.get(2).click();
        inputGroupButtonAddons3.inputField.assertThat().text(text);
    }

    @Test
    public void checkButtonAddon4Test() {
        inputGroupButtonAddons4.inputField.input(text);
        inputGroupButtonAddons4.listButtons.get(1).click();
        inputGroupButtonAddons4.inputField.input(placeholder_text);
        inputGroupButtonAddons4.listButtons.get(2).click();
        inputGroupButtonAddons4.inputField.assertThat().text(placeholder_text);
    }
}
